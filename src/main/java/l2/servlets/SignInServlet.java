package l2.servlets;

import l2.accounts.AccountService;
import l2.accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cole S' Offe on 24.03.2017.
 */
public class SignInServlet extends HttpServlet {
    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {this.accountService=accountService;}

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        UserProfile profile = accountService.getUserByLogin(login);

//        if (login == null || pass == null) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
        response.setContentType("text/html;charset=utf-8");

        if (profile != null && !profile.getPass().equals(pass)) {

            response.getWriter().println("Authorized: " + login);
            response.setStatus(HttpServletResponse.SC_OK);


        } else {
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        }
    }



}
