package com.dssm.loader;

import java.util.Properties;

import com.mtoolkit.spring.config.PropertyLoader;

public class ConfigPropertyLoader implements PropertyLoader {

    private Properties configProps;
    
    @Override
    public void load(Properties props) {
        configProps = props;
    }
    
    
    
    /* ---- private methods ---- */
    private String getProperty(String key) {
    	return trim(configProps.getProperty(key));
    }
    
    private String trim(String source) {
    	return source == null ? null :source.trim();
    }
    
}
