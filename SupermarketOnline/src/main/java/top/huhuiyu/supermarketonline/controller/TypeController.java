package top.huhuiyu.supermarketonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.supermarketonline.model.TbTypeModel;
import top.huhuiyu.supermarketonline.service.TypeService;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * 
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/type")
public class TypeController {
  @Autowired
  private TypeService typeService;

  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbTypeModel model) throws Exception {
    return typeService.queryAll(model);
  }

  @RequestMapping("/add")
  public JsonMessage add(TbTypeModel model) throws Exception {
    return typeService.add(model);
  }

  @RequestMapping("/queryByKey")
  public JsonMessage queryByKey(TbTypeModel model) throws Exception {
    return typeService.queryByKey(model);
  }

  @RequestMapping("/delete")
  public JsonMessage delete(TbTypeModel model) throws Exception {
    return typeService.delete(model);
  }

  @RequestMapping("/update")
  public JsonMessage update(TbTypeModel model) throws Exception {
    return typeService.update(model);
  }

}
