package by.pvt.heldyieu.command.actions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.pvt.heldyieu.command.ServletCommand;

public class LangCommand implements ServletCommand {

	private final String BASENAME = "locale_";
    private final int ONE_WEEK = 60*60*24*7;
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter("lang");
        HttpSession session = request.getSession();
        session.setAttribute("locale", BASENAME + lang);
        Cookie c = new Cookie("locale", lang);
        c.setMaxAge(ONE_WEEK);
        response.addCookie(c);
        return null;
    }

}
