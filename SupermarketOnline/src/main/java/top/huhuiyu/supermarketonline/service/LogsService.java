package top.huhuiyu.supermarketonline.service;

import top.huhuiyu.supermarketonline.model.LogsModel;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * TbLogs的Service
 * 
 * @author DarkKnight
 *
 */
public interface LogsService {

  /**
   * 查询TbLogs信息
   * 
   * @param model 页面参数
   * @return TbLogs信息
   * @throws Exception 处理发生异常
   */
  JsonMessage queryAll(LogsModel model) throws Exception;

}
