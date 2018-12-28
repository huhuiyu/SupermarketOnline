package top.huhuiyu.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.huhuiyu.supermarketonline.dao.TbLogsDAO;
import top.huhuiyu.supermarketonline.entity.TbLogs;
import top.huhuiyu.supermarketonline.model.LogsModel;
import top.huhuiyu.supermarketonline.service.LogsService;
import top.huhuiyu.supermarketonline.utils.JsonMessage;
import top.huhuiyu.supermarketonline.utils.PageBean;

/**
 * LogsService的实现
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LogsServiceImpl implements LogsService {
  @Autowired
  private TbLogsDAO tbLogsDAO;

  @Override
  public JsonMessage queryAll(LogsModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbLogs> list = (Page<TbLogs>) tbLogsDAO.queryAll(model.getTbLogs());
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.put("page", page);
    message.put("list", list);
    return message;
  }

}
