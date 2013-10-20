package com.dssm.domain.work;

import java.util.Date;

import com.dssm.domain.PrimaryKey;

/**
 * 工单操作信息
 */
public class WorkOperation extends PrimaryKey {

	private static final long serialVersionUID = 8973430432575105425L;

	private String operateUser;
	private Date   operateTime;
	private String operateType;
	private String operateContent;
	
	public String getOperateUser() {
		return operateUser;
	}
	
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	
	public Date getOperateTime() {
		return operateTime;
	}
	
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	
	public String getOperateType() {
		return operateType;
	}
	
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
	public String getOperateContent() {
		return operateContent;
	}
	
	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
	}
	
}
