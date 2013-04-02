package com.dssm.domain.website;

import com.dssm.domain.PrimaryKey;

/**
 * 产品类别。
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
