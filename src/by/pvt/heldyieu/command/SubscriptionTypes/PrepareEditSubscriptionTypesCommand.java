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
	private static SubscriptionTypeServiceImpl subscriptionTypeServiceImpl = null;
    private String errorPage;
    private String editSubscriptionTypePage;
    private String resultPage = null;
	
	public PrepareEditSubscriptionTypesCommand() {
		LOGGER.info("Initializing PrepareEditSubscriptionTypesCommand command");
		editSubscriptionTypePage = resmanager.getProperty("editSubscriptionTypePage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
			try {
				SubscriptionType subscriptionType = subscriptionTypeServiceImpl.getSubscriptionType(Integer.valueOf(request.getParameter("type_id")));
				request.setAttribute("type", subscriptionType);
				resultPage = editSubscriptionTypePage;
			} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at PrepareEditSubscriptionTypesCommand");
					resultPage = errorPage;
				} 
		return resultPage;
	}

}
