package top.huhuiyu.supermarketonline.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.supermarketonline.entity.TbTokenInfo;

/**
 * TbTokenInfo表的dao
 *
 * @author DarkKnight
 *
 */
@Mapper
public interface TbTokenInfoDAO {

  /**
   * -删除过期的TokenInfo
   * 
   * @return
   * @throws Exception
   */
  int deleteTokenInfos() throws Exception;

  /**
   * -查询图片校验码是否存在
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  TbTokenInfo queryImageCodeByToken(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -添加图片校验码
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int addImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -更新图片校验码
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int updateImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -删除图片校验码
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int deleteImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -查询用户是否存在
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  TbTokenInfo queryUserByToken(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -添加用户
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int addUser(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -更新用户
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int updateUser(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -删除用户
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int deleteUser(TbTokenInfo tokenInfo) throws Exception;

}
