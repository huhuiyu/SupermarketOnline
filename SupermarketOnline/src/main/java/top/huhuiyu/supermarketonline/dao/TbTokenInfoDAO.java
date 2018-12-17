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
   * @return 删除的结果
   * @throws Exception 处理发生错误
   */
  int deleteTokenInfos() throws Exception;

  /**
   * -查询图片校验码是否存在
   *
   * @param tokenInfo 查询数据
   * @return 查询结果
   * @throws Exception 处理发生错误
   */
  TbTokenInfo queryImageCodeByToken(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -添加图片校验码
   *
   * @param tokenInfo 添加数据
   * @return 添加结果
   * @throws Exception 处理发生错误
   */
  int addImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -更新图片校验码
   *
   * @param tokenInfo 更新数据
   * @return 更新结果
   * @throws Exception 处理发生错误
   */
  int updateImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -删除图片校验码
   *
   * @param tokenInfo 删除数据
   * @return 删除结果
   * @throws Exception 处理发生错误
   */
  int deleteImageCode(TbTokenInfo tokenInfo) throws Exception;

}
