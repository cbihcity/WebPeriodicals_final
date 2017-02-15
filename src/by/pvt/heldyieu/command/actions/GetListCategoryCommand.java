package by.pvt.heldyieu.command.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.enums.CategoryType;

public class GetListCategoryCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(GetListCategoryCommand.class);

    private static String addMagazinePage;
    private static String errorPage;
    private static String resultPage = null;
	
	public GetListCategoryCommand() {
		LOGGER.info("Initializing GetListCategoryCommand commans");
		addMagazinePage = resmanager.getProperty("addMagazinePage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
			CategoryType[] listOfCategories = CategoryType.values();
			if (listOfCategories!=null) {
				request.setAttribute("list", listOfCategories);
				resultPage =  addMagazinePage;
			} else {
				request.setAttribute("errormessage", "The list of CategoryTypes magazines is empty");
	        	resultPage =  errorPage;
			}
		return resultPage;
	}

}
