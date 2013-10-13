package com.dssm.domain.security;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.dssm.domain.PrimaryKey;

/**
 * 权限。
 */
public class Permission extends PrimaryKey {

    /** serial version UID */
    private static final long serialVersionUID = -8804072265160388100L;

    @NotEmpty
    private String name;
    @NotEmpty
    private String code;
    private String description;
    
    private List<Role> roleList;
    
    
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
    
    public List<Role> getRoleList() {
		return roleList;
	}
    
    public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
    
}
