package by.pvt.heldyieu.command.Subscription;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.service.subscription.SubscriptionServiceImpl;

public class DeleteSubscriptionsCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(DeleteSubscriptionsCommand.class);

	private static SubscriptionServiceImpl subscriptionServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage = null;
	
	public DeleteSubscriptionsCommand() {
		LOGGER.info("Initializing DeleteSubscriptionsCommand command");
		sucessPage = resmanager.getProperty("sucessPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionServiceImpl = SubscriptionServiceImpl.getInstance();
				boolean result = false;
				try {
					result = subscriptionServiceImpl.deleteSubscription(Integer.valueOf(request.getParameter("sub_id")));
					if (result) {
						request.setAttribute("sucessmessage", "Издание успешно удалено!");
						resultPage =  sucessPage;
					} 
				 else {
						request.setAttribute("errormessage",
								"SqlException at DeleteSubscriptionsCommand");
						resultPage = errorPage;
					}
				} catch (NumberFormatException e) {
					request.setAttribute("errormessage",
							"NumberFormatException at DeleteSubscriptionsCommand");
					resultPage = errorPage;
				} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at DeleteSubscriptionsCommand");
					resultPage = errorPage;
				}
		return resultPage;
	}

}
