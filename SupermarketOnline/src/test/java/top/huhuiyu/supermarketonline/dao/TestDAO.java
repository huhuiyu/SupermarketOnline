package top.huhuiyu.supermarketonline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.supermarketonline.entity.TbToken;

/**
 * -测试dao
 *
 * @author DarkKnight
 *
 */
@Mapper
public interface TestDAO {

  /**
   * -查询token
   *
   * @return
   * @throws Exception
   */
  List<TbToken> queryTokens() throws Exception;
}
