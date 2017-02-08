package by.pvt.heldyieu.command;

import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class LoginCommand implements ServletCommand {
	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

	private static UserServiceImpl userService;

    private static String loginPage;
    private static String adminPage;
    private static String userPage;
	
	public LoginCommand() {
		LOGGER.info("Initializing LoginCommand");
		userService = UserServiceImpl.getInstance();
		loginPage = resmanager.getProperty("loginPage");
		adminPage = resmanager.getProperty("adminPage");
		userPage = resmanager.getProperty("userPage");
	}



	@Override
	public String execute(HttpServletRequest request) {
		LOGGER.info("Executing command");
		String resultPage = loginPage;

        if(request.getParameter("login") == null && request.getParameter("email") == null) {
            LOGGER.info("Returning login page");
            return resultPage;
        }
        else {
            User user;
			try {
				user = userService.findUserByEmail(request.getParameter("email"));
				if (user != null) {
	                HttpSession session = request.getSession();
	                session.setAttribute("user", user.getFirstName());
	                session.setAttribute("email", user.getEmail());
	                session.setAttribute("authenticated", true);
	                session.setAttribute("sessionScope", user.getUserType().getValue());

	                if(Objects.equals(user.getUserType(), UserType.ADMIN)) {
	                    resultPage = adminPage;
	                }
	                else {
	                    
	                    resultPage = userPage;
	                }
	            } else {
	            	request.getSession().setAttribute("errorLoginPassMessage", resmanager.getProperty("loginError"));
	            	resultPage = loginPage;
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return resultPage;
	}
}
