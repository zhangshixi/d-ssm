package com.dssm.domain.work;

import java.util.Date;

import com.dssm.domain.PrimaryKey;

/**
 * 工单
 */
public class Work extends PrimaryKey {

	private static final long serialVersionUID = -4337603781908725776L;
	
	private Date createTime;
	private String status;
	private String content;
	private Integer orderId;
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
