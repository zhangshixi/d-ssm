package com.dssm.domain.website;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.dssm.domain.PrimaryKey;

/**
 * 文章评论。
 */
public class ArticleComment extends PrimaryKey {

	private static final long serialVersionUID = 4290088299338636516L;

	@NotEmpty
	private String content;
	@NotNull
	private Date commentTime;
	@NotNull
	private String  ip;
	public boolean deleted;
	private String referenceIds;
	
	private Article article;
	
	
	// ---- getter/setter methods ------------------------------------
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCommentTime() {
		return commentTime;
	}
	
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	
    public String getIp() {
        return ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public Article getArticle() {
		return article;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
}
