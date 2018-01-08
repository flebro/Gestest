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

import com.master.model.Candidat;
import com.master.model.Personne;

@WebFilter("/user*")
public class SessionFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		Personne user = (Personne) request.getSession().getAttribute("user");
		
		if (user != null && user instanceof Candidat) {
			chain.doFilter(req, resp);
		} else {
			response.sendRedirect(request.getContextPath() + "/home");
		}
	}

	private boolean doesNotNeedAuth(String URI) {
		return URI.contains("/js") || URI.contains("/css") || URI.contains("/login");
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

