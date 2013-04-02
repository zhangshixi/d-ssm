package com.dssm.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dssm.helper.VisitorHolder;
import com.mtoolkit.servlet.AbstractHttpFilter;

public class VisitHolderFilter extends AbstractHttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        VisitorHolder.setVisitRequest(request);
        VisitorHolder.setVisitResponse(response);
        
        chain.doFilter(request, response);
        
        VisitorHolder.removeVisitRequest();
        VisitorHolder.removeVisitResponse();
    }

}
