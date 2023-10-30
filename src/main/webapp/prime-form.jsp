<%--
  65130500073 - Watchara Santawee
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 10/30/2023
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Midterm Exam</title>
</head>
<body>
<h2>Midterm Exam Web App by Watchara Santawee 65130500073</h2>
<h2>Welcome ${sessionScope.user.username} (${sessionScope.user.email})</h2>
<hr/>
<h1>Primer Checker ::</h1>
<hr/>
<form action="is_prime" method="post">
    <label for="number">Enter number to check:</label>
    <input type="text" name="number" id="number" value="${requestScope.currentValue}" />
    <c:if test="${requestScope.error != null}">
        <p style="color: red">${requestScope.error}</p>
    </c:if>
    <c:if test="${requestScope.message != null && requestScope.error == null}">
        <p style="color: blue">${requestScope.message}</p>
    </c:if>
    <br/>
    <button type="submit">
        Submit
    </button>
</form>
</body>
</html>
