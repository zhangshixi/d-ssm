package com.mjee.web.controller;

public abstract class BaseController {
	
	/* Method examples:
	 * 
	 * showArticleList();      GET         /article
	 * 
	 * toCreateArticle();      GET         /article/create
	 * createArticle();        POST        /article
	 * 
	 * showArticle();          GET         /article/{id}
	 * editArticle();          PUT         /article/{id}
	 * 
	 * removeArticle();        DELETE      /article/{id}
	 * batchRemoveArticles();  DELETE      /article
	 */
    
    protected String errorPage(String message) {
        return "error";
    }
	
}
