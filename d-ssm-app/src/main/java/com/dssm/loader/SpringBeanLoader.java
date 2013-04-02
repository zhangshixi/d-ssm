package com.dssm.loader;

import com.mtoolkit.spring.SpringContextHolder;

public final class SpringBeanLoader {
    
    public static <T> T getBean(String name) {
        return SpringContextHolder.getBean(name);
    }
    
    public static SystemPropertyLoader getSystemPropertyLoader() {
        return SpringContextHolder.getBean("systemPropertyLoader");
    }
    
    public static ConfigPropertyLoader getConfigPropertyLoader() {
        return SpringContextHolder.getBean("configPropertyLoader");
    }
    
}
