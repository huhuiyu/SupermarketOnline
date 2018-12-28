package top.huhuiyu.supermarketonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.supermarketonline.base.BaseAdminUserController;
import top.huhuiyu.supermarketonline.model.LogsModel;
import top.huhuiyu.supermarketonline.service.LogsService;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * TbLogs控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/logs")
public class LogsController extends BaseAdminUserController {
  @Autowired
  private LogsService logsService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(LogsModel model) throws Exception {
    return logsService.queryAll(model);
  }
}
