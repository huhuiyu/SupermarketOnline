package top.huhuiyu.supermarketonline.entity;

import java.util.Date;

import top.huhuiyu.supermarketonline.base.BaseEntity;

/**
 * TbToken表
 *
 * @author DarkKnight
 *
 */
public class TbToken extends BaseEntity {

  private static final long serialVersionUID = -2313018616200398517L;
  private String token;
  private Date lastupdate;

  public TbToken() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
