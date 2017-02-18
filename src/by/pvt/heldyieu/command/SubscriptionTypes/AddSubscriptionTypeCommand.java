package by.pvt.heldyieu.command.SubscriptionTypes;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;

public class AddSubscriptionTypeCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(AddSubscriptionTypeCommand.class);
    
    private String sucessPage = resmanager.getProperty("sucessPage");
    private String errorPage = resmanager.getProperty("errorPage");
    private String resultPage;
    
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		SubscriptionType subscriptionType = new SubscriptionType();
		if (!request.getParameter("name").equals("")
				&& !request.getParameter("monthValue").equals("")) {
			subscriptionType.setName(request.getParameter("name").trim());
			subscriptionType.setMonthValue(Integer.valueOf(request.getParameter("monthValue")));
			try {
				SubscriptionTypeServiceImpl.getInstance().addSubscriptionType(subscriptionType);
				request.setAttribute("sucessmessage", "Тип подписки добавлен!");
				resultPage = sucessPage;
			} catch (SQLException e) {
				LOGGER.error("SqlException at AddSubscriptionTypeCommand");
				request.setAttribute("errormessage",
						"SqlException at AddSubscriptionTypeCommand");
				resultPage = errorPage;
			}
		} else {
			request.setAttribute("errormessage", "Please insert all fields");
			resultPage = errorPage;
		}
		return resultPage;
	}

}
