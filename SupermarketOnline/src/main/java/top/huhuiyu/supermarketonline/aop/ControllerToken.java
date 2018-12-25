package top.huhuiyu.supermarketonline.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.huhuiyu.supermarketonline.base.BaseAop;
import top.huhuiyu.supermarketonline.base.BaseModel;
import top.huhuiyu.supermarketonline.entity.TbAdminUser;
import top.huhuiyu.supermarketonline.entity.TbToken;
import top.huhuiyu.supermarketonline.service.AopService;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * -控制器token处理
 *
 * @author DarkKnight
 *
 */
@Aspect
@Component
public class ControllerToken extends BaseAop {

  private static final int LOG_FAIL = 1000;

  private static final Logger log = LoggerFactory.getLogger(ControllerToken.class);

  @Autowired
  private AopService aopService;

  private TbToken processInputToken(ProceedingJoinPoint pjp) throws Exception {
    TbToken token = null;
    BaseModel model = null;
    // 校验是否存在BaseModel参数
    boolean haveBaseModel = false;
    Object[] args = pjp.getArgs();
    for (Object arg : args) {
      if (arg instanceof BaseModel) {
        // 获取客户端token
        haveBaseModel = true;
        model = (BaseModel) arg;
        token = model.makeTbToken();
        break;
      }
    }
    // 处理token信息更新
    token = aopService.createOrUpdateToken(token);
    if (haveBaseModel) {
      // 更新model中的token信息
      model.setToken(token.getToken());
    }
    return token;
  }

  private void processResponseToken(Object result, TbToken token) throws Exception {
    // 回发token信息
    if (result instanceof JsonMessage && token != null) {
      JsonMessage json = (JsonMessage) result;
      json.setToken(token.getToken());
    }
  }

  private JsonMessage checkNeedUser(ProceedingJoinPoint pjp, TbToken token) throws Exception {
    // 处理需要登录的情况
    Object target = pjp.getTarget();
    log.debug(String.format("登录检测：%s", target));
    if (!(target instanceof NeedAdminUser)) {
      return null;
    }
    if (token == null) {
      return null;
    }
    // 只有实现NeedAdminUser接口的控制器且token不为空才需要登录检测
    NeedAdminUser nau = (NeedAdminUser) target;
    TbAdminUser user = aopService.checkAdminUser(token);
    if (user == null) {
      return JsonMessage.getFail(LOG_FAIL, "需要登录");
    }
    nau.setUser(user);
    return null;
  }

  @Around("controllerPointcut()")
  public Object token(ProceedingJoinPoint pjp) throws Throwable {
    TbToken token = processInputToken(pjp);
    JsonMessage check = checkNeedUser(pjp, token);
    // 如果有返回值，表示检测失败
    if (check != null) {
      return check;
    }
    Object result = null;
    // 处理业务逻辑
    result = pjp.proceed();
    // 回发token信息
    processResponseToken(result, token);
    return result;
  }

}
