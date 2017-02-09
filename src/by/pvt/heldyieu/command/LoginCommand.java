package by.pvt.heldyieu.command;

import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class LoginCommand implements ServletCommand {
	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

	private static UserServiceImpl userService;

    private static String adminPage;
    private static String userPage;
    private static String errorPage;
    private static String mainPage;
	
	public LoginCommand() {
		LOGGER.info("Initializing LoginCommand");
		adminPage = resmanager.getProperty("adminPage");
		userPage = resmanager.getProperty("userPage");
		errorPage = resmanager.getProperty("errorPage");
		mainPage = resmanager.getProperty("mainPage");
		
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String resultPage = mainPage;
		String reqEmail = request.getParameter("email");
		String reqPass = request.getParameter("password");
		userService = UserServiceImpl.getInstance();
		LOGGER.info("Executing command");
		//HttpSession session = request.getSession();
				
		if (reqEmail !="" || reqPass!= "") {
            try {
            	User user = userService.findUserByEmail(reqEmail, reqPass);
                if (user == null) {
                	LOGGER.error("Error login"); 
                	request.setAttribute("errormessage", "Error login");
                	resultPage = errorPage;
                } else {
                
                //Если авторизация выполнена, то присваиваем сессии соответствующие атрибуты
                //и устанавливаем куки
                request.setAttribute("session", user.getUserType().getValue().toString());
                request.setAttribute("user", user.getFirstName());
                request.setAttribute("email", user.getEmail());
                Cookie c = new Cookie("id", String.valueOf(user.getId()));
                c.setMaxAge(60*60*24*7);
                response.addCookie(c);
                if(Objects.equals(user.getUserType(), UserType.ADMIN)) {
                	resultPage = adminPage;
                }
                else {
                    
                	resultPage = userPage;
                }
                }
            } catch (SQLException e) {
            	LOGGER.error("SqlException at LoginUserAction");
            	request.setAttribute("errormessage", "SqlException at LoginUserAction");
            	resultPage = errorPage;
            }
        }
		
		
//        if(reqEmail == "" || reqPass == "") {
//            LOGGER.info("Returning login page");
//            request.getSession().setAttribute("session", "");
//            request.getSession().setAttribute("errorLogin", "Please input email and password");
//            return resultPage;
//        }
//        else {
//            User user;
//			try {
//				user = userService.findUserByEmail(reqEmail, reqPass);
//				if (user != null) {
//	                HttpSession session = request.getSession();
//	                session.setAttribute("user", user.getFirstName());
//	                session.setAttribute("email", user.getEmail());
//	                session.setAttribute("authenticated", true);
//	                session.setAttribute("session", user.getUserType().getValue());
//
//	                if(Objects.equals(user.getUserType(), UserType.ADMIN)) {
//	                    return resultPage = adminPage;
//	                }
//	                else {
//	                    
//	                    return resultPage = userPage;
//	                }
//	            } else {
//	            	request.getSession().setAttribute("errorLogin", resmanager.getProperty("loginError"));
//	            	return resultPage = loginPage;
//	            }
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
		return resultPage;
	}
}
