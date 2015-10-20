package ua.artcode.servlet;

import ua.artcode.model.AppDB;
import ua.artcode.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addUserServlet", urlPatterns = {"/add-user-servlet"})
public class AddUserServlet extends HttpServlet {

    public static final String USER_INFO_JSP = "WEB-INF/pages/user-info.jsp";
    private AppDB appDB;

    @Override
    public void init() throws ServletException {
        super.init();
        appDB = (AppDB) getServletContext().getAttribute("appDB");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        // validation

        User user = new User(name,phone,email);
        appDB.addUser(user);

        req.setAttribute("user", user);

        req.getRequestDispatcher(USER_INFO_JSP).forward(req,resp);


    }
}
