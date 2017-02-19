package by.pvt.heldyieu.command.Subscription;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private String errorPage;
    private String resultPage;
	
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
					Double total = subscriptionType.getMonthValue()*Double.valueOf(request.getParameter("price"));
					request.setAttribute("total", round(total,2));
					resultPage = prepareAddSubscriptionPage;
				} catch (NumberFormatException e) {
					LOGGER.error("NumberFormatException at CountTotalPriceCommand");
					request.setAttribute("errormessage",
							"NumberFormatException at CountTotalPriceCommand");
					resultPage = errorPage;
				} catch (SQLException e) {
					LOGGER.error("SqlException at CountTotalPriceCommand");
					request.setAttribute("errormessage",
							"SqlException at CountTotalPriceCommand");
					resultPage = errorPage;
				}
		return resultPage;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
