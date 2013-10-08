package com.dssm.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class PrimaryKey implements Serializable {
    
    /** serial version UID */
    private static final long serialVersionUID = 3116037967036722554L;
    
    /** primary key */
    protected Long id;

    
    public PrimaryKey() {
    }
    
    public PrimaryKey(Long id) {
    	this.id = id;
	}
    
    
    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /* ---- override methods ---- */
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
    
}
