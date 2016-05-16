<%@ page import="logic.model.LoanTypeView" %>
<%@ page import="logic.model.RealCustomerView" %>
<%@ page import="java.util.List" %>
<%
    RealCustomerView realCustomer = (RealCustomerView) request.getAttribute("realCustomer");
    List<LoanTypeView> loanTypes = (List<LoanTypeView>) request.getAttribute("loanTypes");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>پرونده تسهیلاتی جدید</title>
    <link rel="stylesheet" href="http://ifont.ir/apicode/37">
    <meta charset="utf-8">
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
    <div class="panel panel-primary" method="post" action="/LoanType/new">
        <div class="panel-heading">
            <h2 class="text-center">
                پرونده تسهیلاتی جدید
            </h2>
        </div>
        <div class="panel-body">
            <form action="/LoanFile/create" method="post" class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="label-control">
                            نام مشتری
                        </label>
                    </div>
                    <div class="col-sm-6">
                        <input type="hidden" name="customerId" value="<%=realCustomer.getId().toString()%>"/>
                        <%=realCustomer.getRealName()%>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="label-control">
                            نوع تسهیلات
                        </label>
                    </div>
                    <div class="col-sm-6">
                        <select name="loanTypeId" class="form-control">
                            <%
                                for (LoanTypeView loanType : loanTypes) {
                            %>
                            <option value="<%=loanType.getId()%>">
                                <%=loanType.getName()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-12">
                        <input class="btn btn-primary" type="submit" value="ذخیره">
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>
