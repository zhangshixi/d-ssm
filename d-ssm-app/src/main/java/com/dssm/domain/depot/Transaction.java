package com.dssm.domain.depot;

import java.util.Date;

import com.dssm.domain.PrimaryKey;
import com.dssm.domain.product.ProductSku;
import com.dssm.domain.security.Admin;

public class Transaction extends PrimaryKey {
	
	private static final long serialVersionUID = -8291531679871674371L;
	
	private ProductSku 	productSku;
	private Location 	location;
	
	private TransType 	transType;
	private TransStatus transStatus;
	
	private Date  		createTime;
	private Admin 		createAdmin;
	private Date  		updateTime;
	private Admin 		updateAdmin;
	
	/* ---- getter/setter methods ---- */
	public ProductSku getProductSku() {
		return productSku;
	}
	public void setProductSku(ProductSku productSku) {
		this.productSku = productSku;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public TransType getTransType() {
		return transType;
	}
	public void setTransType(TransType transType) {
		this.transType = transType;
	}
	public TransStatus getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(TransStatus transStatus) {
		this.transStatus = transStatus;
	}
	public void setTransStatus(Integer transStatus) {
		this.transStatus = TransStatus.valueOf(transStatus);
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Admin getCreateAdmin() {
		return createAdmin;
	}
	public void setCreateAdmin(Admin createAdmin) {
		this.createAdmin = createAdmin;
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
