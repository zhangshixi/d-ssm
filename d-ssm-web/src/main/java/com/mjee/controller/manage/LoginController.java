package com.mjee.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjee.controller.BaseController;
import com.mjee.domain.manage.Admin;
import com.mjee.helper.BeanHelper;
import com.mjee.helper.SessionHelper;
import com.mjee.loader.ConfigPropertyLoader;
import com.mjee.loader.SystemPropertyLoader;
import com.mjee.service.manage.AdminService;
import com.mtoolkit.util.CookieUtil;
import com.mtoolkit.util.ServletUtil;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private AdminService adminService;
    
    /**
     * 管理员登录页面。
     */
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String toLogin() {
        return "login";
    }
    
    /**
     * 管理员登录。
     */
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login() {
        boolean login = autoLogin();
        if (!login) {
            login = manualLogin();
        }
        
        return login ? "redirect:/index" : "login";
    }
    
    /**
     * 管理员登出。
     */
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout() {
        removeCookies();
        invalidSession();
        
        return "index";
    }
    
    /* ---- private methods ---- */
    private boolean autoLogin() {
        SystemPropertyLoader systemLoader = BeanHelper.getSystemPropertyLoader();
        String cookieUsername = doGetCookieValue(systemLoader.getCookieUsernameName());
        String cookiePassword = doGetCookieValue(systemLoader.getCookiePasswordName()); 

        if (cookieUsername == null || cookiePassword == null) {
            return false;
        } else {
            return doLogin(cookieUsername, cookiePassword);
        }
    }

    private boolean manualLogin() {
        String username = getStringRequestParam("username");
        String password = getStringRequestParam("password");
        
        boolean login = doLogin(username, password);
        if (login) {
            Boolean autoLogin = getBooleanRequestParam("autoLogin");
            if (Boolean.TRUE.equals(autoLogin)) {
                addCookies(username, password);
            }
        }
        
        return login;
    }

    private boolean doLogin(String username, String password) {
        Admin loginAdmin = adminService.findAdminByName(username);
        
        if (loginAdmin == null || !password.equals(loginAdmin.getPassword())) {
            return false;
        } else {
            doSetAdminToSession(loginAdmin);
            doUpdateLastLoginInfo(loginAdmin.getId());
            return true;
        }
    }
    
    private void removeCookies() {
        SystemPropertyLoader systemLoader = BeanHelper.getSystemPropertyLoader();
        doRemoveCookie(systemLoader.getCookieUsernameName()); 
        doRemoveCookie(systemLoader.getCookiePasswordName());
    }
    
    private void addCookies(String username, String password) {
        SystemPropertyLoader systemLoader = BeanHelper.getSystemPropertyLoader();
        doAddCookie(systemLoader.getCookieUsernameName(), username);
        doAddCookie(systemLoader.getCookiePasswordName(), password);
    }
    
    private void invalidSession() {
        getCurrentRequest().getSession().invalidate();
    }

    private void doSetAdminToSession(Admin admin) {
        SessionHelper.setAdmin(admin, getCurrentRequest());
    }
    
    private void doUpdateLastLoginInfo(int adminId) {
        Admin admin = new Admin();
        admin.setId(adminId);
        admin.setLastLoginTime(getCurrentTime());
        admin.setLastLoginIp(ServletUtil.getIpAddress(getCurrentRequest()));
        
        adminService.editAdmin(admin);
    }
    
    private String doGetCookieValue(String cookieName) {
        return CookieUtil.getCookieValue(cookieName, getCurrentRequest());
    }
    
    private void doRemoveCookie(String cookieName) {
        ConfigPropertyLoader configLoader = BeanHelper.getConfigPropertyLoader();
        CookieUtil.removeCookie(
            cookieName, 
            configLoader.getCookieDomain(), 
            configLoader.getCookiePath(), 
            getCurrentRequest(), 
            getCurrentResponse());
    }
    
    private void doAddCookie(String cookieName, String cookieValue) {
        ConfigPropertyLoader configLoader = BeanHelper.getConfigPropertyLoader();
        CookieUtil.addCookie(
            cookieName, 
            cookieValue, 
            configLoader.getCookieMaxAge(), 
            configLoader.getCookieDomain(), 
            configLoader.getCookiePath(), 
            getCurrentRequest(), 
            getCurrentResponse());
    }
	
}