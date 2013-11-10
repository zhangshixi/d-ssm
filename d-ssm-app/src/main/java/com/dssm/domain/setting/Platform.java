package com.dssm.domain.setting;

import com.dssm.domain.PrimaryKey;

/**
 * 平台
 * @author Michael
 */
public class Platform extends PrimaryKey {
	
	private static final long serialVersionUID = -1646457925768459643L;
	
	private String 	name;
	private String 	code;
	private Boolean	enable;
	private String  description;
	
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
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
