<%@ page import="logic.model.RealCustomerView" %>
<%
    RealCustomerView realCustomerView = (RealCustomerView) request.getAttribute("realCustomer");
    if (realCustomerView == null) {
        response.sendRedirect("/index.jsp");
    }

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>مشتری حقبقی</title>
    <link rel="stylesheet" href="/css/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap-rtl/dist/css/bootstrap-rtl.css">
    <style>
        body {
            font-family: "B yas", tahoma;
            font-size: 20px;
        }

        input {
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index.jsp">
                خانه
            </a>
        </div>
    </div>
</nav>
<div class="container" style="margin-top: 80px;">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h2 class="text-center">
                اطلاعات مشتری حقیقی
            </h2>
        </div>
        <div class="panel-body">
            <div class="form-horizontal">

                <div class="form-group">
                    <div class="col-sm-2">
                        شماره مشتری
                    </div>
                    <div class="col-sm-6">
                        <%=realCustomerView.getCustomerNumber()%>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">
                            نام
                        </label>
                    </div>
                    <div class="col-sm-6">
                        <%=realCustomerView.getFirstName()%>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">
                            نام‌خانوادگی
                        </label>
                    </div>
                    <div class="col-sm-6">
                        <%=realCustomerView.getLastName()%>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">
                            نام پدر
                        </label>
                    </div>

                    <div class="col-sm-6">
                        <%=realCustomerView.getFatherName()%>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">
                            تاریخ تولد
                        </label>
                    </div>
                    <div class="col-sm-6">
                        <%=realCustomerView.getBirthday().toString()%>
                    </div>
                </div>


            </div>
        </div>
        <div class="panel-footer">
            <div>
                <a href="/RealCustomer/edit.jsp?id=<%=realCustomerView.getId()%>" class="btn btn-success">
                    ویرایش
                </a>
                <a href="/RealCustomer" class="btn btn-primary">
                    برگشت
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
