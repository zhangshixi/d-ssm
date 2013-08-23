package com.dssm.helper;

import javax.servlet.http.HttpServletRequest;

import com.dssm.domain.manage.Admin;

public final class SessionHelper {
    
    private static final String ADMIN_SESSION_KEY = "admin";
    
    public static void setAdmin(Admin admin, HttpServletRequest request) {
        request.getSession().setAttribute(ADMIN_SESSION_KEY, admin);
    }
    
    public static Admin getAdmin(HttpServletRequest request) {
        return (Admin) request.getSession().getAttribute(ADMIN_SESSION_KEY);
    }
    
}
