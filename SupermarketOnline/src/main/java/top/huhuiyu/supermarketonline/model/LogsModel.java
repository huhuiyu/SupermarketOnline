package top.huhuiyu.supermarketonline.model;

import top.huhuiyu.supermarketonline.base.BasePageModel;
import top.huhuiyu.supermarketonline.entity.TbLogs;

/**
 * TbLogs的Model
 * 
 * @author DarkKnight
 *
 */
public class LogsModel extends BasePageModel {

  private static final long serialVersionUID = 4726078194932348347L;

  private TbLogs tbLogs = new TbLogs();

  public LogsModel() {
  }

  public TbLogs getTbLogs() {
    return tbLogs;
  }

  public void setTbLogs(TbLogs tbLogs) {
    this.tbLogs = tbLogs;
  }
}
