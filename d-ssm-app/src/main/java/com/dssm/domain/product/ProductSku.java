package com.dssm.domain.product;

import java.util.Date;

import com.dssm.domain.PrimaryKey;
import com.dssm.domain.security.Admin;

public class ProductSku extends PrimaryKey {

	private static final long serialVersionUID = 1104680607966959648L;
	
	private Product	product;
	private Color 	color;
	private Size 	size;
	
	private Integer number;
	private String 	barcode;
	
	private Date	updateTime;
	private Admin	updateAdmin;
	
	/* ---- getter/setter methods ---- */
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
