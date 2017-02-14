package by.pvt.heldyieu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class ConfigFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(ConfigFilter.class);
	private static String ID = "id";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// устанавливаем кодировку
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		try {
			// смотрим куки
			initSession(((HttpServletRequest) request).getSession(),
					(HttpServletRequest) request);
		} catch (RuntimeException e) {
			LOGGER.error(e.getMessage());
		}

		chain.doFilter(request, response);
	}

	private void initSession(HttpSession session, HttpServletRequest request) {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					// looking for user id (for authorize purpose)
					if ((c.getName()).equals(ID)) {
						try {
							User user = UserServiceImpl.getInstance().getUser(
									Integer.parseInt(c.getValue()));
							session.setAttribute("user", user);
							
						} catch (SQLException e) {
							LOGGER.error(e.getMessage());
						}
					}
				}// end of foreach loop
			}// end of if(cookies != null)
		}// end of if(session)

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
