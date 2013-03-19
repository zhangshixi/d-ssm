package com.mjee.domain.website;

import com.mjee.domain.PrimaryKey;

/**
 * 产品。
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
