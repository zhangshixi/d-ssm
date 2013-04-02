package com.dssm.loader;

import java.util.Properties;

import com.mtoolkit.spring.config.PropertyLoader;

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
    public int getCookieMaxAge() {
        return Integer.parseInt(getProperty("cookie.max.age"));
    }
    
    
    // ---- others ---------------------------------------------
    
    
    // ---- private methods ------------------------------------
    private String getProperty(String key) {
    	return deployProps.getProperty(key).trim();
    }
    
}
