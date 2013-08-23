package com.dssm.domain.website;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.dssm.domain.PrimaryKey;

/**
 * 文章分类。
 */
public class ArticleCategory extends PrimaryKey {

	private static final long serialVersionUID = 5003743031732472276L;
	
	@NotEmpty
	@Size(max = 128)
	private String name;
	@NotEmpty
	@Size(max = 255)
	private String description;
	
	private List<Article> articleList;
	
	
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
	
	public List<Article> getArticleList() {
		return articleList;
	}
	
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
}
