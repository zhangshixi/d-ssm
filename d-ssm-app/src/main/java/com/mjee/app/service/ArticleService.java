package com.mjee.app.service;

import com.mjee.app.domain.Article;
import com.mjee.app.domain.ArticleCategory;
import com.mjee.app.domain.ArticleComment;
import com.mtoolkit.page.Page;

public interface ArticleService extends BaseService {
	
    /* ---- article operations ---- */
    public int createArticle(Article article);

    public int removeArticleById(int articleId);
    
    public int editArticle(Article article);

    public Article findArticleById(int articleId);
    
    public Page<Article> queryArticlesByPage(Page<Article> page); 
    
    public Page<Article> queryArticlesByNew(Page<Article> page);
    
    public Page<Article> queryArticlesByVisit(Page<Article> page);
    
    public Page<Article> queryArticlesByComment(Page<Article> page);
    
    public Page<Article> queryArticlesByCategory(int categoryId, Page<Article> page);
    
    
    /* ---- article category operations ---- */
    public int createArticleCategory(ArticleCategory articleCategory);
    
    public int removeArticleCategoryById(int categoryId);
    
    public int editArticleCategory(ArticleCategory articleCategory);
    
    public ArticleCategory findArticleCategoryById(int categoryId);
    
    public Page<ArticleCategory> queryArticleCategoriesByPage(Page<ArticleCategory> page);
    
    
    /* ---- article comment operations ---- */
    public int createArticleComment(ArticleComment articleComment);
    
    public int removeArticleCommentById(int commentId);
    
    public Page<ArticleComment> queryArticleCommentsByPage(int articleId, Page<ArticleComment> page);
    
}
