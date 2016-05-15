<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="logic.model.RealCustomerView" %>
<%@ page import="logic.RealCustomerManipulator" %>
<%@ page import="util.MessageBundle" %>

<%
    RealCustomerView realCustomer = new RealCustomerView();

    String method  = request.getMethod();
    if (method.equalsIgnoreCase("post")){

        request.setCharacterEncoding("UTF-8");
        realCustomer.firstName = request.getParameter("firstName") ;
        realCustomer.lastName = request.getParameter("lastName");
        realCustomer.fatherName = request.getParameter("fatherName");
        realCustomer.nationalCode = request.getParameter("nationalCode");
        realCustomer.birthday = request.getParameter("birthday");
        RealCustomerManipulator realCustomerController = new RealCustomerManipulator();
        MessageBundle errors = realCustomerController.save(realCustomer);
        if (errors.isValid()) {
            response.sendRedirect("/RealCustomer");
        }
    }

    System.out.println(realCustomer);
%>


<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>تعریف مشتری حقوقی</title>
    <meta charset="utf-8">
</head>
<body style="background:#cccccc;">
<div style="direction: rtl" class="container">
    <div class="header">
        <a href="/index.jsp" class="btn btn-sml">خانه</a>
    </div>
    <form method="post" action="/RealCustomer/new.jsp"   class="form">
        <div class="form-elm">
            <label for="firstName" class="label-control"> نام</label>
            <div class="sml-col"><input type="text" value="<%=realCustomer.getFirstName()%>" name="firstName" id="firstName"
                                        class="input-control">
            </div>
        </div>
        <div class="form-elm">
            <label for="lastName" class="label-control"> نام خانوادگی</label>
            <div class="sml-col">
                <input type="text" value="<%=realCustomer.getLastName()%>" name="lastName" id="lastName"
                       class="input-control">
            </div>
        </div>
        <div class="form-elm">
            <label for="fatherName" class="label-control"> نام پدر</label>
            <div class="sml-col"><input type="text" value="<%=realCustomer.getFatherName()%>" name="fatherName"
                                        id="fatherName" class="input-control">
            </div>
        </div>
        <div class="form-elm">
            <label for="nationalCode" class="label-control"> کد ملی</label>
            <div class="sml-col"><input type="text" value="<%=realCustomer.getNationalCode()%>" name="nationalCode"
                                        id="nationalCode"
                                        class="input-control"></div>
        </div>
        <div class="form-elm">
            <label for="birthday" class="label-control"> تاریخ تولد</label>
            <div class="sml-col"><input type="date" value="<%=realCustomer.getBirthday()%>" name="birthday" id="birthday"
                                        class="input-control"></div>
        </div>
        <div>
            <input type="submit" value="ذخیره" class="btn btn-sml">
        </div>
    </form>
    <div class="form"><a href="/RealCustomer" class="btn btn-sml">بازگشت</a></div>
</div>

</body>
</html>