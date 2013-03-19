package com.mjee.domain;

import java.io.Serializable;

public abstract class PrimaryKey implements Serializable {
    
    /** serial version UID */
    private static final long serialVersionUID = 3116037967036722554L;
    
    /** primary key */
    protected int id;

    
    public PrimaryKey() {
    }
    
    public PrimaryKey(int id) {
    	this.id = id;
	}
    
    
    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
