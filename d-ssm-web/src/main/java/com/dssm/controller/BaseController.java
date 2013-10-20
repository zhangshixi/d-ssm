package com.dssm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

import com.dssm.domain.security.Admin;
import com.dssm.helper.VisitorHolder;
import com.dssm.loader.ConfigPropertyLoader;
import com.dssm.loader.SystemPropertyLoader;
import com.mtoolkit.spring.SpringContextHolder;
import com.mtoolkit.util.DateUtil;
import com.mtoolkit.util.StringUtil;

public abstract class BaseController {
	
	/* Method examples:
	 * 
	 * show()			GET			/resource/{id}
	 * showList()		GET         /resource
	 * 
	 * toAdd()			GET         /resource/new
	 * add()			POST        /resource
	 * 
	 * toEdit()			GET         /resource/{id}/edit
	 * edit()			PUT         /resource/{id}
	 * 
	 * remove()			DELETE      /resource/{id}
	 * batchRemove()	DELETE      /resource
	 */
    
    /* ---- protected methods ---- */
    protected String errorPage(String message) {
        return "error";
    }
    
    protected Date getCurrentTime() {
        return DateUtil.getCurrentTime();
    }
    
    protected Integer getLoginAdminId() {
    	Admin loginAdmin = getLoginAdmin();
        return loginAdmin == null ? null : loginAdmin.getId();
    }
    
    protected Admin getLoginAdmin() {
    	return (Admin) SecurityUtils.getSubject().getPrincipal();
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
    
    
    public <T> T getBean(String name) {
        return SpringContextHolder.getBean(name);
    }
    
	protected SystemPropertyLoader getSystemPropertyLoader() {
        return SpringContextHolder.getBean("systemPropertyLoader");
    }
    
	protected ConfigPropertyLoader getConfigPropertyLoader() {
        return SpringContextHolder.getBean("configPropertyLoader");
    }
	
	
	protected String redirectTo(String url) {
		return redirectTo(url, (Object[]) null);
	}
	
	protected String redirectTo(String url, Object... params) {
		return "redirect:" + StringUtil.replaceHolderArgs(url, params);
	}
	
	
	protected String errorTo(String message) {
		return redirectTo("/error?message=" + message);
	}
	
	
	protected String view(String viewName) {
	    String invokeClassName = doGetInvokeClass();
	    String viewPath = doGetViewPath(invokeClassName);
        return viewPath + viewName;
    }
	
	/* ---- private methods ---- */
    private String doGetInvokeClass() {
	    String basePackageName = BaseController.class.getPackage().getName();
	    StackTraceElement[] stackTraces = new Throwable().getStackTrace();
	    
	    String invokeClassName = null;
	    for (StackTraceElement element : stackTraces) {
	        String className = element.getClassName();
	        if (className.startsWith(basePackageName)) {
	            invokeClassName = className;
	        } else {
	            break;
	        }
	    }
	    
	    return invokeClassName;
	}
	
    private String doGetViewPath(String invokeClassName) {
        String basePackageName = BaseController.class.getPackage().getName();
        int beginIndex = basePackageName.length() + 1;
        int endIndex = invokeClassName.lastIndexOf("Controller");
        
        String viewPath = invokeClassName.substring(beginIndex, endIndex).toLowerCase();
        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < viewPath.length(); i++) {
            char point = viewPath.charAt(i);
            if (point == '.') {
                buff.append('/');
            } else {
                buff.append(point);
            }
        }
        buff.append('/');
        
        return buff.toString();
    }
    
}
