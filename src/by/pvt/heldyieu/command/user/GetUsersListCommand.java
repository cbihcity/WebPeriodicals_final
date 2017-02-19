package by.pvt.heldyieu.command.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class GetUsersListCommand implements ServletCommand {

		private static final Logger LOGGER = Logger.getLogger(GetUsersListCommand.class);
		private UserServiceImpl userServiceImpl;
	    private String usersPage;
	    private String errorPage;
	    private String resultPage;
	    List<User> listOfUsers = new ArrayList<User>();
		
		public GetUsersListCommand() {
			LOGGER.info(INITIALIZING_GET_USERS_LIST_COMMAND);
			usersPage = resmanager.getProperty(USERS_PAGE);
			errorPage = resmanager.getProperty(ERROR_PAGE);
		}
		
		@Override
		public String execute(HttpServletRequest request,
				HttpServletResponse response) {
			userServiceImpl = UserServiceImpl.getInstance();
			try {
				listOfUsers = userServiceImpl.getAllUsers();
				if (listOfUsers!=null) {
					request.setAttribute(LIST, listOfUsers);
					resultPage =  usersPage;
				}
			} catch (SQLException e) {
				LOGGER.error(SQLEXCEPTION_AT_GET_USERS_LIST_COMMAND);
	        	request.setAttribute(ERROR_MESSAGE, SQLEXCEPTION_AT_GET_USERS_LIST_COMMAND);
	        	resultPage =  errorPage;
			}
			return resultPage;
		}
	}
