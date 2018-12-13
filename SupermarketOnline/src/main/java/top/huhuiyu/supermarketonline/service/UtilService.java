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
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  String imageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -查看校验码是否正确
   *
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception;

}
