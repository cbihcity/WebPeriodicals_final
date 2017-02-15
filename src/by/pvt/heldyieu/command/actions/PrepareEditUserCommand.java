package by.pvt.heldyieu.command.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class PrepareEditUserCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(PrepareEditUserCommand.class);
	private static UserServiceImpl userServiceImpl = null;
    private String errorPage;
    private String editUserPage;
    private String resultPage = null;
	
	public PrepareEditUserCommand() {
		LOGGER.info("Initializing PrepareEditUserCommand command");
		editUserPage = resmanager.getProperty("editUserPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		userServiceImpl = UserServiceImpl.getInstance();
			try {
				User user = userServiceImpl.getUser(Integer.valueOf(request.getParameter("user_id")));
				UserType[] listOfUsersTypes = UserType.values();
				request.setAttribute("list", listOfUsersTypes);
				request.setAttribute("user", user);
				resultPage = editUserPage;
			} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at PrepareEditUserCommand");
					resultPage = errorPage;
				} 
		return resultPage;
	}
}
