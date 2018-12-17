package top.huhuiyu.supermarketonline.entity;

import java.util.Date;

import top.huhuiyu.supermarketonline.base.BaseEntity;

/**
 * TbSubType表
 * 
 * @author DarkKnight
 *
 */
public class TbSubType extends BaseEntity {

  private static final long serialVersionUID = -1431784761232228806L;

  private Integer stid;
  private Integer tid;
  private String subName;
  private String subInfo;
  private String isEnable;
  private Date lastupdate;

  public TbSubType() {
  }

  public TbSubType(Integer stid, Integer tid, String subName, String subInfo, String isEnable, Date lastupdate) {
    this.stid = stid;
    this.tid = tid;
    this.subName = subName;
    this.subInfo = subInfo;
    this.isEnable = isEnable;
    this.lastupdate = lastupdate;
  }

  public Integer getStid() {
    return stid;
  }

  public void setStid(Integer stid) {
    this.stid = stid;
  }

  public Integer getTid() {
    return tid;
  }

  public void setTid(Integer tid) {
    this.tid = tid;
  }

  public String getSubName() {
    return subName;
  }

  public void setSubName(String subName) {
    this.subName = subName;
  }

  public String getSubInfo() {
    return subInfo;
  }

  public void setSubInfo(String subInfo) {
    this.subInfo = subInfo;
  }

  public String getIsEnable() {
    return isEnable;
  }

  public void setIsEnable(String isEnable) {
    this.isEnable = isEnable;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
