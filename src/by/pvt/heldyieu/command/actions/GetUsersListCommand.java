package by.pvt.heldyieu.command.actions;

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
		private static UserServiceImpl userServiceImpl;
	    private static String usersPage;
	    private static String errorPage;
	    private static String resultPage = null;
	    List<User> listOfUsers = new ArrayList<User>();
		
		public GetUsersListCommand() {
			LOGGER.info("Initializing GetUsersListCommand commans");
			usersPage = resmanager.getProperty("usersPage");
			errorPage = resmanager.getProperty("errorPage");
		}
		
		@Override
		public String execute(HttpServletRequest request,
				HttpServletResponse response) {
			userServiceImpl = UserServiceImpl.getInstance();
			try {
				listOfUsers = userServiceImpl.getAllUsers();
				if (listOfUsers!=null) {
					request.setAttribute("list", listOfUsers);
					resultPage =  usersPage;
				}
			} catch (SQLException e) {
				LOGGER.error("SqlException at GetUsersListCommand");
	        	request.setAttribute("errormessage", "SqlException at GetUsersListCommand");
	        	resultPage =  errorPage;
			}
			return resultPage;
		}
	}
