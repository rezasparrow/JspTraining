<%@ page import="controller.RealCustomerController" %>
<%
    String id = request.getParameter("id");
    if(id != null){
        RealCustomerController controller =  new RealCustomerController();
        controller.delete(Integer.parseInt(id));
    }
    response.sendRedirect("index.jsp");
%>