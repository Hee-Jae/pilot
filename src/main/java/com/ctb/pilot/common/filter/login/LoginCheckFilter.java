package com.ctb.pilot.common.filter.login;

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

import com.ctb.pilot.chat.dao.UserDao;
import com.ctb.pilot.chat.dao.jdbc.JdbcUserDao;
import com.ctb.pilot.chat.model.User;
import com.ctb.pilot.common.util.HttpUtils;

public class LoginCheckFilter implements Filter {

	private UserDao userDao = new JdbcUserDao();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			String sequenceInCookie = HttpUtils.getCookie(httpRequest, "seq");
			if (sequenceInCookie == null) {
				httpResponse.sendRedirect("/common/web_template.jsp?body_path=/services/user/login/login_form.jsp");
				return;
			}
			Integer userSequence = Integer.valueOf(sequenceInCookie);
			user = userDao.getUserBySequence(userSequence);
			session.setAttribute("user", user);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
