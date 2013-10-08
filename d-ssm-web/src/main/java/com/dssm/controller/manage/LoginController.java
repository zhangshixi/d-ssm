package com.dssm.controller.manage;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.controller.BaseController;
import com.dssm.shiro.IncorrectCaptchaException;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

//    @Autowired
//    private AdminService adminService;
    
    /**
     * 跳转到管理员登录页面。
     */
    @RequestMapping(method=RequestMethod.GET)
    public String toSingin() {
    	Subject subject = SecurityUtils.getSubject();
    	boolean isRemembered = subject.isRemembered();
    	boolean isAuthenticated = subject.isAuthenticated();
    	
    	if (isRemembered || isAuthenticated) {
    		return redirectTo("/admin/new");
    	}
        return "login";
    }
    
    /**
     * 管理员登录失败。
     */
    @RequestMapping(method=RequestMethod.POST)
    public String login(HttpServletRequest request, ModelMap modelMap) {
    	Object result = request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
    	
    	String errorMsg = null;
    	if (IncorrectCaptchaException.class.getName().equals(result)) {
    		errorMsg = "验证码错误！";
    	} else if (UnknownAccountException.class.getName().equals(result)) {
    		errorMsg = "用户名不存在！";
    	} else if (IncorrectCredentialsException.class.getName().equals(result)) {
    		errorMsg = "密码错误！";
    	} else if (LockedAccountException.class.getName().equals(result)) {
    		errorMsg = "用户被锁定！";
    	} else {
    		errorMsg = "登陆异常：" + result;
    	}
    	
    	modelMap.put("errorMsg", errorMsg);
    	
    	return "login";
    }
    
//    /**
//     * 管理员登录。
//     */
//    @RequestMapping(value="/login", method=RequestMethod.POST)
//    public String login() {
//    	boolean login = autoLogin();
//    	if (!login) {
//    		login = manualLogin();
//    	}
//    	
//    	return login ? "redirect:/index" : "login";
//    }
//    
//    /**
//     * 管理员登出。
//     */
//    @RequestMapping(value="/logout", method=RequestMethod.GET)
//    public String logout() {
//    	
//    	System.err.println("logout ================= ");
//        removeCookies();
//        invalidSession();
//        
//        return "index";
//    }
//    
//    /* ---- private methods ---- */
//    private boolean autoLogin() {
//        String cookieUsername = doGetCookieValue(getSystemPropertyLoader().getCookieUsernameName());
//        String cookiePassword = doGetCookieValue(getSystemPropertyLoader().getCookiePasswordName()); 
//
//        if (cookieUsername == null || cookiePassword == null) {
//            return false;
//        } else {
//            return doLogin(cookieUsername, cookiePassword);
//        }
//    }
//
//    private boolean manualLogin() {
//        String username = getStringRequestParam("username");
//        String password = getStringRequestParam("password");
//        
//        boolean login = doLogin(username, password);
//        if (login) {
//            Boolean autoLogin = getBooleanRequestParam("autoLogin");
//            if (Boolean.TRUE.equals(autoLogin)) {
//                addCookies(username, password);
//            }
//        }
//        
//        return login;
//    }
//
//    private boolean doLogin(String username, String password) {
//        Admin loginAdmin = adminService.findAdminByName(username);
//        
//        if (loginAdmin == null || !password.equals(loginAdmin.getPassword())) {
//            return false;
//        } else {
//            doSetAdminToSession(loginAdmin);
//            doUpdateLastLoginInfo(loginAdmin.getId());
//            return true;
//        }
//    }
//    
//    private void removeCookies() {
//        doRemoveCookie(getSystemPropertyLoader().getCookieUsernameName()); 
//        doRemoveCookie(getSystemPropertyLoader().getCookiePasswordName());
//    }
//    
//    private void addCookies(String username, String password) {
//        doAddCookie(getSystemPropertyLoader().getCookieUsernameName(), username);
//        doAddCookie(getSystemPropertyLoader().getCookiePasswordName(), password);
//    }
//    
//    private void invalidSession() {
//        getCurrentRequest().getSession().invalidate();
//    }
//
//    private void doSetAdminToSession(Admin admin) {
//        SessionHelper.setAdmin(admin, getCurrentRequest());
//    }
//    
//    private void doUpdateLastLoginInfo(int adminId) {
//        Admin admin = new Admin();
//        admin.setId(adminId);
//        admin.setLastLoginTime(getCurrentTime());
//        admin.setLastLoginIp(ServletUtil.getIpAddress(getCurrentRequest()));
//        
//        adminService.editAdmin(admin);
//    }
//    
//    private String doGetCookieValue(String cookieName) {
//        return CookieUtil.getCookieValue(cookieName, getCurrentRequest());
//    }
//    
//    private void doRemoveCookie(String cookieName) {
//        CookieUtil.removeCookie(
//            cookieName, 
//            getConfigPropertyLoader().getCookieDomain(), 
//            getSystemPropertyLoader().getCookiePath(), 
//            getCurrentRequest(), 
//            getCurrentResponse());
//    }
//    
//    private void doAddCookie(String cookieName, String cookieValue) {
//        CookieUtil.addCookie(
//            cookieName, 
//            cookieValue, 
//            getSystemPropertyLoader().getCookieMaxAge(), 
//            getConfigPropertyLoader().getCookieDomain(), 
//            getSystemPropertyLoader().getCookiePath(), 
//            getCurrentRequest(), 
//            getCurrentResponse());
//    }
	
}