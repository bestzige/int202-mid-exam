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
<table>
    <thead>
    <tr>No</tr>
    <tr>Number</tr>
    <tr>Is Prime</tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.primes}" var="prime">
        <tr>
            <td>${prime.id}</td>
            <td>${prime.number}</td>
            <td>${prime.prime ? "&#x2713;" : "&#x2717;"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr/>
<p>
    No of prime = ${requestScope.primeCount}
</p>
</body>
</html>
