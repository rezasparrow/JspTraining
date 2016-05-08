<%--
  Created by IntelliJ IDEA.
  User: Dotin School1
  Date: 5/8/2016
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <tr>
            <td>1</td>
            <td>16</td>
            <td>رضا</td>
            <td>صادقی</td>
            <td>حسن</td>
            <td>0123456789</td>
            <td><a href="/RealCustomer/edit?id=1">edit</a></td>
            <td><a href="/RealCustomer/delete?id=1">delete</a></td>
        </tr>
        </tbody>
    </table>
</div>
<div>


</div>
</body>
</html>
