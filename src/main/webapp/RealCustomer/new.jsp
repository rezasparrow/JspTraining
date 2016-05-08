<%@ page import="presentation.RealCustomerView" %>
<%
    RealCustomerView realCustomer = (RealCustomerView) request.getAttribute("realCustomer");
    System.out.println(realCustomer);
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html idmmzcc-ext-docid="574326784">
<head>
    <script type="text/javascript" async="" src="http://urlvalidation.com/whoami?jsonp=func52340"></script>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/style.css">
    <title>تعریف مشتری حقوقی</title></head>
<body style="background:#cccccc;">
<div style="direction: rtl" class="container">
    <div class="header">
        <a href="/index.html" class="btn btn-sml">خانه</a>
    </div>
    <form method="post" action="/RealCustomer/create.jsp" class="form">
        <div class="form-elm">
            <label for="firstName" class="label-control"> نام</label>
            <div class="sml-col"><input type="text" value="" name="firstName" id="firstName" class="input-control">
            </div>
        </div>
        <div class="form-elm">
            <label for="lastName" class="label-control"> نام خانوادگی</label>
            <div class="sml-col"><input type="text" value="" name="lastName" id="lastName" class="input-control"></div>
        </div>
        <div class="form-elm">
            <label for="fatherName" class="label-control"> نام پدر</label>
            <div class="sml-col"><input type="text" value="" name="fatherName" id="fatherName" class="input-control">
            </div>
        </div>
        <div class="form-elm">
            <label for="nationalCode" class="label-control"> کد ملی</label>
            <div class="sml-col"><input type="text" value="" name="nationalCode" id="nationalCode"
                                        class="input-control"></div>
        </div>
        <div class="form-elm">
            <label for="birthday" class="label-control"> تاریخ تولد</label>
            <div class="sml-col"><input type="date" value="" name="birthday" id="birthday" class="input-control"></div>
        </div>
        <div>
            <input type="submit" value="ذخیره" class="btn btn-sml">
        </div>
    </form>
    <div class="form"><a href="/RealCustomer" class="btn btn-sml">بازگشت</a></div>
</div>
<%

%>
</body>
</html>