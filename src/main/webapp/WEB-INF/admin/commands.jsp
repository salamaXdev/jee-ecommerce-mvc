<%--
  Created by IntelliJ IDEA.
  User: anassalama
  Date: 21/3/2024
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Commandes</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
    <h3>Commandes Lists</h3>
    <table border="2" cellpadding="10">
        <thead>
            <tr>
                <th>Num Commande</th>
                <th>Code Client</th>
                <th>Code Article</th>
                <th>Date Commande</th>
            </tr>
        </thead>
    <tbody>
    <c:forEach var="article" items="${commandes}">
        <tr>
            <td><c:out value="${article.numCommande}" /></td>
            <td><a href="detailclient?num=${article.codeClient}"><c:out value="${article.codeClient}" /></a></td>
            <td><a href="detail?num=${article.codeArticle}"><c:out value="${article.codeArticle}" /></a></td>
            <td><c:out value="${article.dateCommande}" /></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
</body>
</html>
