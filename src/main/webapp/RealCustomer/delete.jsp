<%@ page import="logic.RealCustomerManipulator" %>
<%
    String id = request.getParameter("id");
    if(id != null){
        RealCustomerManipulator controller =  new RealCustomerManipulator();
        controller.delete(Integer.parseInt(id));
    }
    response.sendRedirect("index.jsp");
%>