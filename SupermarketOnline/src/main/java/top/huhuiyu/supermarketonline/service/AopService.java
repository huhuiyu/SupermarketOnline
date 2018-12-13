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
   * @return
   * @throws Exception
   */
  TbToken createOrUpdateToken(TbToken token) throws Exception;

}
