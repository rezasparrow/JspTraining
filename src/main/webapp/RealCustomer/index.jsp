<%@ page import="java.util.List" %>
<%@ page import="bean.RealCustomer" %>
<%@ page import="controller.RealCustomerController" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>مشتری حقیقی</title>
    <link href="/css/style.css" rel="stylesheet">
</head>
<body class="container">
<div class="header">

</div>
<div class="content">
    <a class="btn btn-sml" href="/RealCustomer/new.jsp">تعریف مشتری جدید</a>
    <form method="post" action="/RealCustomer/search">
        <table class="table">
            <thead>
            <tr>
                <th>
                    نام
                </th>
                <th>
                    نام خانوادگی
                </th>
                <th>
                    کد ملی
                </th>
                <th>
                    شماره مشتری
                </th>
            </tr>
            </thead>
            <tbody>
            <tr style="padding: 0px;">
                <td>
                    <input class="input-control" name="firstName">
                </td>
                <td>
                    <input class="input-control" name="lastName">
                </td>
                <td>
                    <input class="input-control" name="nationalCode">
                </td>
                <td>
                    <input class="input-control" name="customerNumber">
                </td>
                <td><input type="submit" class="btn btn-sml" value="search"></td>
            </tr>
            </tbody>

        </table>
    </form>
    <%

        List<RealCustomer> realCustomers = RealCustomerController.all();
        if (realCustomers.size() > 0) { %>

    <table class="table">
        <thead>
        <tr>
            <th>
                ردیف
            </th>
            <th>
                شماره مشتری
            </th>
            <th>
                نام
            </th>
            <th>
                نام خانوادگی
            </th>
            <th>
                نام پدر
            </th>
            <th>
                کد ملی
            </th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% int num = 0;
            for (RealCustomer realCustomer : realCustomers) {
                num++;
        %>
        <tr>

            <td><%=num%>
            </td>
            <td><%=realCustomer.getCustomerNumber()%>
            </td>
            <td><%=realCustomer.getFirstName()%>
            </td>
            <td><%=realCustomer.getLastName()%>
            </td>
            <td><%=realCustomer.getFatherName()%>
            </td>
            <td><%=realCustomer.getNationalCode()%>
            </td>
            <td><a href="/RealCustomer/edit.jsp?id=<%=realCustomer.getId()%>">edit</a></td>
            <td><a href="/RealCustomer/delete.jsp?id=<%=realCustomer.getId()%>">delete</a></td>
        </tr>
        <%}%>
        </tbody>
    </table>
    <%} else {%>

    <h2>هیچ داده‌ای موجود نمی‌باشد</h2>
    <%}%>
</div>
<div>


</div>
</body>
</html>
