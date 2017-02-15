package by.pvt.heldyieu.command;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.command.actions.AddMagazineCommand;
import by.pvt.heldyieu.command.actions.AddUserCommand;
import by.pvt.heldyieu.command.actions.DeleteMagazineCommand;
import by.pvt.heldyieu.command.actions.DeleteUserCommand;
import by.pvt.heldyieu.command.actions.EditMagazineCommand;
import by.pvt.heldyieu.command.actions.EditUserCommand;
import by.pvt.heldyieu.command.actions.GetListCategoryCommand;
import by.pvt.heldyieu.command.actions.GetUsersListCommand;
import by.pvt.heldyieu.command.actions.IndexCommand;
import by.pvt.heldyieu.command.actions.LoginCommand;
import by.pvt.heldyieu.command.actions.LogoutCommand;
import by.pvt.heldyieu.command.actions.PrepareEditMagazineCommand;
import by.pvt.heldyieu.command.actions.PrepareEditUserCommand;
import by.pvt.heldyieu.command.actions.ShowAllMagazinesCommand;


public class CommandManager {
	private static final Logger LOGGER = Logger.getLogger(CommandManager.class);
	private static CommandManager instance;
	private HashMap<String, ServletCommand> commands;

    public CommandManager(){
        LOGGER.info("Initializing CommandManager");
        commands = new HashMap<>();
        commands.put("index", new IndexCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("magazines", new ShowAllMagazinesCommand());
        commands.put("addMag", new AddMagazineCommand());
        commands.put("register", new AddUserCommand());
        commands.put("delMag", new DeleteMagazineCommand());
        commands.put("editMag", new EditMagazineCommand());
        commands.put("prepareEditMag", new PrepareEditMagazineCommand());
        commands.put("getListsCategory", new GetListCategoryCommand());
        commands.put("users", new GetUsersListCommand());
        commands.put("delUser", new DeleteUserCommand());
        commands.put("prepareEditUser", new PrepareEditUserCommand());
        commands.put("editUser", new EditUserCommand());
    }
    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
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
