package com.dssm.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.google.code.kaptcha.Constants;

public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	
	@Override
	protected boolean executeLogin(
			ServletRequest request, ServletResponse response) throws Exception {
		CaptchaUsernamePasswordToken token = createToken(request, response);
		
        try {
        	doValidateCaptcha((HttpServletRequest) request, token.getCaptcha());
        	
            Subject subject = getSubject(request, response);
            subject.login(token);
            
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
	}
	
	@Override
	protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
		String captcha = getCaptcha(request);
		
		return new CaptchaUsernamePasswordToken(username, password, rememberMe, host, captcha);
	}
	
	protected void doValidateCaptcha(HttpServletRequest request, String captcha) {
		String sessionCaptcha = getSessionCaptcha(request);
		if (sessionCaptcha != null && !sessionCaptcha.equalsIgnoreCase(captcha)) {
			throw new IncorrectCaptchaException("Incorrect captcha!");
		}
	}
	
	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}
	
	protected String getSessionCaptcha(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
	}
	
	public String getCaptchaParam() {
		return captchaParam;
	}
	
	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}
	
}
