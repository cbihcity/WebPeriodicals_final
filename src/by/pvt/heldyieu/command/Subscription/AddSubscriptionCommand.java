package by.pvt.heldyieu.command.Subscription;

import java.sql.SQLException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.entity.Subscription;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;
import by.pvt.heldyieu.service.subscription.SubscriptionServiceImpl;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class AddSubscriptionCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(AddSubscriptionCommand.class);
    
    private String sucessPage = resmanager.getProperty("sucessPage");
    private String errorPage = resmanager.getProperty("errorPage");
    private String resultPage;
    
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
			try {
				Date start = new Date();
				Magazine magazine = MagazineServiceImpl.getInstance().getMagazine(Integer.valueOf(request.getParameter("mag_id")));
				SubscriptionType subscriptionType = SubscriptionTypeServiceImpl.getInstance().getSubscriptionType(Integer.valueOf(request.getParameter("type_id")));
				User user = UserServiceImpl.getInstance().getUser(Integer.valueOf(request.getParameter("user_id")));
				Subscription subscription = new Subscription();
				subscription.setUser(user);
				subscription.setMagazine(magazine);
				subscription.setType(subscriptionType);
				subscription.setStartDate(start);
				subscription.setEndDate(Subscription.addDays(start, subscriptionType.getMonthValue()));
				subscription.setPrice(Double.valueOf(request.getParameter("totalprice")));
				SubscriptionServiceImpl.getInstance().addSubscription(subscription);
				request.setAttribute("sucessmessage", "Подписка оформлена!");
				resultPage = sucessPage;
			} catch (SQLException e) {
				LOGGER.error("SqlException at AddSubscriptionCommand");
				request.setAttribute("errormessage",
						"SqlException at AddSubscriptionCommand");
				resultPage = errorPage;
			}
		return resultPage;
	}
}
