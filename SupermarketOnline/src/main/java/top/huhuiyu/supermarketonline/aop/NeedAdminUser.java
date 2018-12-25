package top.huhuiyu.supermarketonline.aop;

import top.huhuiyu.supermarketonline.entity.TbAdminUser;

/**
 * 需要登录的接口定义
 * 
 * @author DarkKnight
 *
 */
public interface NeedAdminUser {
  /**
   * 设置登录用户信息
   * 
   * @param user 登录用户信息
   */
  public void setUser(TbAdminUser user);

  /**
   * 获取登录用户信息
   * 
   * @return 登录用户信息
   */
  public TbAdminUser getUser();
}
