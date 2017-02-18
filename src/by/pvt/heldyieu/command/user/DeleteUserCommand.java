package by.pvt.heldyieu.command.user;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class DeleteUserCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(DeleteUserCommand.class);

	private UserServiceImpl userServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage;
	
	public DeleteUserCommand() {
		LOGGER.info("Initializing DeleteUserCommand command");
		sucessPage = resmanager.getProperty("sucessPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		userServiceImpl = UserServiceImpl.getInstance();
				boolean result = false;
				try {
					result = userServiceImpl.deleteUser(Integer.valueOf(request.getParameter("user_id")));
				} catch (NumberFormatException e) {
					request.setAttribute("errormessage", "NumberFormatException exception ");
					resultPage =  errorPage;
				} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at DeleteUserCommand");
					resultPage = errorPage;
				}
				if (result) {
					request.setAttribute("sucessmessage", "Пользователь успешно удален!");
					resultPage =  sucessPage;
				} 
		return resultPage;
	}

}
