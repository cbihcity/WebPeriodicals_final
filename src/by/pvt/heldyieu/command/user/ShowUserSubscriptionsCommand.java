package by.pvt.heldyieu.command.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Subscription;
import by.pvt.heldyieu.service.subscription.SubscriptionServiceImpl;

public class ShowUserSubscriptionsCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(ShowUserSubscriptionsCommand.class);
	private static SubscriptionServiceImpl subscriptionServiceImpl;
    private static String usersSubscriptionsPage;
    private static String errorPage;
    private static String resultPage = null;
    List<Subscription> listOfSubscriptions = new ArrayList<>();
	
	public ShowUserSubscriptionsCommand() {
		LOGGER.info("Initializing ShowAllMagazines command");
		usersSubscriptionsPage = resmanager.getProperty("usersSubscriptionsPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionServiceImpl = SubscriptionServiceImpl.getInstance();
		try {
			if (request.getParameter("email")!=null) {
				listOfSubscriptions = subscriptionServiceImpl.findSubscriptionByEmail(request.getParameter("email"));
				if (listOfSubscriptions!=null) {
					request.setAttribute("list", listOfSubscriptions);
					resultPage =  usersSubscriptionsPage;
				} else {
					request.setAttribute("errormessage", "SqlException at ShowAllMagazinesCommand");
		        	resultPage =  errorPage;
				}
			} else {
				listOfSubscriptions = subscriptionServiceImpl.getAllSubscriptions();
				if (listOfSubscriptions!=null) {
					request.setAttribute("list", listOfSubscriptions);
					resultPage =  usersSubscriptionsPage;
				} else {
					request.setAttribute("errormessage", "SqlException at ShowAllMagazinesCommand");
		        	resultPage =  errorPage;
				}
			}
			
		} catch (SQLException e) {
			LOGGER.error("SqlException at ShowAllMagazinesCommand");
        	request.setAttribute("errormessage", "SqlException at ShowAllMagazinesCommand");
        	resultPage =  errorPage;
		}
		return resultPage;
	}
}
