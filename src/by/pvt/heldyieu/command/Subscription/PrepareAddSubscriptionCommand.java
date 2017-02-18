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
		LOGGER.info("Initializing PrepareAddSubscriptionCommand command");
		prepareAddSubscriptionPage = resmanager.getProperty("addSubscriptionPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
			try {
				Magazine magazine = magazineServiceImpl.getMagazine(Integer.valueOf(request.getParameter("mag_id")));
				List<SubscriptionType> list = subscriptionTypeServiceImpl.getAllSubscriptionTypes();
				request.setAttribute("list", list);
				request.setAttribute("mag", magazine);
				request.setAttribute("user", request.getParameter("user"));
				resultPage = prepareAddSubscriptionPage;
			} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at PrepareAddSubscriptionCommand");
					resultPage = errorPage;
				} 
		return resultPage;
	}

}
