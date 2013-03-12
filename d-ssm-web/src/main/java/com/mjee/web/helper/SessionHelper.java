package com.mjee.web.helper;

import javax.servlet.http.HttpServletRequest;

import com.mjee.app.domain.Admin;

public final class SessionHelper {
    
    public static void setAdmin(Admin admin, HttpServletRequest request) {
        request.getSession().setAttribute("admin", admin);
    }
    
    public static Admin getAdmin(HttpServletRequest request) {
        return (Admin) request.getSession().getAttribute("admin");
    }
    
}
