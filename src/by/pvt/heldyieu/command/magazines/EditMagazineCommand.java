package by.pvt.heldyieu.command.magazines;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.enums.CategoryType;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;

public class EditMagazineCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(EditMagazineCommand.class);
	private static MagazineServiceImpl magazineServiceImpl = null;
    private String errorPage;
    private String sucessPage;
    private String resultPage = null;
	
	public EditMagazineCommand() {
		LOGGER.info("Initializing EditMagazineCommand command");
		sucessPage = resmanager.getProperty("sucessPage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
		if (request.getParameter("name") != ""
				&& request.getParameter("type") != ""
				&& request.getParameter("price") != "") {
			try {
				Magazine mag = new Magazine();
				mag.setId(Integer.valueOf(request.getParameter("mag_id")));
				mag.setName(request.getParameter("name"));
				mag.setType(CategoryType.valueOf(request.getParameter("type")));
				mag.setPrice(Double.valueOf(request.getParameter("price")));
				magazineServiceImpl.updateMagazine(mag);
					request.setAttribute("sucessmessage", "Издание успешно изменено!");
					resultPage =  sucessPage;
			} catch (SQLException e) {
					request.setAttribute("errormessage",
							"SqlException at EditMagazineCommand");
					resultPage = errorPage;
				}
		} else {
			request.setAttribute("errormessage",
					"Please insert all fields");
			resultPage = errorPage;
		}
		return resultPage;
	}
}
