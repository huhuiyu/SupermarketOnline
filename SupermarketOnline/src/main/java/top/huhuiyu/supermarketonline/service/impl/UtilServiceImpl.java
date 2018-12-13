package top.huhuiyu.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.supermarketonline.dao.TbTokenInfoDAO;
import top.huhuiyu.supermarketonline.entity.TbTokenInfo;
import top.huhuiyu.supermarketonline.service.UtilService;
import top.huhuiyu.supermarketonline.utils.ImageCode;
import top.huhuiyu.supermarketonline.utils.MyUtils;

/**
 *
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UtilServiceImpl implements UtilService {
  @Autowired
  private TbTokenInfoDAO tbTokenInfoDAO;

  @Override
  public String imageCode(TbTokenInfo tokenInfo) throws Exception {
    String code = ImageCode.makeCode();
    // 保持图片校验码到数据，方便后续校验
    TbTokenInfo stokenInfo = tbTokenInfoDAO.queryImageCodeByToken(tokenInfo);
    if (stokenInfo == null) {
      // 信息不存在就创建一个新的添加
      stokenInfo = new TbTokenInfo();
      stokenInfo.setToken(tokenInfo.getToken());
      stokenInfo.setInfo(code);
      tbTokenInfoDAO.addImageCode(stokenInfo);
    } else {
      // 信息存在就更新
      stokenInfo.setInfo(code);
      tbTokenInfoDAO.updateImageCode(stokenInfo);
    }
    return code;
  }

  @Override
  public boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception {
    if (tokenInfo == null || MyUtils.isEmpty(tokenInfo.getInfo())) {
      return false;
    }
    TbTokenInfo stokenInfo = tbTokenInfoDAO.queryImageCodeByToken(tokenInfo);
    if (stokenInfo == null) {
      return false;
    }
    tbTokenInfoDAO.deleteImageCode(stokenInfo);
    return tokenInfo.getInfo().equalsIgnoreCase(stokenInfo.getInfo());
  }
}
