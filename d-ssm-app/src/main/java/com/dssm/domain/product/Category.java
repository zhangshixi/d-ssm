package com.dssm.domain.product;

import java.util.Date;
import java.util.List;

import com.dssm.domain.PrimaryKey;
import com.dssm.domain.security.Admin;


public class Category extends PrimaryKey {
    
    private static final long serialVersionUID = 8634952745872353614L;
    
    private String  name;
    private String  code;
    private Integer sequence;
    private String  description;
    private Date 	updateTime;
    private Admin   updateAdmin;
    
    private Category parent;
    private List<Category> childList;
    
    /* ---- extend methods ---- */
    public boolean isTopLevel() {
        return this.parent == null || Integer.valueOf(0).equals(this.parent.getId());
    }
    
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
    public Integer getSequence() {
		return sequence;
	}
    public void setSequence(Integer sequence) {
		this.sequence = sequence;
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
    public Category getParent() {
		return parent;
	}
    public void setParent(Category parent) {
		this.parent = parent;
	}
    public List<Category> getChildList() {
		return childList;
	}
    public void setChildList(List<Category> childList) {
		this.childList = childList;
	}
    
}
