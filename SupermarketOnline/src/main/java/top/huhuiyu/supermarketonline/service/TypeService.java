package top.huhuiyu.supermarketonline.service;

import top.huhuiyu.supermarketonline.model.TbTypeModel;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * TbType服务
 * 
 * @author DarkKnight
 *
 */
public interface TypeService {

  /**
   * 查询全部
   * 
   * @param model 页面数据
   * @return 查询结果
   * @throws Exception 处理发生异常
   */
  JsonMessage queryAll(TbTypeModel model) throws Exception;

  /**
   * 添加
   * 
   * @param model 页面数据
   * @return 添加结果
   * @throws Exception 处理发生异常
   */
  JsonMessage add(TbTypeModel model) throws Exception;
}
