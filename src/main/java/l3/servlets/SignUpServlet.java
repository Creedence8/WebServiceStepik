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
public class SignUpServlet extends HttpServlet {
    private final DBService dbService;

    public SignUpServlet(DBService accountService) {this.dbService=accountService;}

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

//        if (login == null || pass == null) {
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
//        UsersDataSet profile = accountService.getUserByLogin(login);
//        if (profile == null) {
//            accountService.addNewUser(new UsersDataSet(login));
//
//            response.setContentType("text/html;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
        try {
            dbService.addUser(login, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
    }
}
