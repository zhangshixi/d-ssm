package com.dssm.loader;

import java.util.Properties;

import com.mtoolkit.spring.config.PropertyLoader;

public class SystemPropertyLoader implements PropertyLoader {

    private Properties systemProps;
    
    @Override
    public void load(Properties props) {
        systemProps = props;
    }
    
    /* ---- cookie ---- */
    /**
     * Getter method for property <tt>cookie.username.name</tt>.
     * 
     * @return property value of cookie.username.name
     */
    public String getCookieUsernameName() {
        return getProperty("cookie.username.name");
    }
    
    /**
     * Getter method for property <tt>cookie.password.name</tt>.
     * 
     * @return property value of cookie.password.name
     */
    public String getCookiePasswordName() {
        return getProperty("cookie.password.name");
    }
    
    /**
     * Getter method for property <tt>cookie.path</tt>.
     * 
     * @return property value of cookie.path
     */
    public String getCookiePath() {
        return getProperty("cookie.path");
    }
    
    /**
     * Getter method for property <tt>cookie.max.age</tt>.
     * 
     * @return property value of cookie.max.age
     */
    public int getCookieMaxAge() {
        return Integer.parseInt(getProperty("cookie.max.age"));
    }
    
    /* ---- session ---- */
    /**
     * Getter method for property <tt>session.user.key</tt>.
     * 
     * @return property value of session.user.key
     */
    public String getSessionUserKey() {
        return getProperty("session.user.key");
    }
    
    /**
     * Getter method for property <tt>session.captcha.key</tt>.
     * 
     * @return property value of session.captcha.key
     */
    public String getSessionCaptchaKey() {
        return getProperty("session.captcha.key");
    }
    
    
    /* ---- others ---- */
    /**
     * Getter method for property <tt>callback.url.name</tt>.
     * 
     * @return property value of callback.url.name
     */
    public String getCallbackUrlName() {
        return getProperty("callback.url.name");
    }
    
    
    /* ---- private methods ---- */
    private String getProperty(String key) {
    	return systemProps.getProperty(key).trim();
    }
    
}
