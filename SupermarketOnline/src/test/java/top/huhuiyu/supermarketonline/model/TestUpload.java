package top.huhuiyu.supermarketonline.model;

import top.huhuiyu.supermarketonline.base.BaseEntity;

/**
 * -文件上传信息
 * 
 * @author DarkKnight
 *
 */
public class TestUpload extends BaseEntity {

  private static final long serialVersionUID = 5273204603830013857L;

  private String contentType;
  private String filename;
  private long size;
  private String url;

  public TestUpload() {
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
