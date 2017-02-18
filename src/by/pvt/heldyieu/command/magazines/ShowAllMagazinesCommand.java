package by.pvt.heldyieu.command.magazines;

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

	private MagazineServiceImpl magazineServiceImpl;
    private String magazinePage;
    private String errorPage;
    private String resultPage;
    List<Magazine> listOfMagazines = new ArrayList<Magazine>();
	
	public ShowAllMagazinesCommand() {
		LOGGER.info("Initializing ShowAllMagazines command");
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
