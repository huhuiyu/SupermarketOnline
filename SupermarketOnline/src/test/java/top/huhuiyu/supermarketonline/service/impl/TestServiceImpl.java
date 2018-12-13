package top.huhuiyu.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;

import top.huhuiyu.supermarketonline.dao.TestDAO;
import top.huhuiyu.supermarketonline.entity.TbToken;
import top.huhuiyu.supermarketonline.service.TestService;
import top.huhuiyu.supermarketonline.utils.JsonMessage;
import top.huhuiyu.supermarketonline.utils.PageBean;

/**
 *
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {
  @Autowired
  private TestDAO testDAO;

  @Override
  public JsonMessage queryTokens(PageBean page) throws Exception {
    PageMethod.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbToken> list = (Page<TbToken>) testDAO.queryTokens();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.put("page", page);
    message.put("list", list);
    return message;
  }

}
