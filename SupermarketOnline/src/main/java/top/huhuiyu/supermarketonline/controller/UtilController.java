package top.huhuiyu.supermarketonline.controller;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.supermarketonline.entity.TbTokenInfo;
import top.huhuiyu.supermarketonline.model.ConfigModel;
import top.huhuiyu.supermarketonline.model.UtilModel;
import top.huhuiyu.supermarketonline.service.ConfigService;
import top.huhuiyu.supermarketonline.service.UtilService;
import top.huhuiyu.supermarketonline.utils.ImageCode;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * -工具类控制器
 *
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/util")
public class UtilController {

  @Autowired
  private UtilService utilService;
  @Autowired
  private ConfigService configService;

  @RequestMapping("/validate.jpg")
  public void imageCode(UtilModel model, HttpServletResponse response) throws Exception {
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    ImageIO.write(ImageCode.makeImage(utilService.imageCode(tokenInfo)), "jpeg", response.getOutputStream());
  }

  @RequestMapping("/queryWebConfig")
  public JsonMessage queryWebConfig(ConfigModel model) throws Exception {
    return configService.queryWebConfig(model);
  }

}
