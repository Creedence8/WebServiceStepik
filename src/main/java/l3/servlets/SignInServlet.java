package l3.servlets;

import l3.dataSet.UsersDataSet;
import l3.dbService.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cole S' Offe on 24.03.2017.
 */
public class SignInServlet extends HttpServlet {
    private final DBService accountService;

    public SignInServlet(DBService accountService) {this.accountService=accountService;}

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        UsersDataSet profile = null;
        try {
            profile = accountService.getUser(login);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        if (login == null || pass == null) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
        response.setContentType("text/html;charset=utf-8");

        if (profile != null && profile.getPassword().equals(pass)) {

            response.getWriter().println("Authorized: " + login);
            response.setStatus(HttpServletResponse.SC_OK);


        } else {
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        }
    }



}
