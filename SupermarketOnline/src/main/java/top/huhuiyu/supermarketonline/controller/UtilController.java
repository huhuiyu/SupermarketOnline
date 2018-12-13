package top.huhuiyu.supermarketonline.controller;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.supermarketonline.entity.TbTokenInfo;
import top.huhuiyu.supermarketonline.model.UtilModel;
import top.huhuiyu.supermarketonline.service.UtilService;
import top.huhuiyu.supermarketonline.utils.ImageCode;

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

  @RequestMapping("/validate.jpg")
  public void imageCode(UtilModel model, HttpServletResponse response) throws Exception {
    // http://127.0.0.1:14000/util/validate.jpg?token=5bc8c8a6-63c7-421e-905b-a89a9fd1bb63
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    ImageIO.write(ImageCode.makeImage(utilService.imageCode(tokenInfo)), "jpeg", response.getOutputStream());
  }

}
