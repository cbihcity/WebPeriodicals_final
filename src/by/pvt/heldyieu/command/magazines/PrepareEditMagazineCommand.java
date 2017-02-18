package by.pvt.heldyieu.command.magazines;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.enums.CategoryType;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;

public class PrepareEditMagazineCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(PrepareEditMagazineCommand.class);

	private MagazineServiceImpl magazineServiceImpl;
    private String errorPage;
    private String editMagPage;
    private String resultPage;
	
	public PrepareEditMagazineCommand() {
		LOGGER.info("Initializing PrepareEditMagazineCommand command");
		editMagPage = resmanager.getProperty("editMagPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
			try {
				Magazine magazine = magazineServiceImpl.getMagazine(Integer.valueOf(request.getParameter("mag_id")));
				CategoryType[] listOfCategories = CategoryType.values();
				request.setAttribute("list", listOfCategories);
				request.setAttribute("mag", magazine);
				resultPage = editMagPage;
			} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at PrepareEditMagazineCommand");
					resultPage = errorPage;
				} 
		return resultPage;
	}
}
