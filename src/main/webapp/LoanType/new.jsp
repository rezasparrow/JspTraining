<%@ page import="presentation.LoanTypeView" %>
<%@ page import="bean.LoanType" %>
<%@ page import="logic.LoanTypeManipulator" %>
<%@ page import="util.MessageBundle" %>

<%
    LoanTypeView loanTypeView = new LoanTypeView();

    String method = request.getMethod();
    if (method.equalsIgnoreCase("post")) {

        request.setCharacterEncoding("UTF-8");
        loanTypeView.setName(request.getParameter("name"));
        loanTypeView.setRate(request.getParameter("lastName"));
        LoanTypeManipulator controller = new LoanTypeManipulator();
        MessageBundle errors = controller.save(loanTypeView);
        if (errors.isValid()) {
            response.sendRedirect("/RealCustomer");
        }
    }

    System.out.println(loanTypeView);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>تعریف نوع‌تسهیلات جدید</title>
    <link rel="stylesheet" href="/css/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap-rtl/dist/css/bootstrap-rtl.css">
    <link rel="stylesheet" href="http://ifont.ir/apicode/37">
    <style>
        body {
            font-family: "B yas", tahoma;
            font-size: 20px;
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
    <form class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">
                تسهیلات جدید
            </h2>
        </div>

        <div class="panel-body">

            <div class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="name" class="control-label">
                            نوع تسهیلات
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" id="name" name="name"
                               required title="نام نوع تسهیلات الزامی است"
                               x-moz-errormessage="نام نوع تسهیلات الزامی است">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="rate" class="control-label">
                            نرخ سود
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" id="rate" name="rate"
                               required title="نرخ سود الزامی است" x-moz-errormessage="نرخ سود الزامی است">
                    </div>
                </div>

            </div>
            <div class="form-horizontal " id="grandCondition">

                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="grandCondition[name]" class="control-label">
                            نام شرط
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" onkeyup="validate(this)" id="grandCondition[name]">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="grandCondition[minAmount]" class="control-label">
                            حداقل مبلغ قرارداد
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" onkeyup="validate(this)" id="grandCondition[minAmount]">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="grandCondition[maxDuration]" class="control-label">
                            حداکثر مبلغ قرارداد
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" onkeyup="validate(this)" id="grandCondition[maxDuration]">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="grandCondition[minDuration]" class="control-label">
                            حداقل مدت قرارداد
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control has-error" onkeyup="validate(this)" id="grandCondition[minDuration]">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label for="grandCondition[maxAmount]" class="control-label">
                            حداکثر مدت قرارداد
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <input class="form-control" onkeyup="validate(this)" id="grandCondition[maxAmount]">
                    </div>
                    <div class="col-sm-offset-3 col-sm-3">
                        <input type="button" class="btn btn-success" value="اضافه کردن شرط جدید"
                               onclick="addNewGrandCondition()">
                    </div>
                </div>


            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="submit" value="ذخیره" class="btn btn-primary"/>
                </div>
            </div>

            <table class="table" id="grandConditionTable">
                <thead>
                <tr>
                    <td>
                        ردیف
                    </td>
                    <td>
                        نام شرط
                    </td>
                    <td>
                        حداقل مبلغ قرارداد
                    </td>
                    <td>
                        حداکثر مبلغ قرارداد
                    </td>
                    <td>
                        حداقل مدت قرارداد
                    </td>
                    <td>
                        حداکثر مدت قرارداد
                    </td>
                </tr>
                </thead>
                <tbody>
                <tr>
                </tr>
                </tbody>
            </table>
        </div>
    </form>

</div>
<script>
    var numElement = 0;
    function validate(element) {
        var parent = element.parentElement;
        if (element.value == "") {
            parent.className += " has-error";
            return false;
        } else {
            parent.className = parent.className.replace("has-error", "");
        }
        return true;
    }

    function addNewGrandCondition() {
        var name = document.getElementById("grandCondition[name]");
        name.event
        var maxAmount = document.getElementById("grandCondition[maxAmount]");
        var minAmount = document.getElementById("grandCondition[minAmount]");
        var maxDuration = document.getElementById("grandCondition[maxDuration]");
        var minDuration = document.getElementById("grandCondition[minDuration]");
        console.log(document.getElementById(name));
        console.log(name.value);
        var valid = validate(name);
        valid = validate(maxAmount) && valid;
        valid = validate(minAmount) && valid;
        valid = validate(minDuration) && valid;
        valid = validate(maxDuration) && valid;
        if (!valid) {
            return;
        }

        var conditionTable = document.getElementById("grandConditionTable");
        var row = conditionTable.insertRow(numElement + 1);
        row.insertCell(0).innerHTML = numElement;
        row.insertCell(1).innerHTML = name.value + '<input type="hidden" name="grandCondition[name][' + numElement + ']" value="' + name.value + '"/>';
        row.insertCell(2).innerHTML = minAmount.value + '<input type="hidden" name="grandCondition[name][' + numElement + ']" value="' + minAmount.value + '"/>';
        row.insertCell(3).innerHTML = maxAmount.value + '<input type="hidden" name="grandCondition[name][' + numElement + ']" value="' + maxAmount.value + '"/>';
        row.insertCell(4).innerHTML = minDuration.value + '<input type="hidden" name="grandCondition[name][' + numElement + ']" value="' + minDuration.value + '"/>';
        row.insertCell(5).innerHTML = maxDuration.value + '<input type="hidden" name="grandCondition[name][' + numElement + ']" value="' + maxDuration.value + '"/>';

        name.value = "";
        maxAmount.value = "";
        minAmount.value = "";
        maxDuration.value = "";
        minDuration.value = "";

        numElement = numElement + 1;
    }
</script>
</body>
</html>
