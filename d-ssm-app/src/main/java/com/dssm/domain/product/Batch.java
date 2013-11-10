package com.dssm.domain.product;

import java.util.Date;

import com.dssm.domain.PrimaryKey;
import com.dssm.domain.security.Admin;

public class Batch extends PrimaryKey {
	
	private static final long serialVersionUID = 2718384039508866327L;
	
	private String name;
	private String code;
	
	private Date  updateTime;
	private Admin updateAdmin;
	
	/* ---- getter/setter methods ---- */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Admin getUpdateAdmin() {
		return updateAdmin;
	}
	public void setUpdateAdmin(Admin updateAdmin) {
		this.updateAdmin = updateAdmin;
	}
	
}
