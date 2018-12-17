package top.huhuiyu.supermarketonline.model;

import top.huhuiyu.supermarketonline.base.BasePageModel;
import top.huhuiyu.supermarketonline.entity.TbType;

/**
 * TbType模型层
 * 
 * @author DarkKnight
 *
 */
public class TbTypeModel extends BasePageModel {

  private static final long serialVersionUID = -6711614333682550956L;

  private TbType tbType = new TbType();

  public TbTypeModel() {
  }

  public TbType getTbType() {
    return tbType;
  }

  public void setTbType(TbType tbType) {
    this.tbType = tbType;
  }
}
