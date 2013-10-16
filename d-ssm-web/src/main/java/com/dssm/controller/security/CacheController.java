package com.dssm.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dssm.controller.BaseController;
import com.dssm.service.security.support.RoleServiceSupport.RoleCache;
import com.mtoolkit.cache.callback.CallbackCache;

@Controller
@RequestMapping("/cache")
public class CacheController extends BaseController {
	
	@Autowired
	private CallbackCache cache;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
	    return "back/cache/index";
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public String remove(CacheType cacheType) {
	    cache.asyncRemove(cacheType.generateCacheKey());
	    
	    return redirectTo("/cache");
	}
	
	
	public static class CacheType {
	    private String cacheKey;
	    private String cacheType;
	    
	    
	    public String generateCacheKey() {
	        switch (cacheType) {
                case "admin":
                    return doGenerateAdminCacheKey(cacheKey);
                case "role":
                    return doGenerateRoleCacheKey(cacheKey);
                default:
                    break;
            }
	        return null;
	    }
	    
        public String doGenerateAdminCacheKey(String cacheKey) {
	        return null;
	    }
        
        private String doGenerateRoleCacheKey(String cacheKey) {
            return RoleCache.generateRoleCacheKey(Integer.valueOf(cacheKey));
        }
	    
	}



	
}
