package com.dssm.service.website;

import com.dssm.domain.website.Article;
import com.dssm.domain.website.ArticleCategory;
import com.dssm.domain.website.ArticleComment;
import com.dssm.service.BaseService;
import com.mtoolkit.page.Page;

public interface ArticleService extends BaseService {
	
    /* ---- article operations ---- */
    public int addArticle(Article article);

    public int removeArticleById(Long articleId);
    
    public int editArticle(Article article);

    public Article findArticleById(Long articleId);
    
    public Page<Article> queryArticlesByPage(Page<Article> page); 
    
    public Page<Article> queryArticlesByNew(Page<Article> page);
    
    public Page<Article> queryArticlesByVisit(Page<Article> page);
    
    public Page<Article> queryArticlesByComment(Page<Article> page);
    
    public Page<Article> queryArticlesByCategory(Long categoryId, Page<Article> page);
    
    
    /* ---- article category operations ---- */
    public int addArticleCategory(ArticleCategory articleCategory);
    
    public int removeArticleCategoryById(Long categoryId);
    
    public int editArticleCategory(ArticleCategory articleCategory);
    
    public ArticleCategory findArticleCategoryById(Long categoryId);
    
    public Page<ArticleCategory> queryArticleCategoriesByPage(Page<ArticleCategory> page);
    
    
    /* ---- article comment operations ---- */
    public int addArticleComment(ArticleComment articleComment);
    
    public int removeArticleCommentById(Long commentId);
    
    public Page<ArticleComment> queryArticleCommentsByPage(Long articleId, Page<ArticleComment> page);
    
}
