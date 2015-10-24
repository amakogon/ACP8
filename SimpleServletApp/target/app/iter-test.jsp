<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jsp simple</title>
</head>
<body>

    <%String name = String.format("name %s, age %d", "Kolia",25);%>
    <h1>Iter</h1>

    <b><%=name%></b>

    <ul>
    <%for (int i = 0; i < 10; i++){ %>
        <li><%=i%></li>
    <%}%>
    </ul>

</body>
</html>
