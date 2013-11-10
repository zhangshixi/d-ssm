package com.dssm.domain.setting;

import com.dssm.domain.PrimaryKey;

/**
 * 网店
 * @author Michael
 */
public class Shop extends PrimaryKey {
	
	private static final long serialVersionUID = -7264970984640072971L;
	
	private String 	 name;
	private String 	 code;
	private String 	 type;
	private String 	 website;
	private String 	 account;
	private String 	 password;
	private String 	 description;
	
	private Platform platform;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
}
