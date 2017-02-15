package by.pvt.heldyieu.command.actions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;

public class ShowAllMagazinesCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(ShowAllMagazinesCommand.class);

	private static MagazineServiceImpl magazineServiceImpl;

    private static String magazinePage;
    private static String errorPage;
    private static String resultPage = null;
    List<Magazine> listOfMagazines = new ArrayList<Magazine>();
	
	public ShowAllMagazinesCommand() {
		LOGGER.info("Initializing ShowAllMagazines commans");
		magazinePage = resmanager.getProperty("magazinePage");
		errorPage = resmanager.getProperty("errorPage");
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
		try {
			List<Magazine> listOfMagazines = magazineServiceImpl.getAllMagazines();
			if (listOfMagazines!=null) {
				request.setAttribute("list", listOfMagazines);
				resultPage =  magazinePage;
			}
		} catch (SQLException e) {
			LOGGER.error("SqlException at ShowAllMagazinesCommand");
        	request.setAttribute("errormessage", "SqlException at ShowAllMagazinesCommand");
        	resultPage =  errorPage;
		}
		return resultPage;
	}

}
