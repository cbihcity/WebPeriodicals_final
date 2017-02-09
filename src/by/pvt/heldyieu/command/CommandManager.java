package by.pvt.heldyieu.command;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.resources.ResourceManager;


public class CommandManager {
	private static final Logger LOGGER = Logger.getLogger(CommandManager.class);
	private HashMap<String, ServletCommand> commands;
	ResourceManager resmanager = new ResourceManager("mapping");
    //private static String errorPage;

    public CommandManager(){
        LOGGER.info("Initializing CommandManager");

        commands = new HashMap<>();

        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        //commands.put("/register", new RegisterCommand());
//        commands.put("/magazine", new MagazinePageCommand());
//        commands.put("/category", new CategoryPageCommand());
//        commands.put("/admin/dashboard", new AdminPageCommand());
//        commands.put("/subscribe", new SubscribePageCommand());
//
//        //admin categories
//        commands.put("/admin/categories", new CategoriesAdminPageCommand());
//        commands.put("/admin/categories/add", new AddCategoryAdminPageCommand());
//        commands.put("/admin/categories/delete", new DeleteCategoryAdminCommand());
//        commands.put("/admin/categories/update", new UpdateCategoryAdminCommand());
//        commands.put("/admin/categories/edit", new EditCategoryAdminPageCommand());
//
//        //admin publishers
//        commands.put("/admin/publishers", new PublishersAdminPageCommand());
//        commands.put("/admin/publishers/edit", new EditPublisherAdminPageCommand());
//        commands.put("/admin/publishers/add", new AddPublisherAdminPageCommand());
//        commands.put("/admin/publishers/delete", new DeletePublisherAdminCommand());
//        commands.put("/admin/publishers/update", new UpdatePublisherAdminCommand());
//
//        //admin users
//        commands.put("/admin/users", new UsersAdminPageCommand());
//
//        //admin magazines
//        commands.put("/admin/magazines", new MagazinesAdminPageCommand());
//        commands.put("/admin/magazines/add", new AddMagazineAdminPageCommand());

       // errorPage = resmanager.getProperty("errorPage");
    }

    /**
     * This method is used to get a command instance based on a request.
     *
     * @param request http request from servlet.
     * @return        A servlet command instance.
     */
    public ServletCommand getCommand(HttpServletRequest request) {
        String command = request.getParameter("command");;
        
        if(command == null) {
            return commands.get("/");
        }
        return commands.get(command);
    }
}
