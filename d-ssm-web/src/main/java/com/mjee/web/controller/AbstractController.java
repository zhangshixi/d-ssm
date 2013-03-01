package com.mjee.web.controller;

public abstract class AbstractController {
	
	/* Method examples:
	 * 
	 * showArticleList();      GET         /article
	 * 
	 * toNewArticle();         GET         /article/new
	 * newArticle();           POST        /article
	 * 
	 * showArticle();          GET         /article/{id}
	 * editArticle();          PUT         /article/{id}
	 * 
	 * removeArticle();        DELETE      /article/{id}
	 * batchRemoveArticle();   DELETE      /article
	 */
    
    protected String errorPage(String message) {
        return "error";
    }
	
}
