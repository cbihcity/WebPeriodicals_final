package by.pvt.heldyieu.command.user;

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
	private UserServiceImpl userServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage;
	
	public EditUserCommand() {
		LOGGER.info(INITIALIZING_EDIT_USER_COMMAND);
		sucessPage = resmanager.getProperty(SUCESS_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		userServiceImpl = UserServiceImpl.getInstance();
		if (!request.getParameter(FIRST_NAME).equals("")
				&& !request.getParameter(LAST_NAME).equals("")
				&& !request.getParameter(EMAIL).equals("")
				&& !request.getParameter(PASSWORD).equals("")) {
			try {
				User user  = new User();
				user.setId(Integer.valueOf(request.getParameter(USER_ID)));
				user.setFirstName(request.getParameter(FIRST_NAME));
				user.setLastName(request.getParameter(LAST_NAME));
				user.setUserType(UserType.valueOf(request.getParameter(CATEGORY)));
				user.setEmail(request.getParameter(EMAIL));
				user.setPassword(request.getParameter(PASSWORD));
				userServiceImpl.updateUser(user);
					request.setAttribute(SUCCESS_MESSAGE, USER_EDIT_SUCCESS);
					resultPage =  sucessPage;
			} catch (SQLException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_EDIT_USER_COMMAND);
					resultPage = errorPage;
				}
		} else {
			request.setAttribute(ERROR_MESSAGE,
					PLEASE_INSERT_ALL_FIELDS);
			resultPage = errorPage;
		}
		return resultPage;
	}
}
