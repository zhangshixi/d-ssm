package com.dssm.service.website;

import com.dssm.domain.website.Article;
import com.dssm.domain.website.ArticleCategory;
import com.dssm.domain.website.ArticleComment;
import com.dssm.service.BaseService;
import com.mtoolkit.page.Page;

public interface ArticleService extends BaseService<Article> {
	
    /* ---- article operations ---- */
    public Integer addArticle(Article article);

    public int removeArticleById(Integer articleId);
    
    public int editArticle(Article article);

    public Article findArticleById(Integer articleId);
    
    public Page<Article> queryArticlesByPage(Page<Article> page); 
    
    public Page<Article> queryArticlesByNew(Page<Article> page);
    
    public Page<Article> queryArticlesByVisit(Page<Article> page);
    
    public Page<Article> queryArticlesByComment(Page<Article> page);
    
    public Page<Article> queryArticlesByCategory(Integer categoryId, Page<Article> page);
    
    
    /* ---- article category operations ---- */
    public Integer addArticleCategory(ArticleCategory articleCategory);
    
    public int removeArticleCategoryById(Integer categoryId);
    
    public int editArticleCategory(ArticleCategory articleCategory);
    
    public ArticleCategory findArticleCategoryById(Integer categoryId);
    
    public Page<ArticleCategory> queryArticleCategoriesByPage(Page<ArticleCategory> page);
    
    
    /* ---- article comment operations ---- */
    public Integer addArticleComment(ArticleComment articleComment);
    
    public int removeArticleCommentById(Integer commentId);
    
    public Page<ArticleComment> queryArticleCommentsByPage(Integer articleId, Page<ArticleComment> page);
    
}
