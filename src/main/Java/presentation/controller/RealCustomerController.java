package presentation.controller;

import bean.GrantCondition;
import bean.LoanFile;
import bean.RealCustomer;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages_sk;
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
import java.util.List;
import java.util.Set;

/**
 * Created by Dotin School1 on 5/15/2016.
 */
public class RealCustomerController extends HttpServlet {

    private RealCustomerView getObjectFromRequest(HttpServletRequest request){
        RealCustomerView realCustomerView = new RealCustomerView();
        realCustomerView.firstName = request.getParameter("firstName");
        realCustomerView.lastName = request.getParameter("lastName");
        realCustomerView.nationalCode = request.getParameter("nationalCode");
        String customerNumber = request.getParameter("customerNumber");
        if (customerNumber != null && !"".equals(customerNumber.trim())) {
            realCustomerView.customerNumber = Integer.parseInt(customerNumber);
        }
        return realCustomerView;
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RealCustomerManipulator realCustomerManipulator = new RealCustomerManipulator();
        RealCustomerView realCustomerView = getObjectFromRequest(request);
        List<RealCustomer> realCustomers = realCustomerManipulator.all(realCustomerView);

        request.setAttribute("realCustomer", realCustomerView);
        request.setAttribute("realCustomers", realCustomers);
        request.getRequestDispatcher("/RealCustomer/index.jsp").forward(request, response);
    }

    private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = null;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            id = null;
        }
        if (id != null) {
            RealCustomerManipulator manipulator = new RealCustomerManipulator();
            try {
                RealCustomer realCustomer = (RealCustomer) manipulator.findById(id);
                Set<LoanFile> loanFiles = realCustomer.getLoanFiles();
                request.setAttribute("realCustomer", RealCustomerView.toView(realCustomer));
            } catch (NotFoundObjectException e) {

            }
        }
        request.getRequestDispatcher("/RealCustomer/show.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        index(request , response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getServletConfig().getInitParameter("action");
        if ("show".equalsIgnoreCase(action)) {
            show(request, response);
        } else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = getServletConfig().getInitParameter("action");
        if ("search".equalsIgnoreCase(action)){
            search(request , response);
        }
    }
}
