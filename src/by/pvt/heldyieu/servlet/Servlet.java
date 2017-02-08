package by.pvt.heldyieu.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
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
@WebServlet("/servlet")
public class Servlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(Servlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
		LOGGER.info("Initializing Servlet");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String page = null;
		LOGGER.info("Processing " + request.getMethod() + " request");
	    // определение команды, пришедшей из JSP
		CommandManager client = new CommandManager();
		ServletCommand command = client.getCommand(request); 
	    /*
	     * вызов реализованного метода execute() и передача параметров
	     * классу-обработчику конкретной команды
	     */
	    page = command.execute(request);
	    // метод возвращает страницу ответа
	    // page = null; // поэксперементировать!
	    
	      request.getRequestDispatcher(page).forward(request, response);
	    
	}
}
