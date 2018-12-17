package top.huhuiyu.supermarketonline.service;

import top.huhuiyu.supermarketonline.entity.TbToken;

/**
 * -切面用的服务类
 *
 * @author DarkKnight
 *
 */
public interface AopService {

  /**
   * -创建或者更新token
   *
   * @param token 客户端传入的token
   * @return 创建或者更新的结果
   * @throws Exception 处理发生错误
   */
  TbToken createOrUpdateToken(TbToken token) throws Exception;

}
