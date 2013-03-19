package com.mjee.helper;

import com.mjee.loader.ConfigPropertyLoader;
import com.mjee.loader.SystemPropertyLoader;
import com.mtoolkit.spring.SpringContextHolder;

public final class BeanHelper {
    
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
