<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>User info</title>
</head>
<body>
    <c:set var="myUser" value="${user}"/>
    <h1>User info</h1>
    id:     ${myUser.id} <br>
    name:   ${myUser.name} <br>
    phone:  ${myUser.phone} <br>
    email:  ${myUser.email} <br>
</body>
</html>
