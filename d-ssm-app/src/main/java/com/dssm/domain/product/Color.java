package com.dssm.domain.product;

import java.util.Date;

import com.dssm.domain.PrimaryKey;
import com.dssm.domain.security.Admin;

public class Color extends PrimaryKey {
	
	private static final long serialVersionUID = -2003525848894528574L;
	
	private String name;
	private String code;
	private String description;
	private Date   updateTime;
	private Admin  updateAdmin;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
