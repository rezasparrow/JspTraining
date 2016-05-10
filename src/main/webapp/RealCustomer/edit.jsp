<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="bean.RealCustomer" %>
<%@ page import="controller.RealCustomerController" %>
<%@ page import="presentation.RealCustomerView" %>

<%
    request.setCharacterEncoding("UTF-8");
    String id =request.getParameter("id");
    RealCustomerView realCustomer = RealCustomerController.findById(Integer.parseInt(id));

    System.out.println(realCustomer);
%>


<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>ویرایش مشتری حقوقی</title></head>
<meta charset="utf-8">
<body style="background:#cccccc;">
<div style="direction: rtl" class="container">
    <div class="header">
        <a href="/index.html" class="btn btn-sml">خانه</a>
    </div>
    <form method="post" action="/RealCustomer/edit.jsp" class="form">
        <div class="form-elm">
            <label for="firstName" class="label-control"> نام</label>
            <div class="sml-col"><input type="text" value="<%=realCustomer.firstName%>" name="firstName" id="firstName"
                                        class="input-control">
            </div>
        </div>
        <div class="form-elm">
            <label for="lastName" class="label-control"> نام خانوادگی</label>
            <div class="sml-col">
                <input type="text" value="<%=realCustomer.lastName%>" name="lastName" id="lastName"
                       class="input-control">
            </div>
        </div>
        <div class="form-elm">
            <label for="fatherName" class="label-control"> نام پدر</label>
            <div class="sml-col"><input type="text" value="<%=realCustomer.fatherName%>" name="fatherName"
                                        id="fatherName" class="input-control">
            </div>
        </div>
        <div class="form-elm">
            <label for="nationalCode" class="label-control"> کد ملی</label>
            <div class="sml-col"><input type="text" value="<%=realCustomer.nationalCode%>" name="nationalCode"
                                        id="nationalCode"
                                        class="input-control"></div>
        </div>
        <div class="form-elm">
            <label for="birthday" class="label-control"> تاریخ تولد</label>
            <div class="sml-col"><input type="date" value="<%=realCustomer.birthday%>" name="birthday" id="birthday"
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