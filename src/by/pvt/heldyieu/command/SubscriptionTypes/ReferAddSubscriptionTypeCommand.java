package by.pvt.heldyieu.command.SubscriptionTypes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.pvt.heldyieu.command.ServletCommand;

public class ReferAddSubscriptionTypeCommand implements ServletCommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		return resmanager.getProperty("AddSubscriptionTypePage");
	}

}
