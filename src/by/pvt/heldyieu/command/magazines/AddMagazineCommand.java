package by.pvt.heldyieu.command.magazines;

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
		if (request.getParameter(NAME) != ""
				&& request.getParameter(TYPE) != ""
				&& request.getParameter(PRICE) != "") {
			magazine.setName(request.getParameter(NAME).trim());
			magazine.setType(CategoryType.valueOf(request.getParameter(TYPE)));
			magazine.setPrice(Double
					.valueOf(request.getParameter(PRICE).trim()));
			try {
				MagazineServiceImpl.getInstance().addMagazine(magazine);
				request.setAttribute("sucessmessage", "Издание добавлено!");
				resultPage = sucessPage;
			} catch (SQLException e) {
				LOGGER.error("SqlException at AddMagazineCommand");
				request.setAttribute("errormessage",
						"SqlException at AddMagazineCommand");
				resultPage = errorPage;
			}
		} else {
			request.setAttribute("errormessage", "Please insert all fields");
			resultPage = errorPage;
		}
		return resultPage;
	}
}
