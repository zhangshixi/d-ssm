package com.mjee.helper;

import javax.servlet.http.HttpServletRequest;

import com.mjee.domain.manage.Admin;

public final class SessionHelper {
    
    public static void setAdmin(Admin admin, HttpServletRequest request) {
        request.getSession().setAttribute("admin", admin);
    }
    
    public static Admin getAdmin(HttpServletRequest request) {
        return (Admin) request.getSession().getAttribute("admin");
    }
    
}
