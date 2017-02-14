package by.pvt.heldyieu.command.actions;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;

public class DeleteMagazineCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(DeleteMagazineCommand.class);

	private static MagazineServiceImpl magazineServiceImpl = null;
    private String errorPage;
    private String sucessPage;
    private String resultPage = null;
	
	public DeleteMagazineCommand() {
		LOGGER.info("Initializing ShowAllMagazines commans");
		sucessPage = resmanager.getProperty("sucessPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
		
			try {
				boolean result = magazineServiceImpl.deleteMagazine(Integer.valueOf(request.getParameter("mag_id")));
				if (result) {
					request.setAttribute("sucessmessage", "Журнал успешно удален!");
					resultPage =  sucessPage;
				} else {
					LOGGER.error("SqlException at DeleteMagazineCommand");
					request.setAttribute("errormessage",
							"SqlException at DeleteMagazineCommand");
					resultPage = errorPage;
				}
			} catch (SQLException e) {
				LOGGER.error("SqlException at DeleteMagazineCommand");
				request.setAttribute("errormessage",
						"SqlException at DeleteMagazineCommand");
				resultPage = errorPage;
			}
		return resultPage;
	}

}