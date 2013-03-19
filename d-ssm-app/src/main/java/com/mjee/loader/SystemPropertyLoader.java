package com.mjee.loader;

import java.util.Properties;

import com.mtoolkit.spring.config.PropertyLoader;

public class SystemPropertyLoader implements PropertyLoader {

    private Properties systemProps;
    
    @Override
    public void load(Properties props) {
        systemProps = props;
    }
    
    // ---- cookie ---------------------------------------------
    /**
     * Getter method for property <tt>cookie.username.name</tt>.
     * 
     * @return property value of cookie.username.name
     */
    public String getCookieUsernameName() {
        return systemProps.getProperty("cookie.username.name");
    }
    
    /**
     * Getter method for property <tt>cookie.password.name</tt>.
     * 
     * @return property value of cookie.password.name
     */
    public String getCookiePasswordName() {
        return systemProps.getProperty("cookie.password.name");
    }
    
    
    // ---- session --------------------------------------------
    /**
     * Getter method for property <tt>session.user.key</tt>.
     * 
     * @return property value of session.user.key
     */
    public String getSessionUserKey() {
        return systemProps.getProperty("session.user.key");
    }
    
    /**
     * Getter method for property <tt>session.captcha.key</tt>.
     * 
     * @return property value of session.captcha.key
     */
    public String getSessionCaptchaKey() {
        return systemProps.getProperty("session.captcha.key");
    }
    
    
    // ---- others ---------------------------------------------
    /**
     * Getter method for property <tt>callback.url.name</tt>.
     * 
     * @return property value of callback.url.name
     */
    public String getCallbackUrlName() {
        return systemProps.getProperty("callback.url.name");
    }
    
}
