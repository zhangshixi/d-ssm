package com.dssm.domain.manage;

import java.io.Serializable;

/**
 * 权限。
 */
public class Permission implements Serializable {

    /** serial version UID */
    private static final long serialVersionUID = -8804072265160388100L;

    private String name;
    private String code;
    private String url;
    private String description;
    
    private Role role;
    
    
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
    
    public String getUrl() {
		return url;
	}
    
    public void setUrl(String url) {
		this.url = url;
	}
    
    public String getDescription() {
		return description;
	}
    
    public void setDescription(String description) {
		this.description = description;
	}
    
    public Role getRole() {
		return role;
	}
    
    public void setRole(Role role) {
		this.role = role;
	}
    
}
