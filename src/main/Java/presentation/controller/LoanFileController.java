package presentation.controller;

import bean.LoanFile;
import bean.LoanType;
import bean.RealCustomer;
import exception.NotFoundObjectException;
import logic.LoanFileManipulator;
import logic.LoanTypeManipulator;
import logic.RealCustomerManipulator;
import logic.model.LoanFileView;
import logic.model.LoanTypeView;
import logic.model.RealCustomerView;
import org.hibernate.type.LongType;
import util.MessageBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dotin School1 on 5/16/2016.
 */
public class LoanFileController extends HttpServlet {

    private LoanFileView getLoanFileFromRequest(HttpServletRequest request) {
        Integer customerId = Integer.parseInt(request.getParameter("customerId"));
        Integer loanTypeId = Integer.parseInt(request.getParameter("loanTypeId"));

        RealCustomerView realCustomer = new RealCustomerView();
        realCustomer.setId(customerId);

        LoanTypeView loanType = new LoanTypeView();
        loanType.setId(loanTypeId);

        LoanFileView loanFile = new LoanFileView();
        loanFile.setLoanType(loanType);
        loanFile.setRealCustomer(realCustomer);

        return loanFile;
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = Integer.parseInt(request.getParameter("customerId"));
        RealCustomerManipulator realCustomerManipulator = new RealCustomerManipulator();
        try {
            RealCustomer realCustomer = realCustomerManipulator.findById(customerId);
            RealCustomerView realCustomerView = new RealCustomerView();
            LoanTypeManipulator loanTypeManipulator = new LoanTypeManipulator();
            LoanTypeView loanTypeView = new LoanTypeView();
            List<LoanType> loanTypeEntities = loanTypeManipulator.all();
            List<LoanTypeView> loanTypeViews = loanTypeEntities.stream().map(LoanTypeView::toView).collect(Collectors.toList());
            request.setAttribute("loanTypes", loanTypeViews);
            request.setAttribute("realCustomer", realCustomerView.toView(realCustomer));
            request.getRequestDispatcher("/LoanFile/new.jsp").forward(request, response);
        } catch (NotFoundObjectException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = getServletConfig().getInitParameter("action");
        if ("new".equalsIgnoreCase(action)) {
            add(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = getServletConfig().getInitParameter("action");

        if ("create".equalsIgnoreCase(action)) {
            create(request, response);
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LoanFileView loanFile = getLoanFileFromRequest(request);
        LoanFileManipulator loanFileManipulator = new LoanFileManipulator();
        MessageBundle messages = loanFileManipulator.save(loanFile);
        if (messages.isValid()) {
            response.sendRedirect("/RealCustomer/show?id=" + loanFile.getRealCustomer().getId());
        } else {
            add(request, response);
        }
    }
}
