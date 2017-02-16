package by.pvt.heldyieu.command.SubscriptionTypes;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;

public class ShowSubscriptionTypesCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(ShowSubscriptionTypesCommand.class);

	private static SubscriptionTypeServiceImpl subscriptionTypeServiceImpl;

    private static String subscriptionTypesPage;
    private static String errorPage;
    private static String resultPage = null;
	
	public ShowSubscriptionTypesCommand() {
		LOGGER.info("Initializing ShowSubscriptionTypesCommand command");
		subscriptionTypesPage = resmanager.getProperty("subscriptionTypesPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
		try {
			List<SubscriptionType> list = subscriptionTypeServiceImpl.getAllSubscriptionTypes();
			if (list!=null) {
				request.setAttribute("list", list);
				resultPage =  subscriptionTypesPage;
			}
		} catch (SQLException e) {
			LOGGER.error("SqlException at ShowSubscriptionTypesCommand");
        	request.setAttribute("errormessage", "SqlException at ShowSubscriptionTypesCommand");
        	resultPage =  errorPage;
		}
		return resultPage;
	}

}
