package top.huhuiyu.supermarketonline.service;

import top.huhuiyu.supermarketonline.model.TbSubTypeModel;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * TbSubType服务层
 * 
 * @author DarkKnight
 *
 */
public interface SubTypeService {

  /**
   * 禁用
   * 
   * @param model 页面数据
   * @return 禁用结果
   * @throws Exception 处理发生异常
   */
  JsonMessage disable(TbSubTypeModel model) throws Exception;

  /**
   * 启用
   * 
   * @param model 页面数据
   * @return 启用结果
   * @throws Exception 处理发生异常
   */
  JsonMessage enable(TbSubTypeModel model) throws Exception;

  /**
   * 修改
   * 
   * @param model 页面数据
   * @return 修改结果
   * @throws Exception 处理发生异常
   */
  JsonMessage update(TbSubTypeModel model) throws Exception;

  /**
   * 添加
   * 
   * @param model 页面数据
   * @return 添加结果
   * @throws Exception 处理发生异常
   */
  JsonMessage add(TbSubTypeModel model) throws Exception;

  /**
   * 查询
   * 
   * @param model 页面数据
   * @return 查询结果
   * @throws Exception 处理发生异常
   */
  JsonMessage queryAll(TbSubTypeModel model) throws Exception;

}
