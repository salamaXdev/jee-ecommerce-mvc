<%--
  Created by IntelliJ IDEA.
  User: anassalama
  Date: 16/3/2024
  Time: 00:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">

</head>
<body>

<h2>Voici ta commande complète</h2>
<table border="2" cellpadding="10">
    <thead>
    <tr>
        <th>Reference</th>
        <th>Titre</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="article" items="${sessionScope.cart}">
        <tr>
            <td><c:out value="${article.key}" /></td>
            <td><c:out value="${article.value}" /></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<br><br>
<a href="catalogue" class="link"><button>Effectuer un autre Achat</button></a>

</body>
</html>
