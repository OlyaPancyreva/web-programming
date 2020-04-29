import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

@WebServlet("/auth")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        HttpSession session = null;
        RequestDispatcher dispatcher = null;
            session = request.getSession();
            session.setAttribute("user", login);
            dispatcher = request.getRequestDispatcher("logout.jsp");

            try {
                /*   добавляем пользователя в базу данных   */
                ConToDb.createUser(login, password);
                /*   Устанавливаем куки   */
                response.addCookie(new Cookie("login", login));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
