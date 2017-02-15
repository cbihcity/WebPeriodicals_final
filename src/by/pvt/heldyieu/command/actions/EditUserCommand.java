package by.pvt.heldyieu.command.actions;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class EditUserCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(EditUserCommand.class);
	private static UserServiceImpl userServiceImpl = null;
    private String errorPage;
    private String sucessPage;
    private String resultPage = null;
	
	public EditUserCommand() {
		LOGGER.info("Initializing EditUserCommand command");
		sucessPage = resmanager.getProperty("sucessPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		userServiceImpl = UserServiceImpl.getInstance();
		if (request.getParameter("firstName") != ""
				&& request.getParameter("lastName") != ""
				&& request.getParameter("email") != ""
				&& request.getParameter("password") != "") {
			try {
				User user  = new User();
				user.setId(Integer.valueOf(request.getParameter("user_id")));
				user.setFirstName(request.getParameter("firstName"));
				user.setLastName(request.getParameter("lastName"));
				user.setUserType(UserType.valueOf(request.getParameter("category")));
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("password"));
				userServiceImpl.updateUser(user);
					request.setAttribute("sucessmessage", "Пользователь успешно изменен!");
					resultPage =  sucessPage;
			} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at EditUserCommand");
					resultPage = errorPage;
				}
		} else {
			request.setAttribute("errormessage",
					"Please insert all fields");
			resultPage = errorPage;
		}
		return resultPage;
	}
}
