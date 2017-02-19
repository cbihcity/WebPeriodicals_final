package by.pvt.heldyieu.command.Subscription;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;

public class PrepareAddSubscriptionCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(PrepareAddSubscriptionCommand.class);

	private MagazineServiceImpl magazineServiceImpl;
	private SubscriptionTypeServiceImpl subscriptionTypeServiceImpl;
    private String errorPage;
    private String prepareAddSubscriptionPage;
    private String resultPage;
	
	public PrepareAddSubscriptionCommand() {
		LOGGER.info(INITIALIZING_PREPARE_ADD_SUB_SCRIPTION_COMMAND);
		prepareAddSubscriptionPage = resmanager.getProperty(ADD_SUBSCRIPTION_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
			try {
				Magazine magazine = magazineServiceImpl.getMagazine(Integer.valueOf(request.getParameter(MAG_ID)));
				List<SubscriptionType> list = subscriptionTypeServiceImpl.getAllSubscriptionTypes();
				request.setAttribute(LIST, list);
				request.setAttribute(MAG, magazine);
				request.setAttribute(USER, request.getParameter(USER));
				resultPage = prepareAddSubscriptionPage;
			} catch (SQLException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_PREPARE_ADD_SUBSCRIPTION_COMMAND);
					resultPage = errorPage;
				} 
		return resultPage;
	}

}
