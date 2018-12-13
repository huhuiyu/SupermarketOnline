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
   * @return
   * @throws Exception
   */
  JsonMessage index() throws Exception;

}
