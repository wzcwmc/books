package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private String loginPage = null;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 把请求对象转换程基于HTTP协议的请求对象
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 获取到Session
		HttpSession session = req.getSession();

		// 获得用户请求的URI
		String path = req.getRequestURI();

		if (path.indexOf("/mangLogin.html") > -1
				|| path.indexOf("/readerLogin.html") > -1
				|| path.indexOf("/readerRegister.jsp") > -1
				|| path.indexOf("/repwd.jsp") > -1) {
			chain.doFilter(request, response);
			return;
		}

		if (session.getAttribute("user") == null) {
			
			resp.sendRedirect("/MiniBMS" + loginPage);
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		loginPage = filterConfig.getInitParameter("LoginPage");
	}

}
