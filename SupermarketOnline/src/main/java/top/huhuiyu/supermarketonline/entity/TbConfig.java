package top.huhuiyu.supermarketonline.entity;

import java.util.Date;

import top.huhuiyu.supermarketonline.base.BaseEntity;

/**
 * TbConfig表
 * 
 * @author DarkKnight
 *
 */
public class TbConfig extends BaseEntity {
  private static final long serialVersionUID = -7674696878487189918L;

  private String configKey;
  private String configValue;
  private Date lastupdate;

  public TbConfig() {
  }

  public TbConfig(String configKey, String configValue, Date lastupdate) {
    this.configKey = configKey;
    this.configValue = configValue;
    this.lastupdate = lastupdate;
  }

  public String getConfigKey() {
    return configKey;
  }

  public void setConfigKey(String configKey) {
    this.configKey = configKey;
  }

  public String getConfigValue() {
    return configValue;
  }

  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
