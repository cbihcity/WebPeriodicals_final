package by.pvt.heldyieu.command.SubscriptionTypes;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;

public class EditSubscriptionTypeCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(EditSubscriptionTypeCommand.class);
	private static SubscriptionTypeServiceImpl subscriptionTypeServiceImpl = null;
    private String errorPage;
    private String sucessPage;
    private String resultPage = null;
	
	public EditSubscriptionTypeCommand() {
		LOGGER.info("Initializing EditSubscriptionTypeCommand command");
		sucessPage = resmanager.getProperty("sucessPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
		if (request.getParameter("name") != ""
				&& request.getParameter("monthValue") != "") {
			try {
				SubscriptionType subscriptionType  = new SubscriptionType();
				subscriptionType.setId(Integer.valueOf(request.getParameter("type_id")));
				subscriptionType.setName(request.getParameter("name"));
				subscriptionType.setMonthValue(Integer.valueOf(request.getParameter("monthValue")));
				subscriptionTypeServiceImpl.updateSubscriptionType(subscriptionType);
					request.setAttribute("sucessmessage", "Тип подписки успешно изменен!");
					resultPage =  sucessPage;
			} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at EditSubscriptionTypeCommand");
					resultPage = errorPage;
				}
		} else {
			request.setAttribute("errormessage",
					"Please insert all fields");
			resultPage = errorPage;
		}
		return resultPage;
	}
}
