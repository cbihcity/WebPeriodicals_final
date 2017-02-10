package by.pvt.heldyieu.command.actions;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.enums.CategoryType;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;

public class AddMagazineCommand implements ServletCommand {
	private static final Logger LOGGER = Logger.getLogger(AddMagazineCommand.class);
	private final String NAME = "name";
    private final String TYPE = "type";
    private final String PRICE = "price";
    
    private String sucessPage = resmanager.getProperty("sucessPage");
    private String errorPage = resmanager.getProperty("errorPage");
    private String resultPage = null;
    
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		Magazine magazine = new Magazine();
		
		magazine.setName(request.getParameter(NAME).trim());
		magazine.setType(CategoryType.values()[Integer.valueOf(request.getParameter(TYPE))-1]);
		magazine.setPrice(Double.valueOf(request.getParameter(PRICE).trim()));
		
		if (isValid(magazine)) {
			try {
				MagazineServiceImpl.getInstance().addMagazine(magazine);
				request.setAttribute("sucessmessage", "Журнал Добавлен!");
				resultPage = sucessPage;
			} catch (SQLException e) {
				LOGGER.error("SqlException at AddMagazineCommand");
	        	request.setAttribute("errormessage", "SqlException at AddMagazineCommand");
	        	resultPage =  errorPage;
			}
		} else {
			request.setAttribute("errormessage", "Please insert all fields");
        	resultPage =  errorPage;
		}
		
		return resultPage;
	}

	private boolean isValid(Magazine magazine) {
		if (magazine.getName()==null || magazine.getName().equals("")) {
			return false;
		}
		if (magazine.getType()==null) {
			return false;
		}
		if (magazine.getPrice()==0) {
			return false;
		}
		return true;
	}

}
