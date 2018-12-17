package top.huhuiyu.supermarketonline.service;

import top.huhuiyu.supermarketonline.entity.TbTokenInfo;

/**
 * -工具服务
 *
 * @author DarkKnight
 *
 */
public interface UtilService {

  /**
   * - 获取图片校验码
   *
   * @param tokenInfo 查询数据
   * @return 查询结果
   * @throws Exception 处理发生错误
   */
  String imageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -查看校验码是否正确
   *
   * @param tokenInfo 查询数据
   * @return 查询结果
   * @throws Exception 处理发生错误
   */
  boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception;

}
