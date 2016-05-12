<%@ page import="presentation.LoanTypeView" %>
<%@ page import="controller.LoanTypeController" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.LoanType" %>
<%
    LoanTypeController controller = new LoanTypeController();
    request.setCharacterEncoding("UTF-8");
    LoanTypeView loanTypeView = new LoanTypeView();
    loanTypeView.setName(request.getParameter("name"));
    List<LoanType> loanTypes = controller.all(loanTypeView);
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>تسهیلات</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container">
    <div class="header">
        <a href="/index.jsp" class="btn btn-sml">خانه</a>
    </div>
    <div class="content">

        <a class="btn btn-sml" href="/LoanType/new.jsp">تعریف نوع تسهیلات جدید</a>
        <form class="form" method="post" action="/LoanType/index.jsp">
            <div class="form-elm">

                <label class="label-control"> نام نوع تسهیلات</label>
                <input name="name" class="input-control" value="<%=loanTypeView.getName()%>">
                <input type="submit" value="جست‌وجو" class="btn btn-sml">

            </div>
        </form>
        <%

            if (loanTypes.size() > 0) { %>

        <table class="table">
            <thead>
            <tr>
                <th>
                    ردیف
                </th>
                <th>
                    نام نوع تسهیلات
                </th>
                <th>
                    نرخ سود
                </th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <% int num = 0;
                for (LoanType loanType : loanTypes) {
                    num++;
            %>
            <tr>

                <td><%=num%>
                </td>
                <td><%=loanType.getName()%>
                </td>
                <td><%=loanType.getRate()%>
                </td>
                </td>
                <td><a href="/LoanType/edit.jsp?id=<%=loanType.getId()%>">edit</a></td>
                <td><a href="/LoanType/delete.jsp?id=<%=loanType.getId()%>">delete</a></td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <%} else {%>

        <h2>هیچ داده‌ای موجود نمی‌باشد</h2>
        <%}%>
    </div>


</div>
</body>
</html>
