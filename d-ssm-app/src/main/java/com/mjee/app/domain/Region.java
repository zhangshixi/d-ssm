/**
 * f-club.cn
 * Copyright (c) 2009-2013 All Rights Reserved.
 */
package com.mjee.app.domain;

import java.util.List;

/**
 * 地区。
 */
public class Region extends PrimaryKey {

    private static final long serialVersionUID = 7833650858725900162L;

    private String       name;
    private Integer      level;
    private Region       parent;
    private List<Region> childList;

    /* ---- public methods ---- */
    public boolean isTopLevel() {
        return Integer.valueOf(0).equals(this.level);
    }
    
    /* ---- setter/getter methods ---- */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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
