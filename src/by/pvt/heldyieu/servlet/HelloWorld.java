package by.pvt.heldyieu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.entity.Subscription;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;
import by.pvt.heldyieu.service.subscription.SubscriptionServiceImpl;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;
import by.pvt.heldyieu.service.user.UserServiceImpl;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl service = UserServiceImpl.getInstance();
		SubscriptionTypeServiceImpl subscriptionTypeService = SubscriptionTypeServiceImpl.getInstance();
		MagazineServiceImpl magazineService = MagazineServiceImpl.getInstance();
		SubscriptionServiceImpl subscriptionService = SubscriptionServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
	    out.print("Hello World"+"\n");
	    try {
			for (User user : service.getAllUsers()) {
				out.println("<br />"+user.toString());
			}
			for (SubscriptionType subscriptionType : subscriptionTypeService.getAllSubscriptionTypes()) {
				out.println("<br />"+subscriptionType.toString());
			}
			for (Magazine magazine : magazineService.getAllMagazines()) {
				out.println("<br />"+magazine.toString());
			}
			for (Subscription subscription : subscriptionService.getAllSubscriptions()) {
				out.println("<br />"+subscription.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
