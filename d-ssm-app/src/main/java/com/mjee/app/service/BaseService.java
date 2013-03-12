package com.mjee.app.service;

public interface BaseService {
    
    public void init();

    public void destroy();
    
    /* Method examples:
     * 
     * createArticle(Article article);
     * 
     * removeArticleById(int id);
     * 
     * editArticle(Article article);
     * 
     * findArticleById(int id);
     * 
     * queryArticlesByPage(Page<Article> page);
     */
}
