package top.huhuiyu.supermarketonline.service;

import top.huhuiyu.supermarketonline.model.ConfigModel;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * 配置管理服务
 * 
 * @author DarkKnight
 *
 */
public interface ConfigService {

  /**
   * 修改token过期时间
   * 
   * @param model 页面提交数据
   * @return 修改token过期时间结果
   * @throws Exception 处理发生错误
   */
  JsonMessage updateTokenTimeout(ConfigModel model) throws Exception;

  /**
   * 查询后台配置
   * 
   * @param model 页面提交数据
   * @return 后台配置
   * @throws Exception 处理发生错误
   */
  JsonMessage queryConfig(ConfigModel model) throws Exception;

  /**
   * 修改网站标题
   * 
   * @param model 页面提交数据
   * @return 修改网站标题结果
   * @throws Exception 处理发生错误
   */
  JsonMessage updateTitle(ConfigModel model) throws Exception;

  /**
   * 查询前端配置
   * 
   * @param model 页面提交数据
   * @return 前端配置
   * @throws Exception 处理发生错误
   */
  JsonMessage queryWebConfig(ConfigModel model) throws Exception;

}
