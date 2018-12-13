package top.huhuiyu.supermarketonline.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.supermarketonline.entity.TbToken;

/**
 * TbToken-数据访问类
 *
 * @author DarkKnight
 *
 */
@Mapper
public interface TbTokenDAO {
  /**
   * addToken-添加token
   *
   * @param token
   * @return
   * @throws Exception
   */
  int addToken(TbToken token) throws Exception;

  /**
   * updateToken-更新token时间
   *
   * @param token
   * @return
   * @throws Exception
   */
  int updateToken(TbToken token) throws Exception;

  /**
   * queryToken-查询token是否存在
   *
   * @param token
   * @return
   * @throws Exception
   */
  TbToken queryToken(TbToken token) throws Exception;

  /**
   * deleteTokens-删除过期的token
   *
   * @return
   * @throws Exception
   */
  int deleteTokens() throws Exception;

}
