package top.huhuiyu.supermarketonline.utils;

import com.github.pagehelper.Page;

import top.huhuiyu.supermarketonline.base.BaseEntity;

/**
 * -分页信息类
 *
 * @author DarkKnight
 *
 */
public class PageBean extends BaseEntity {
  private static final long serialVersionUID = -1893970506336848554L;
  private int total;
  private int pageNumber = 1;
  private int pageSize = 5;
  private int pageCount;

  public PageBean() {
  }

  /**
   * -通过分页插件信息设置page信息
   *
   * @param page 分页信息
   * @return 分页信息
   */
  public PageBean setPageInfo(Page<?> page) {
    total = (int) page.getTotal();
    pageNumber = page.getPageNum();
    pageSize = page.getPageSize();
    pageCount = page.getPages();
    return this;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }
}
