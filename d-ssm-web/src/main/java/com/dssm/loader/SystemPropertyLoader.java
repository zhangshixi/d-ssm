package com.dssm.loader;

import java.util.Properties;

import com.mtoolkit.spring.config.PropertyLoader;

public class SystemPropertyLoader implements PropertyLoader {

    private Properties systemProps;
    
    @Override
    public void load(Properties props) {
        systemProps = props;
    }

    /* ---- log ---- */
    public String getLogHome() {
    	return trim(System.getProperty("log.home"));
    }
    
    /* ---- private methods ---- */
    private String getProperty(String key) {
    	return trim(systemProps.getProperty(key));
    }
    
    private String trim(String source) {
    	return source == null ? null :source.trim();
    }
    
}
