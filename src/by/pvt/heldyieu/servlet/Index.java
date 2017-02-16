package by.pvt.heldyieu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.CommandManager;
import by.pvt.heldyieu.command.ServletCommand;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(urlPatterns ={"/Index", 
		"/act", 
		"/showMagazines", 
		"/editMagazine", 
		"/usersList",
		"/editSubscriptionType",
		"/subscription_types"})
public class Index extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(Index.class);
	private static final long serialVersionUID = 1L;
	private CommandManager client = CommandManager.getInstance();
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
	}
	@Override
	public void init() throws ServletException {
		super.init();
		LOGGER.info("Initializing Servlet");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		LOGGER.info("Processing " + request.getMethod() + " request");
		// определение команды, пришедшей из JSP
		ServletCommand command = client.getCommand(request);
		/*
		 * вызов реализованного метода execute() и передача параметров
		 * классу-обработчику конкретной команды
		 */
		page = command.execute(request, response);
		if(page == null) {
            page = "/index";
        }
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
	}
}
