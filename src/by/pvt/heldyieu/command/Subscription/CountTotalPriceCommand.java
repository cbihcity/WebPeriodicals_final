package by.pvt.heldyieu.command.Subscription;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;

public class CountTotalPriceCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(CountTotalPriceCommand.class);

    private String prepareAddSubscriptionPage;
    private String errorPage = null;
    private String resultPage = null;
	
	public CountTotalPriceCommand() {
		LOGGER.info("Initializing CountTotalPriceCommand command");
		prepareAddSubscriptionPage = resmanager.getProperty("_addSubscriptionPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
				try {
					Magazine magazine = MagazineServiceImpl.getInstance().getMagazine(Integer.valueOf(request.getParameter("mag_id")));
					SubscriptionType subscriptionType = SubscriptionTypeServiceImpl.getInstance().getSubscriptionType(Integer.valueOf(request.getParameter("type_id")));
					request.setAttribute("mag", magazine);
					request.setAttribute("user", request.getParameter("user"));
					request.setAttribute("type", subscriptionType);
					request.setAttribute("total", subscriptionType.getMonthValue()*Double.valueOf(request.getParameter("price")));
					resultPage = prepareAddSubscriptionPage;
				} catch (NumberFormatException e) {
					resultPage = errorPage;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return resultPage;
	}

}
