package top.huhuiyu.supermarketonline.base;

import top.huhuiyu.supermarketonline.utils.PageBean;

/**
 * -带分页的model基础类
 *
 * @author DarkKnight
 *
 */
public abstract class BasePageModel extends BaseModel {

  private static final long serialVersionUID = 6998909548933172374L;

  private PageBean page = new PageBean();

  public BasePageModel() {
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }

}
