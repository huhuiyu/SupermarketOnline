package top.huhuiyu.supermarketonline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.supermarketonline.entity.TbSubType;
import top.huhuiyu.supermarketonline.entity.TbType;

/**
 * TbSubType数据访问层
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface TbSubTypeDAO {

  /**
   * 查询可用的TbType
   * 
   * @return 可用的TbType
   * @throws Exception 处理发生异常
   */
  List<TbType> queryTypes() throws Exception;

  /**
   * 查询小类信息
   * 
   * @return 小类信息
   * @throws Exception 处理发生异常
   */
  List<TbSubType> queryAll() throws Exception;

  /**
   * 按照tid和subName查询小类信息
   * 
   * @param tbSubType 小类信息
   * @return 小类信息
   * @throws Exception 处理发生异常
   */
  TbSubType queryByTidSubName(TbSubType tbSubType) throws Exception;

  /**
   * 按照主键查询小类信息
   * 
   * @param tbSubType 小类信息
   * @return 小类信息
   * @throws Exception 处理发生异常
   */
  TbSubType queryByKey(TbSubType tbSubType) throws Exception;

  /**
   * 添加小类信息
   * 
   * @param subType 小类信息
   * @return 添加小类信息结果
   * @throws Exception 处理发生异常
   */
  int add(TbSubType subType) throws Exception;

  /**
   * 修改小类信息
   * 
   * @param subType 小类信息
   * @return 修改小类信息结果
   * @throws Exception 处理发生异常
   */
  int update(TbSubType subType) throws Exception;

  /**
   * 修改启用状态
   * 
   * @param subType 小类信息
   * @return 修改启用状态结果
   * @throws Exception 处理发生异常
   */
  int updateIsEnable(TbSubType subType) throws Exception;
}
