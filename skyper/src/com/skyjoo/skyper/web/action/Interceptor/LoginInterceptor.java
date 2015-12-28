package com.skyjoo.skyper.web.action.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;



public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String[] IGNORE_URI = {"/login.htm","/index.htm"};
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        System.out.println(">>>: " + url);
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
              
                return true;
            }
        }  
    	Cookyjar cookyjar = (Cookyjar) request.getAttribute(Cookyjar.CookyjarInRequest);
    	SystemUserAgent userAgent = (SystemUserAgent)cookyjar.getObject(SystemUserAgent.class);
    	if(userAgent!=null)
    	{
    	return true;
    	}
    	 response.sendRedirect(request.getContextPath() + "/login.htm");  
    	
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}