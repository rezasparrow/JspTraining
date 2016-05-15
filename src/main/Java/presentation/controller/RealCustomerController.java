package presentation.controller;

import bean.RealCustomer;
import exception.NotFoundObjectException;
import logic.RealCustomerManipulator;
import logic.model.RealCustomerView;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;

/**
 * Created by Dotin School1 on 5/15/2016.
 */
public class RealCustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getServletConfig().getInitParameter("action");
        if("show".equalsIgnoreCase(action)){
            Integer id  = null;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            }catch (Exception e){
                id = null;
            }
            if(id != null){
                RealCustomerManipulator manipulator = new RealCustomerManipulator();
                try {
                    RealCustomer realCustomer = (RealCustomer) manipulator.findById(id);
                    request.setAttribute("realCustomer" , RealCustomerView.toView(realCustomer));
                } catch (NotFoundObjectException e) {

                }
            }
            request.getRequestDispatcher("/RealCustomer/show.jsp").forward(request, response);
        }
    }
}
