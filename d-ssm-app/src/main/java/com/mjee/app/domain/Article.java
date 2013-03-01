/**
 * f-club.cn
 * Copyright (c) 2009-2012 All Rights Reserved.
 */
package com.mjee.app.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 文章。
 * 
 * @author michael
 * @version $Id: Article.java, v 0.1 2012-9-26 下午6:19:10 michael Exp $
 */
public class Article extends PrimaryKey {

	private static final long serialVersionUID = 8150798894319038588L;

	@NotEmpty
	private String headline;
	private String summary;
	@NotEmpty
	private String content;
	private int visitNumber;
	private int commentNumber;
	@NotNull
	private Date createTime;
	private Date updateTime;
	
	private Admin admin;
	private ArticleCategory category;
	private List<ArticleComment> commentList;
	
	
	// ---- getter/setter methods ------------------------------------
	public String getHeadline() {
		return headline;
	}
	
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getVisitNumber() {
		return visitNumber;
	}
	
	public void setVisitNumber(int visitNumber) {
		this.visitNumber = visitNumber;
	}
	
	public int getCommentNumber() {
		return commentNumber;
	}
	
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public ArticleCategory getCategory() {
		return category;
	}
	
	public void setCategory(ArticleCategory category) {
		this.category = category;
	}
	
	public List<ArticleComment> getCommentList() {
		return commentList;
	}
	
	public void setCommentList(List<ArticleComment> commentList) {
		this.commentList = commentList;
	}
	
}
