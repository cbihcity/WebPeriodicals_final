package by.pvt.heldyieu.command.SubscriptionTypes;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;

public class PrepareEditSubscriptionTypesCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(PrepareEditSubscriptionTypesCommand.class);
	private SubscriptionTypeServiceImpl subscriptionTypeServiceImpl;
    private String errorPage;
    private String editSubscriptionTypePage;
    private String resultPage;
	
	public PrepareEditSubscriptionTypesCommand() {
		LOGGER.info(INITIALIZING_PREPARE_EDIT_SUBSCRIPTION_TYPES_COMMAND);
		editSubscriptionTypePage = resmanager.getProperty(EDIT_SUBSCRIPTION_TYPE_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
			try {
				SubscriptionType subscriptionType = subscriptionTypeServiceImpl.getSubscriptionType(Integer.valueOf(request.getParameter(TYPE_ID)));
				request.setAttribute(TYPE, subscriptionType);
				resultPage = editSubscriptionTypePage;
			} catch (SQLException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_PREPARE_EDIT_SUBSCRIPTION_TYPES_COMMAND);
					resultPage = errorPage;
				} 
		return resultPage;
	}

}
