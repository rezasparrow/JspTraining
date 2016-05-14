<%@ page import="logic.RealCustomerManipulator" %>
<%
    String id = request.getParameter("id");
    if(id != null){
        RealCustomerManipulator logic =  new RealCustomerManipulator();
        controller.delete(Integer.parseInt(id));
    }
    response.sendRedirect("index.jsp");
%>