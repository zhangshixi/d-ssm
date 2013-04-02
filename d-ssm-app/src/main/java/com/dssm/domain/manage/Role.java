/**
 * f-club.cn
 * Copyright (c) 2009-2012 All Rights Reserved.
 */
package com.dssm.domain.manage;

import java.util.List;

import com.dssm.domain.PrimaryKey;

/**
 * 角色。
 */
public class Role extends PrimaryKey {

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
