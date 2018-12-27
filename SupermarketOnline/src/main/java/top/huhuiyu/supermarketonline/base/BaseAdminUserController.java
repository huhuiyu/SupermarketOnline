package top.huhuiyu.supermarketonline.base;

import top.huhuiyu.supermarketonline.aop.NeedAdminUser;
import top.huhuiyu.supermarketonline.entity.TbAdminUser;

public abstract class BaseAdminUserController implements NeedAdminUser {

  /**
   * 登录用户信息
   */
  private TbAdminUser user;

  @Override
  public TbAdminUser getUser() {
    return user;
  }

  @Override
  public void setUser(TbAdminUser user) {
    this.user = user;
  }
}
