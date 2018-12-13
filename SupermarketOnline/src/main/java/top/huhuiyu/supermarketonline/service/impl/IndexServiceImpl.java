package top.huhuiyu.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.huhuiyu.supermarketonline.config.MyConfig;
import top.huhuiyu.supermarketonline.converter.DateConverter;
import top.huhuiyu.supermarketonline.dao.UtilsDAO;
import top.huhuiyu.supermarketonline.service.IndexService;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 *
 * @author DarkKnight
 *
 */
@Service
public class IndexServiceImpl implements IndexService {
  @Autowired
  private MyConfig myConfig;
  @Autowired
  private UtilsDAO utilsDAO;

  @Override
  public JsonMessage index() throws Exception {
    JsonMessage message = JsonMessage.getSuccess(String.format("欢迎使用%s，%s", myConfig.appName, DateConverter.SDF_LONG.format(utilsDAO.queryTime())));
    return message;
  }

}
