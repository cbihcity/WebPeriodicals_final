package by.pvt.heldyieu.command.magazines;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;

public class DeleteMagazineCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(DeleteMagazineCommand.class);

	private MagazineServiceImpl magazineServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage;
	
	public DeleteMagazineCommand() {
		LOGGER.info("Initializing DeleteMagazineCommand command");
		sucessPage = resmanager.getProperty("sucessPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
		
			
				boolean result = false;
				try {
					result = magazineServiceImpl.deleteMagazine(Integer.valueOf(request.getParameter("mag_id")));
					if (result) {
						request.setAttribute("sucessmessage", "Издание успешно удалено!");
						resultPage =  sucessPage;
					} 
				 else {
						request.setAttribute("errormessage",
								"SqlException at DeleteMagazineCommand");
						resultPage = errorPage;
					}
				} catch (NumberFormatException e) {
					request.setAttribute("errormessage",
							"NumberFormatException at DeleteMagazineCommand");
					resultPage = errorPage;
				} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at DeleteMagazineCommand");
					resultPage = errorPage;
				}
		return resultPage;
	}
}
