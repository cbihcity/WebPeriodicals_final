package by.pvt.heldyieu.command.user;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class AddUserCommand implements ServletCommand {
	private static final Logger LOGGER = Logger.getLogger(AddUserCommand.class);
    
    private String sucessPage = resmanager.getProperty("sucessPage");
    private String errorPage = resmanager.getProperty("errorPage");
    private String resultPage;
    
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		User user = new User();
		if ( !first_name.equals("")
				&& !last_name.equals("")
				&& !email.equals("")
				&& !pass.equals("")) {
			user.setFirstName(first_name);
			user.setLastName(last_name);
			user.setEmail(email);
			user.setPassword(pass);
			user.setUserType(UserType.USER);
			try {
				UserServiceImpl.getInstance().addUser(user);
			request.setAttribute("sucessmessage", "Новый пользователь создан!");
				resultPage = sucessPage;
			} catch (SQLException e) {
				LOGGER.error("SqlException at AddUserCommand");
				request.setAttribute("errormessage",
						"SqlException at AddUserCommand");
				resultPage = errorPage;
			}
		} else {
			request.setAttribute("errormessage", "Please insert all fields");
			resultPage = errorPage;
		}
		return resultPage;
	}

}
