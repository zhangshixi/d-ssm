/**
 * f-club.cn
 * Copyright (c) 2009-2013 All Rights Reserved.
 */
package com.mjee.app.domain;

/**
 * 产品。
 * 
 * @author michael
 * @version $Id: Product.java, v 0.1 2013-2-22 下午2:41:34 michael Exp $
 */
public class Product extends PrimaryKey {

    private static final long serialVersionUID = 1265441437107287621L;

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
