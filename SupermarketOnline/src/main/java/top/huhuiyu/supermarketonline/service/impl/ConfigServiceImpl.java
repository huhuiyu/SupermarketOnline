package top.huhuiyu.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.supermarketonline.dao.TbConfigDAO;
import top.huhuiyu.supermarketonline.model.ConfigModel;
import top.huhuiyu.supermarketonline.service.ConfigService;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * ConfigService实现类
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ConfigServiceImpl implements ConfigService {
  @Autowired
  private TbConfigDAO tbConfigDAO;

  @Override
  public JsonMessage queryWebConfig(ConfigModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.put("title", tbConfigDAO.queryTitle());
    return message;
  }

  @Override
  public JsonMessage queryConfig(ConfigModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.put("tokenTimeout", tbConfigDAO.queryTokenTimeout());
    message.put("title", tbConfigDAO.queryTitle());
    return message;
  }

  @Override
  public JsonMessage updateTokenTimeout(ConfigModel model) throws Exception {
    int result = tbConfigDAO.updateTokenTimeout(model.getConfig());
    return result == 1 ? JsonMessage.getSuccess("修改成功") : JsonMessage.getFail("修改失败");
  }

  @Override
  public JsonMessage updateTitle(ConfigModel model) throws Exception {
    int result = tbConfigDAO.updateTitle(model.getConfig());
    return result == 1 ? JsonMessage.getSuccess("修改成功") : JsonMessage.getFail("修改失败");
  }

}
