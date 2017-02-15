package by.pvt.heldyieu.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.pvt.heldyieu.resources.ResourceManager;

public interface ServletCommand {
	/**
     * This method is called to execute a command.
     *
     * @param request  Http request from servlet.
     * @param response Http response from servlet.
     * @return         A string that represents a view to forward to.
     */
	ResourceManager resmanager = new ResourceManager("mappingPages");
    String execute(HttpServletRequest request, HttpServletResponse response);
}
