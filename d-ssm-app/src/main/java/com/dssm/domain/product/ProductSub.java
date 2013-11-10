package com.dssm.domain.product;

import java.util.Date;
import java.util.List;

import com.dssm.domain.PrimaryKey;
import com.dssm.domain.security.Admin;

public class ProductSub extends PrimaryKey {

	private static final long serialVersionUID = 1104680607966959648L;
	
	private Product 	product;
	private Color 		color;
	private Date		updateTime;
	private Admin		updateAdmin;
	
	private List<Size>  sizeList;
	private List<Image> imageList;
	
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
	public List<Size> getSizeList() {
		return sizeList;
	}
	public void setSizeList(List<Size> sizeList) {
		this.sizeList = sizeList;
	}
	public List<Image> getImageList() {
		return imageList;
	}
	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}
	
}
