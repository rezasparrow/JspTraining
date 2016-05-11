<%@ page import="controller.RealCustomerController" %><%
    String id = request.getParameter("id");
    if(id != null){
        RealCustomerController.delete(Integer.parseInt(id));
    }
    response.sendRedirect("index.jsp");
%>