package com.dssm.domain.product;

import java.util.Date;

import com.dssm.domain.PrimaryKey;
import com.dssm.domain.security.Admin;

public class PriceTrack extends PrimaryKey {

	private static final long serialVersionUID = 8497726957060538142L;
	
	private Batch	batch;
	private Product product;
	private Price  	price; 
	private String 	remark;
	private Date   	updateTime;
	private Admin  	updateAdmin;
	
	/* ---- getter/setter methods ---- */
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Admin getUpdateAdmin() {
		return updateAdmin;
	}
	public void setUpdateAdmin(Admin updateAdmin) {
		this.updateAdmin = updateAdmin;
	}
	
}
