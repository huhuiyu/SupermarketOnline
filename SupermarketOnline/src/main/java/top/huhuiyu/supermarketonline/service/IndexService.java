package top.huhuiyu.supermarketonline.service;

import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * Index服务类
 *
 * @author DarkKnight
 *
 */
public interface IndexService {

  /**
   * -首页显示信息
   * 
   * @return 首页信息
   * @throws Exception 处理发生异常
   */
  JsonMessage index() throws Exception;

}
