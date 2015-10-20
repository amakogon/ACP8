<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>

  <h1>Add user form</h1>

  <%--localhost:8080/add-user-servlet--%>
  <form action="add-user-servlet" method="post">
    <ul>
    <li>User name : <input name="name" type="text"></li>
    <li>User phone : <input name="phone" type="text"></li>
    <li>User email : <input name="email" type="text"></li>
    </ul>
    <input type="submit" value="send">
  </form>

</body>
</html>
