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
    // /type/queryAll?token=011c9827-ac6c-48fa-9425-c9d9ee4941f8
    return typeService.queryAll(model);
  }

  @RequestMapping("/add")
  public JsonMessage add(TbTypeModel model) throws Exception {
    // /type/add?token=011c9827-ac6c-48fa-9425-c9d9ee4941f8&tbType.typeName=服装&tbType.typeInfo=服装类别
    return typeService.add(model);
  }

}
