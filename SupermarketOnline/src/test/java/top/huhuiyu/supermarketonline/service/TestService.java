package top.huhuiyu.supermarketonline.service;

import top.huhuiyu.supermarketonline.utils.JsonMessage;
import top.huhuiyu.supermarketonline.utils.PageBean;

/**
 * - 测试服务
 *
 * @author DarkKnight
 *
 */
public interface TestService {

  /**
   * -分页查询token
   *
   * @param page
   * @return
   * @throws Exception
   */
  JsonMessage queryTokens(PageBean page) throws Exception;

}
