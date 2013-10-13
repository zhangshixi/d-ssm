/**
 * f-club.cn
 * Copyright (c) 2009-2013 All Rights Reserved.
 */
package com.dssm.domain.security;

import java.util.Date;
import java.util.List;

import com.dssm.domain.PrimaryKey;

/**
 * 地区。
 */
public class Menu extends PrimaryKey {

    private static final long serialVersionUID = 7833650858725900162L;

    private String     name;
    private String	   link;
    private Integer    level;
    private Integer	   sequence;
    private Boolean	   display;
    private Integer	   updateAid;
    private Date	   updateTime;
    
    private Menu       parent;
    private List<Menu> childList;

    /* ---- extend methods ---- */
    public boolean isTopLevel() {
        return Integer.valueOf(1).equals(this.level);
    }
    
    /* ---- getter/setter methods ---- */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLink() {
		return link;
	}
    
    public void setLink(String link) {
		this.link = link;
	}

    public Integer getLevel() {
        return level;
    }
    
    public void setLevel(Integer level) {
    	this.level = level;
    }
    
    public Integer getSequence() {
    	return sequence;
    }
    
    public void setSequence(Integer sequence) {
    	this.sequence = sequence;
    }
    
    public Boolean getDisplay() {
    	return display;
    }
    
    public void setDisplay(Boolean display) {
    	this.display = display;
    }

    public Integer getUpdateAid() {
		return updateAid;
	}
    
    public void setUpdateAid(Integer updateAid) {
		this.updateAid = updateAid;
	}
    
    public Date getUpdateTime() {
		return updateTime;
	}
    
    public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public List<Menu> getChildList() {
        return childList;
    }

    public void setChildList(List<Menu> childList) {
        this.childList = childList;
    }

}
