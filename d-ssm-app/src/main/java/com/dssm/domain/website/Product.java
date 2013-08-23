package com.dssm.domain.website;

import com.dssm.domain.PrimaryKey;

/**
 * 产品。
 */
public class Product extends PrimaryKey {

    private static final long serialVersionUID = 1265441437107287621L;

    private String name;
    private String description;
    
    /* ---- getter/setter methods ---- */
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
