package top.huhuiyu.supermarketonline.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

/**
 * UtilsDAO-系统工具DAO
 *
 * @author DarkKnight
 *
 */
@Mapper
public interface UtilsDAO {
  /**
   * -查询系统时间
   *
   * @return
   * @throws Exception
   */
  Date queryTime() throws Exception;
}
