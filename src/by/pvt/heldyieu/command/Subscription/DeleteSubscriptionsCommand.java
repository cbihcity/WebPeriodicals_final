package by.pvt.heldyieu.command.Subscription;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.service.subscription.SubscriptionServiceImpl;

public class DeleteSubscriptionsCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(DeleteSubscriptionsCommand.class);

	private SubscriptionServiceImpl subscriptionServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage;
	
	public DeleteSubscriptionsCommand() {
		LOGGER.info(INITIALIZING_DELETE_SUB_SCRIPTIONS_COMMAND);
		sucessPage = resmanager.getProperty(SUCESS_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionServiceImpl = SubscriptionServiceImpl.getInstance();
				boolean result = false;
				try {
					result = subscriptionServiceImpl.deleteSubscription(Integer.valueOf(request.getParameter(SUB_ID)));
					if (result) {
						request.setAttribute(SUCCESS_MESSAGE, SUBSCRIPTION_DELETE_SUCCESS);
						resultPage =  sucessPage;
					} 
				 else {
						request.setAttribute(ERROR_MESSAGE,
								SQLEXCEPTION_AT_DELETE_SUBSCRIPTIONS_COMMAND);
						resultPage = errorPage;
					}
				} catch (NumberFormatException e) {
					request.setAttribute(ERROR_MESSAGE,
							NUMBER_FORMAT_EXCEPTION_AT_DELETE_SUBSCRIPTIONS_COMMAND);
					resultPage = errorPage;
				} catch (SQLException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_DELETE_SUBSCRIPTIONS_COMMAND);
					resultPage = errorPage;
				}
		return resultPage;
	}

}
