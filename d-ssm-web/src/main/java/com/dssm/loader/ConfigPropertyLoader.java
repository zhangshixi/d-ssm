package com.dssm.loader;

import java.util.Properties;

import com.mtoolkit.spring.config.PropertyLoader;

public class ConfigPropertyLoader implements PropertyLoader {

    private Properties configProps;
    
    @Override
    public void load(Properties props) {
        configProps = props;
    }
    
    
    /* ---- cookie ---- */
    /**
     * Getter method for property <tt>cookie.domain</tt>.
     * 
     * @return property value of cookie.domain
     */
    public String getCookieDomain() {
        return getProperty("cookie.domain");
    }
    
    
    /* ---- others ---- */
    
    
    /* ---- private methods ---- */
    private String getProperty(String key) {
    	return configProps.getProperty(key).trim();
    }
    
}
