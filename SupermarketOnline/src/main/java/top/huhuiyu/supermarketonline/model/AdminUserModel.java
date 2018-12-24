package top.huhuiyu.supermarketonline.model;

import top.huhuiyu.supermarketonline.base.BaseModel;
import top.huhuiyu.supermarketonline.entity.TbAdminUser;

/**
 * 管理用户model
 * 
 * @author DarkKnight
 *
 */
public class AdminUserModel extends BaseModel {
  private static final long serialVersionUID = -1942473558694214473L;

  private TbAdminUser user = new TbAdminUser();

  public AdminUserModel() {
  }

  public TbAdminUser getUser() {
    return user;
  }

  public void setUser(TbAdminUser user) {
    this.user = user;
  }

}
