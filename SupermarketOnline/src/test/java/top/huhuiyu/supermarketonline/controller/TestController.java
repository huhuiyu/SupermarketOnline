package top.huhuiyu.supermarketonline.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import top.huhuiyu.supermarketonline.entity.TbTokenInfo;
import top.huhuiyu.supermarketonline.model.TestModel;
import top.huhuiyu.supermarketonline.model.TestUpload;
import top.huhuiyu.supermarketonline.service.TestService;
import top.huhuiyu.supermarketonline.service.UtilService;
import top.huhuiyu.supermarketonline.utils.JsonMessage;

/**
 * -测试控制器
 *
 * @author DarkKnight
 *
 */
@RestController
@RequestMapping("/test")
public class TestController {
  /**
   * -上传文件目录
   */
  public static final String UPLOAD = "/uploadfiles/";

  @Autowired
  private TestService testService;
  @Autowired
  private UtilService utilService;

  @RequestMapping("queryTokens")
  public JsonMessage queryTokens(TestModel model) throws Exception {
    // {"page.pageNumber":1,"page.pageSize":5}
    return testService.queryTokens(model.getPage());
  }

  @RequestMapping("/checkImageCode")
  public JsonMessage checkImageCode(TestModel model) throws Exception {
    // {"imageCode":""}
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    tokenInfo.setInfo(model.getImageCode());
    boolean result = utilService.checkImageCode(tokenInfo);
    return result ? JsonMessage.getSuccess("图片校验码正确") : JsonMessage.getFail("图片校验码错误");
  }

  @RequestMapping("/upload")
  public JsonMessage upload(TestModel model, MultipartFile file) throws Exception {
    if (file == null || file.isEmpty()) {
      return JsonMessage.getFail("没有上传文件！");
    }
    TestUpload upload = new TestUpload();
    upload.setContentType(file.getContentType());
    upload.setFilename(file.getOriginalFilename());
    upload.setSize(file.getSize());
    File savefile = new File(System.getProperty("user.dir") + UPLOAD, UUID.randomUUID().toString());
    if (!savefile.getParentFile().exists()) {
      savefile.getParentFile().mkdirs();
    }
    upload.setUrl(UPLOAD + savefile.getName());
    InputStream is = file.getInputStream();
    OutputStream os = new FileOutputStream(savefile);
    byte[] bytes = new byte[8 * 1024];
    int len = is.read(bytes);
    while (len > 0) {
      os.write(bytes, 0, len);
      os.flush();
      len = is.read(bytes);
    }
    is.close();
    os.close();
    JsonMessage message = JsonMessage.getSuccess("上传成功！" + model.getImageCode());
    message.getDatas().put("upfile", upload);
    return message;
  }

}
