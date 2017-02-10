package by.pvt.heldyieu.command.actions;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class LoginCommand implements ServletCommand {
	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

	private static UserServiceImpl userService;

    private static String errorPage;
	
	public LoginCommand() {
		LOGGER.info("Initializing LoginCommand");
		errorPage = resmanager.getProperty("errorPage");
		
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String resultPage = null;
		String reqEmail = request.getParameter("email");
		String reqPass = request.getParameter("password");
		userService = UserServiceImpl.getInstance();
		LOGGER.info("Executing command");
		HttpSession session = request.getSession();
				
		if (reqEmail !="" && reqPass!= "") {
            try {
            	User user = userService.findUserByEmail(reqEmail, reqPass);
                if (user == null) {
                	LOGGER.error("Error login"); 
                	request.setAttribute("errormessage", "Error login");
                	resultPage = errorPage;
                } else {
                
                //Если авторизация выполнена, то присваиваем сессии соответствующие атрибуты
                //и устанавливаем куки
                session.setAttribute("user", user);
                Cookie c = new Cookie("id", String.valueOf(user.getId()));
                c.setMaxAge(60*60*24*7);
                response.addCookie(c);
                }
            } catch (SQLException e) {
            	LOGGER.error("SqlException at LoginUserAction");
            	request.setAttribute("errormessage", "SqlException at LoginUserAction");
            	resultPage = errorPage;
            }
        }
		return resultPage;
	}
}
