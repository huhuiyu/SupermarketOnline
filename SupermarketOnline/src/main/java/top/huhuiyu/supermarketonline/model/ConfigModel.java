package top.huhuiyu.supermarketonline.model;

import top.huhuiyu.supermarketonline.base.BaseModel;
import top.huhuiyu.supermarketonline.entity.TbConfig;

/**
 * TbConfig的model
 * 
 * @author DarkKnight
 *
 */
public class ConfigModel extends BaseModel {
  private static final long serialVersionUID = 2613295893588200580L;

  private TbConfig config = new TbConfig();

  public ConfigModel() {
  }

  public TbConfig getConfig() {
    return config;
  }

  public void setConfig(TbConfig config) {
    this.config = config;
  }

}
