package com.dssm.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class VisitorHolder {
    
    private static final ThreadLocal<HttpServletRequest> REQUEST_HOLDER = new ThreadLocal<HttpServletRequest>();
    private static final ThreadLocal<HttpServletResponse> RESPONSE_HOLDER = new ThreadLocal<HttpServletResponse>();
    
    public static void setVisitRequest(HttpServletRequest request) {
        REQUEST_HOLDER.set(request);
    }
    
    public static HttpServletRequest getVisitRequest() {
        return REQUEST_HOLDER.get();
    }
    
    public static void removeVisitRequest() {
        REQUEST_HOLDER.remove();
    }
    
    public static void setVisitResponse(HttpServletResponse response) {
        RESPONSE_HOLDER.set(response);
    }
    
    public static HttpServletResponse getVisitResponse() {
        return RESPONSE_HOLDER.get();
    }
    
    public static void removeVisitResponse() {
        RESPONSE_HOLDER.remove();
    }
    
}
