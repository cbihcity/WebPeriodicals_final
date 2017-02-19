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
		LOGGER.info(INITIALIZING_DELETE_MAGAZINE_COMMAND);
		sucessPage = resmanager.getProperty(SUCESS_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
				boolean result = false;
				try {
					result = magazineServiceImpl.deleteMagazine(Integer.valueOf(request.getParameter(MAG_ID)));
					if (result) {
						request.setAttribute(SUCCESS_MESSAGE, MAGAZINE_DELETE_SUCCESS);
						resultPage =  sucessPage;
					} 
				 else {
						request.setAttribute(ERROR_MESSAGE,
								SQLEXCEPTION_AT_DELETE_MAGAZINE_COMMAND);
						resultPage = errorPage;
					}
				} catch (NumberFormatException e) {
					request.setAttribute(ERROR_MESSAGE,
							NUMBER_FORMAT_EXCEPTION_AT_DELETE_MAGAZINE_COMMAND);
					resultPage = errorPage;
				} catch (SQLException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_DELETE_MAGAZINE_COMMAND);
					resultPage = errorPage;
				}
		return resultPage;
	}
}
