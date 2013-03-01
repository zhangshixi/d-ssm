/**
 * f-club.cn
 * Copyright (c) 2009-2013 All Rights Reserved.
 */
package com.mjee.app.domain;

/**
 * 产品类别。
 * 
 * @author michael
 * @version $Id: ProductCategory.java, v 0.1 2013-2-22 下午2:45:37 michael Exp $
 */
public class ProductCategory extends PrimaryKey {
    
    private static final long serialVersionUID = 8634952745872353614L;
    
    private String name;
    private String description;
    
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
    
}
