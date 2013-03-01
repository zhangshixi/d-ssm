package com.mjee.app.service;

import com.mjee.app.domain.Article;
import com.mjee.app.domain.ArticleCategory;
import com.mjee.app.domain.ArticleComment;
import com.mtoolkit.page.Page;

public interface ArticleService extends BaseService {
	
    public int addArticle(Article article);

    public int removeArticle(int articleId);
    
    public int editArticle(Article article);

    public Article findArticleById(int articleId);
    
    public Page<Article> queryArticlesByPage(Page<Article> page); 
    
    public Page<Article> queryArticlesByNew(Page<Article> page);
    
    public Page<Article> queryArticlesByVisit(Page<Article> page);
    
    public Page<Article> queryArticlesByComment(Page<Article> page);
    
    public Page<Article> queryArticlesByCategory(int categoryId, Page<Article> page);
    
    
    public int addArticleCategory(ArticleCategory articleCategory);
    
    public int removeArticleCategory(int categoryId);
    
    public int editArticleCategory(ArticleCategory articleCategory);
    
    public ArticleCategory findArticleCategoryById(int categoryId);
    
    public Page<ArticleCategory> queryArticleCategoriesByPage(Page<ArticleCategory> page);
    
    
    public int addArticleComment(ArticleComment articleComment);
    
    public int removeArticleComment(int commentId);
    
    public Page<ArticleComment> queryArticleCommentsByPage(int articleId, Page<ArticleComment> page);
    
}
