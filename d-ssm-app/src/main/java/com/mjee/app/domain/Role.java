/**
 * f-club.cn
 * Copyright (c) 2009-2012 All Rights Reserved.
 */
package com.mjee.app.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 角色。
 * 
 * @author michael
 * @version $Id: Role.java, v 0.1 2012-9-26 下午6:17:42 michael Exp $
 */
public class Role implements Serializable {

    /** serial version UID */
    private static final long serialVersionUID = -4177282920252439830L;

    private String name;
    private String description;
    
    private List<Admin> adminList;
    private List<Permission> permissionList;
    
    
    // ---- getter/setter methods -------------------------------------
    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public String getDescription() {
		return description;
	}
    
    public void setDescription(String description) {
		this.description = description;
	}
    
    public List<Admin> getAdminList() {
		return adminList;
	}
    
    public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
    
    public List<Permission> getPermissionList() {
		return permissionList;
	}
    
    public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
    
}
