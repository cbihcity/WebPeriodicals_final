package by.pvt.heldyieu.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.enums.CategoryType;

public class GetListCategoryCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(GetListCategoryCommand.class);
    private String addMagazinePage;
    private String errorPage;
    private String resultPage;
    
	public GetListCategoryCommand() {
		LOGGER.info("Initializing GetListCategoryCommand command");
		addMagazinePage = resmanager.getProperty("addMagazinePage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		CategoryType[] listOfCategories = CategoryType.values();
			if (listOfCategories.length!=0) {
				request.setAttribute("list", listOfCategories);
				resultPage =  addMagazinePage;
			} else {
				request.setAttribute("errormessage", "The list of CategoryTypes magazines is empty");
	        	resultPage =  errorPage;
			}
		return resultPage;
	}

}
