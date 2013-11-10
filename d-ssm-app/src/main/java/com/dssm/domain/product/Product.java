package com.dssm.domain.product;

import com.dssm.domain.PrimaryKey;

public class Product extends PrimaryKey {

    private static final long serialVersionUID = 1265441437107287621L;

    private String sn;
    private String name;
    
    private Integer sex;
    private String  description;
    
    private Brand	 brand;
    private Category category;
    private Provider provider;
    
    
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
