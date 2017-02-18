package by.pvt.heldyieu.command.SubscriptionTypes;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;

public class DeleteSubscriptionTypesCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(DeleteSubscriptionTypesCommand.class);
	private SubscriptionTypeServiceImpl subscriptionTypeServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage;
	
	public DeleteSubscriptionTypesCommand() {
		LOGGER.info("Initializing DeleteSubscriptionTypesCommand command");
		sucessPage = resmanager.getProperty("sucessPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
				boolean result = false;
				try {
					result = subscriptionTypeServiceImpl.deleteSubscriptionType(Integer.valueOf(request.getParameter("type_id")));
					if (result) {
						request.setAttribute("sucessmessage", "Тип подписки успешно удален!");
						resultPage =  sucessPage;
					} 
				 else {
						request.setAttribute("errormessage",
								"SqlException at DeleteSubscriptionTypesCommand");
						resultPage = errorPage;
					}
				} catch (NumberFormatException e) {
					request.setAttribute("errormessage",
							"NumberFormatException at DeleteSubscriptionTypesCommand");
					resultPage = errorPage;
				} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at DeleteSubscriptionTypesCommand");
					resultPage = errorPage;
				}
		return resultPage;
	}
}
