/**
 * f-club.cn
 * Copyright (c) 2009-2013 All Rights Reserved.
 */
package com.dssm.domain.setting;

import java.util.List;

import com.dssm.domain.PrimaryKey;

/**
 * 地区。
 */
public class Region extends PrimaryKey {

    private static final long serialVersionUID = 7833650858725900162L;

    private String       name;
    private Region       parent;
    private List<Region> childList;

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

    public Region getParent() {
        return parent;
    }

    public void setParent(Region parent) {
        this.parent = parent;
    }

    public List<Region> getChildList() {
        return childList;
    }

    public void setChildList(List<Region> childList) {
        this.childList = childList;
    }

}
