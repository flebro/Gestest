package com.master.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class SessionFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws IOException, ServletException {
		
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			if((!request.getRequestURI().contains("/css")  && !request.getRequestURI().contains("/js") && !request.getRequestURI().contains("/login")) &&
					request.getSession().getAttribute("user")== null){
				response.sendRedirect(request.getContextPath() + "/login");
			}
			else {
				chain.doFilter(req, resp);
			}
		}
		
		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			// TODO Auto-generated method stub
			Filter.super.init(filterConfig);
		}
		
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			Filter.super.destroy();
		}
}

