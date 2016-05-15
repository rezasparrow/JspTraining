package presentation.controller;

import bean.RealCustomer;
import logic.LoanTypeManipulator;
import logic.RealCustomerManipulator;
import logic.model.GrantConditionView;
import logic.model.LoanTypeView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoanTypeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = getServletConfig().getInitParameter("action");
        if ("new".equalsIgnoreCase(action)) {
            String name = request.getParameter("name");
            Float rate = Float.parseFloat(request.getParameter("rate"));
            List<GrantConditionView> grantConditionViews = new ArrayList<>();
            int numGrandCondition = 0;
            while (true) {
                Map<String, String[]> params = request.getParameterMap();
                String nameCondition = request.getParameter("grandCondition[name][" + numGrandCondition + "]");
                String minDurationCondition = request.getParameter("grandCondition[minDuration][" + numGrandCondition + "]");
                String maxDurationCondition = request.getParameter("grandCondition[maxDuration][" + numGrandCondition + "]");
                String minAmountCondition = request.getParameter("grandCondition[minAmount][" + numGrandCondition + "]");
                String maxAmountCondition = request.getParameter("grandCondition[maxAmount][" + numGrandCondition + "]");
                GrantConditionView grantConditionView =
                        new GrantConditionView(nameCondition, maxAmountCondition, minAmountCondition, maxDurationCondition, minDurationCondition);
                if (grantConditionView.isValid()) {
                    grantConditionViews.add(grantConditionView);
                } else {
                    break;
                }
                numGrandCondition++;
            }
            LoanTypeView loanType = new LoanTypeView(name, rate);
            loanType.setGrantConditions(grantConditionViews);
            if (loanType.isValid()) {
                LoanTypeManipulator manipulator = new LoanTypeManipulator();

                manipulator.save(loanType);
                response.sendRedirect("/LoanType");
            } else {
                request.getRequestDispatcher("/LoanType/new.js").forward(request, response);
            }
        }
    }
}
