package top.huhuiyu.supermarketonline.base;

import top.huhuiyu.supermarketonline.aop.NeedAdminUser;
import top.huhuiyu.supermarketonline.entity.TbAdminUser;

/**
 * 带登录控制的控制器
 * 
 * @author DarkKnight
 *
 */
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
