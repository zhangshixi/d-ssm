package com.dssm.loader;

import com.mtoolkit.spring.config.AbstractPropertyLoader;

public class SystemPropertyLoader extends AbstractPropertyLoader {

    /* ---- log ---- */
    public String getLogHome() {
    	return getProperty("system.log.home");
    }
    
}
