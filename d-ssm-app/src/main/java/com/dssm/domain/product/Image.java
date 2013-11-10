package com.dssm.domain.product;

import java.util.Date;

import com.dssm.domain.PrimaryKey;

public class Image extends PrimaryKey {
	
	private static final long serialVersionUID = 6959661610056390421L;
	
	private String 	path;
	private Integer sequence;
	
	private Date updateTime;
	private Date updateAdmin;
	
	private Product product;

	/* ---- getter/setter methods ---- */
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getUpdateAdmin() {
		return updateAdmin;
	}
	public void setUpdateAdmin(Date updateAdmin) {
		this.updateAdmin = updateAdmin;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
