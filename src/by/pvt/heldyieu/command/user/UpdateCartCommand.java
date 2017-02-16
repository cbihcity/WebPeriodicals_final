package by.pvt.heldyieu.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.pvt.heldyieu.command.ServletCommand;

public class UpdateCartCommand implements ServletCommand {
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		if (request.getParameter("cart")!="") {
			request.setAttribute("cart", Integer.valueOf(request.getParameter("cart"))+1);
		} else {
		request.setAttribute("cart", 1);
		}
		return null;
	}

}
