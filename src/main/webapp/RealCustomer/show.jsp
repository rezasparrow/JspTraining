<%@ page import="logic.model.RealCustomerView" %>
<%@ page import="logic.model.GrantConditionView" %>
<%@ page import="java.util.List" %>
<%@ page import="logic.model.LoanFileView" %>
<%@ page import="bean.LoanFile" %>
<%@ page import="java.util.Set" %>
<%
    RealCustomerView realCustomer = (RealCustomerView) request.getAttribute("realCustomer");
    if (realCustomer == null) {
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
            <h4 class="text-center">
                اصلاعات شخصی
            </h4>
            <div class="form-horizontal">

                <div class="form-group">
                    <div class="col-sm-2">
                        شماره مشتری
                    </div>
                    <div class="col-sm-6">
                        <%=realCustomer.getCustomerNumber()%>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">
                            نام
                        </label>
                    </div>
                    <div class="col-sm-6">
                        <%=realCustomer.getFirstName()%>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">
                            نام‌خانوادگی
                        </label>
                    </div>
                    <div class="col-sm-6">
                        <%=realCustomer.getLastName()%>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">
                            نام پدر
                        </label>
                    </div>

                    <div class="col-sm-6">
                        <%=realCustomer.getFatherName()%>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">
                            تاریخ تولد
                        </label>
                    </div>
                    <div class="col-sm-6">
                        <%=realCustomer.getBirthday().toString()%>
                    </div>
                </div>


            </div>

            <div class="form-horizontal">
                <h3 class="text-center">
                    پرونده‌های تسهیلاتی
                </h3>
                <%
                    if (realCustomer.getLoanFiles().size() > 0) {
                %>
                <div class="form-group">

                    <table class="table">
                        <thead>
                        <tr>
                            <th>
                                ردیف
                            </th>
                            <th>
                                نوع تسهیلات
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<LoanFile> loanFiles = realCustomer.getLoanFiles();
                            for (int i = 0; i < loanFiles.size(); ++i) {
                        %>
                        <tr>
                            <td>
                                <%=i + 1%>
                            </td>
                            <td>
                                <%=loanFiles.get(i).getLoanType().getName()%>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>

                    </table>
                </div>
                <%
                } else {
                %>
                <div class="form-group">
                    <div class="col-sm-12">
                        <h4 class="help-block">هیچ پرونده‌تسهیلاتی برای این مشتری تعریف نشده است</h4>
                    </div>
                </div>
                <%
                    }
                %>
                <div class="form-group">
                    <div class="col-sm-12" style="direction: ltr;">
                        <a class="btn btn-success" href="/LoanFile/new?customerId=<%=realCustomer.getId()%>" >
                            اضافه کردن پرونده تهسیلاتی</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="panel-footer">
            <div>
                <a href="/RealCustomer/edit.jsp?id=<%=realCustomer.getId()%>" class="btn btn-success">
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
