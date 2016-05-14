package presentation.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoanTypeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = getServletConfig().getInitParameter("action");
        if ("new".equalsIgnoreCase(action)) {
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }
    }
}
