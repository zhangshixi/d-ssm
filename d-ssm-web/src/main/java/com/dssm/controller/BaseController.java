package com.dssm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dssm.domain.manage.Admin;
import com.dssm.helper.SessionHelper;
import com.dssm.helper.VisitorHolder;
import com.mtoolkit.util.DateUtil;

public abstract class BaseController {
	
	/* Method examples:
	 * 
	 * showArticleList();      GET         /article
	 * showArticle();          GET         /article/{id}
	 * 
	 * toNewArticle();         GET         /article/new
	 * createArticle();        POST        /article
	 * 
	 * toEditArticle();        GET         /article/{id}/edit
	 * editArticle();          PUT         /article/{id}
	 * 
	 * removeArticle();        DELETE      /article/{id}
	 * batchRemoveArticles();  DELETE      /article
	 */
    
    /* ---- protected methods ---- */
    protected String errorPage(String message) {
        return "error";
    }
    
    protected Date getCurrentTime() {
        return DateUtil.getCurrentTime();
    }
    
    protected int getCurrentAdminId() {
        return getCurrentAdmin().getId();
    }
    
    protected Admin getCurrentAdmin() {
        return SessionHelper.getAdmin(getCurrentRequest());
    }
    
    protected HttpServletRequest getCurrentRequest() {
        return VisitorHolder.getVisitRequest();
    }
    
    protected HttpServletResponse getCurrentResponse() {
        return VisitorHolder.getVisitResponse();
    }
	
    protected Integer getIntegerRequestParam(String name) {
        String value = getStringRequestParam(name);
        return value == null ? null : Integer.valueOf(value);
    }
    
    protected Boolean getBooleanRequestParam(String name) {
        String value = getStringRequestParam(name);
        return value == null ? null : Boolean.valueOf(value);
    }
    
    protected String getStringRequestParam(String name) {
        return getStringRequestParam(name, VisitorHolder.getVisitRequest());
    }
    
    protected String getStringRequestParam(String name, HttpServletRequest request) {
        return request.getParameter(name);
    }
    
}
