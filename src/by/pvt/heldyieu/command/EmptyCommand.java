package by.pvt.heldyieu.command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ServletCommand {

	@Override
	public String execute(HttpServletRequest request) {
		 String page = resmanager.getProperty("mainPage");
		 return page;
	}

}
