package com.dssm.service;

public interface BaseService {
    
    public void init();

    public void destroy();
    
    /* Method examples:
     * 
     * addArticle(Article article);
     * 
     * removeArticleById(Long id);
     * 
     * editArticle(Article article);
     * 
     * findArticleById(Long id);
     * 
     * queryArticlesByPage(Page<Article> page, Article search);
     */
}
