<%@ page import="controller.RealCustomerController" %>
<%@ page import="presentation.RealCustomerView" %>
<%@ page import="util.MessageBundle" %>

<%
    RealCustomerView realCustomerView = new RealCustomerView();
    realCustomerView.firstName = request.getParameter("firstName");
    realCustomerView.lastName = request.getParameter("lastName");
    realCustomerView.fatherName = request.getParameter("fatherName");
    realCustomerView.nationalCode = request.getParameter("nationalCode");
    realCustomerView.birthday = request.getParameter("birthday");
    MessageBundle errors = RealCustomerController.save(realCustomerView);
    if (errors.isValid()) {
        response.sendRedirect("/RealCustomer");
    } else {
        request.setAttribute("realCustomer" , realCustomerView);
        request.setAttribute("error" , errors);
        request.getRequestDispatcher("/RealCustomer/new.jsp").forward(request, response);
    }
%>