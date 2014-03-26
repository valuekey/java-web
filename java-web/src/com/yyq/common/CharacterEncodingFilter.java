package com.yyq.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
    
    private FilterConfig config = null;
    private String encoding = "UTF-8";
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        config = null;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
    
    @Override
    public void init(FilterConfig config) throws ServletException {
        // TODO Auto-generated method stub
        this.config = config;
        
        String _encoding = this.config.getInitParameter("encoding");
        if (_encoding != null) {
            this.encoding = _encoding;
        }
    }
    
    
}
