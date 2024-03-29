package by.pvt.heldyieu.servlet;

import javax.servlet.http.HttpServlet;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	public void init()
	 {
	     String prefix =  getServletContext().getRealPath("/");
	     String file = getInitParameter("log4j-init-file");
	     // if the log4j-init-file context parameter is not set, then no point in trying
	     if(file != null){
	      PropertyConfigurator.configure(prefix+file);
	      System.out.println("Log4J Logging started: " + prefix+file);
	     }
	 }
}