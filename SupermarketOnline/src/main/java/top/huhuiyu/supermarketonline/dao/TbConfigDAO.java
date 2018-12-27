package top.huhuiyu.supermarketonline.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.supermarketonline.entity.TbConfig;

/**
 * TbConfig的dao
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TbConfigDAO {

  /**
   * 查询网站标题配置
   * 
   * @return 网站标题配置
   * @throws Exception 处理发生异常
   */
  TbConfig queryTitle() throws Exception;

  /**
   * 修改网站标题配置
   * 
   * @param config 网站标题配置
   * @return 修改网站标题配置结果
   * @throws Exception 处理发生异常
   */
  int updateTitle(TbConfig config) throws Exception;

  /**
   * 查询token过期时间配置
   * 
   * @return token过期时间配置
   * @throws Exception 处理发生异常
   */
  TbConfig queryTokenTimeout() throws Exception;

  /**
   * 修改token过期时间配置
   * 
   * @param config token过期时间配置
   * @return 修改token过期时间配置结果
   * @throws Exception 处理发生异常
   */
  int updateTokenTimeout(TbConfig config) throws Exception;
}
