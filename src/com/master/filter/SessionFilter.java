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

import com.master.model.Administrateur;
import com.master.model.Personne;

@WebFilter("/*")
public class SessionFilter implements Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws IOException, ServletException {
		
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			Personne user = (Personne) request.getSession().getAttribute("user");
			
			if (doesNotNeedAuth(request.getRequestURI()) || user != null) {
				if (!request.getRequestURI().contains("/admin") || user instanceof Administrateur) {
					chain.doFilter(req, resp);
					return;
				}
			}
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
		private boolean doesNotNeedAuth(String URI) {
			return true;
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

