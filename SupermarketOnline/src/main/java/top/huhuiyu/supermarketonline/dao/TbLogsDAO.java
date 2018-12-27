package top.huhuiyu.supermarketonline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.supermarketonline.entity.TbLogs;

/**
 * TbLogs的dao
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TbLogsDAO {
  /**
   * 分页查询
   * 
   * @return 分页查询结果
   * @throws Exception 处理发生异常
   */
  public List<TbLogs> queryAll() throws Exception;

  /**
   * 添加log
   * 
   * @param tbLogs log信息
   * @return 添加log结果
   * @throws Exception 处理发生异常
   */
  public int add(TbLogs tbLogs) throws Exception;
}
