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
	
}