/**
 * f-club.cn
 * Copyright (c) 2009-2012 All Rights Reserved.
 */
package com.mjee.app.loader;

import java.util.Properties;

import com.mtoolkit.spring.config.PropertyLoader;

/**
 * 
 * @author michael
 * @version $Id: DeployPropertyLoader.java, v 0.1 2012-8-16 下午1:47:44 michael Exp $
 */
public class ConfigPropertyLoader implements PropertyLoader {

    private Properties deployProps;
    
    @Override
    public void load(Properties props) {
        deployProps = props;
    }
    
    
    // ---- cookie ---------------------------------------------
    /**
     * Getter method for property <tt>cookie.domain</tt>.
     * 
     * @return property value of cookie.domain
     */
    public String getCookieDomain() {
        return getProperty("cookie.domain");
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
    public String getCookieMaxAge() {
        return getProperty("cookie.max.age");
    }
    
    
    // ---- others ---------------------------------------------
    
    
    // ---- private methods ------------------------------------
    private String getProperty(String key) {
    	return deployProps.getProperty(key).trim();
    }
    
}
