package by.pvt.heldyieu.command.actions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.pvt.heldyieu.command.ServletCommand;

public class LogoutCommand implements ServletCommand {

    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        
        session.removeAttribute("user");
        Cookie c = new Cookie("id","");
        c.setMaxAge(0);
        response.addCookie(c);
        return null;
    }

}
