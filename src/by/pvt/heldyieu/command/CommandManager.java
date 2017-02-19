package by.pvt.heldyieu.command;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.command.Subscription.AddSubscriptionCommand;
import by.pvt.heldyieu.command.Subscription.CountTotalPriceCommand;
import by.pvt.heldyieu.command.Subscription.DeleteSubscriptionsCommand;
import by.pvt.heldyieu.command.Subscription.PrepareAddSubscriptionCommand;
import by.pvt.heldyieu.command.SubscriptionTypes.AddSubscriptionTypeCommand;
import by.pvt.heldyieu.command.SubscriptionTypes.DeleteSubscriptionTypesCommand;
import by.pvt.heldyieu.command.SubscriptionTypes.EditSubscriptionTypeCommand;
import by.pvt.heldyieu.command.SubscriptionTypes.PrepareEditSubscriptionTypesCommand;
import by.pvt.heldyieu.command.SubscriptionTypes.ReferAddSubscriptionTypeCommand;
import by.pvt.heldyieu.command.SubscriptionTypes.ShowSubscriptionTypesCommand;
import by.pvt.heldyieu.command.actions.IndexCommand;
import by.pvt.heldyieu.command.actions.LangCommand;
import by.pvt.heldyieu.command.actions.LoginCommand;
import by.pvt.heldyieu.command.actions.LogoutCommand;
import by.pvt.heldyieu.command.magazines.AddMagazineCommand;
import by.pvt.heldyieu.command.magazines.DeleteMagazineCommand;
import by.pvt.heldyieu.command.magazines.EditMagazineCommand;
import by.pvt.heldyieu.command.magazines.PrepareEditMagazineCommand;
import by.pvt.heldyieu.command.magazines.ShowAllMagazinesCommand;
import by.pvt.heldyieu.command.user.AddUserCommand;
import by.pvt.heldyieu.command.user.DeleteUserCommand;
import by.pvt.heldyieu.command.user.EditUserCommand;
import by.pvt.heldyieu.command.user.GetListCategoryCommand;
import by.pvt.heldyieu.command.user.GetUsersListCommand;
import by.pvt.heldyieu.command.user.PrepareEditUserCommand;
import by.pvt.heldyieu.command.user.ShowUserSubscriptionsCommand;
import by.pvt.heldyieu.interfaces.Constants;


public class CommandManager implements Constants {
	private static final Logger LOGGER = Logger.getLogger(CommandManager.class);
	private static CommandManager instance;
	private HashMap<String, ServletCommand> commands;

    public CommandManager(){
        LOGGER.info(INITIALIZING_COMMANDMANAGER);
        commands = new HashMap<>();
        commands.put(INDEX, new IndexCommand());
        commands.put(LOGIN, new LoginCommand());
        commands.put(LOGOUT, new LogoutCommand());
        commands.put(MAGAZINES, new ShowAllMagazinesCommand());
        commands.put(ADD_MAG, new AddMagazineCommand());
        commands.put(REGISTER, new AddUserCommand());
        commands.put(DEL_MAG, new DeleteMagazineCommand());
        commands.put(EDIT_MAG, new EditMagazineCommand());
        commands.put(PREPARE_EDIT_MAG, new PrepareEditMagazineCommand());
        commands.put(GET_LISTS_CATEGORY, new GetListCategoryCommand());
        commands.put(USERS, new GetUsersListCommand());
        commands.put(DEL_USER, new DeleteUserCommand());
        commands.put(PREPARE_EDIT_USER, new PrepareEditUserCommand());
        commands.put(EDIT_USER, new EditUserCommand());
        commands.put(SUBSCRIPTION_TYPES, new ShowSubscriptionTypesCommand());
        commands.put(DEL_SUBSCRIPTION_TYPES, new DeleteSubscriptionTypesCommand());
        commands.put(PREPARE_EDIT_SUBSCRIPTION_TYPES, new PrepareEditSubscriptionTypesCommand());
        commands.put(EDIT_SUBSCRIPTION_TYPE, new EditSubscriptionTypeCommand());
        commands.put(REFER_ADD_SUBSCRIPTION_TYPE, new ReferAddSubscriptionTypeCommand());
        commands.put(ADD_SUBSCRIPTION_TYPE, new AddSubscriptionTypeCommand());
        commands.put(PREPARE_ADD_SUB, new PrepareAddSubscriptionCommand());
        commands.put(ADD_SUB, new AddSubscriptionCommand());
        commands.put(COUNT_TOTAL_PRICE, new CountTotalPriceCommand());
        commands.put(SHOW_USER_SUBSCRIPTIONS, new ShowUserSubscriptionsCommand());
        commands.put(DEL_SUB, new DeleteSubscriptionsCommand());
        commands.put(LANG, new LangCommand());
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
        String command = request.getParameter(COMMAND);;
        
        if(command == null) {
            return commands.get("/");
        }
        return commands.get(command);
    }
}
