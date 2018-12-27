package top.huhuiyu.supermarketonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.supermarketonline.base.BaseAdminUserController;
import top.huhuiyu.supermarketonline.model.ConfigModel;
import top.huhuiyu.supermarketonline.service.ConfigService;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * 后台配置控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/config")
public class ConfigController extends BaseAdminUserController {
  @Autowired
  private ConfigService configService;

  @RequestMapping("/queryConfig")
  public JsonMessage queryConfig(ConfigModel model) throws Exception {
    return configService.queryConfig(model);
  }

  @RequestMapping("/updateTokenTimeout")
  public JsonMessage updateTokenTimeout(ConfigModel model) throws Exception {
    return configService.updateTokenTimeout(model);
  }

  @RequestMapping("/updateTitle")
  public JsonMessage updateTitle(ConfigModel model) throws Exception {
    return configService.updateTitle(model);
  }
}
