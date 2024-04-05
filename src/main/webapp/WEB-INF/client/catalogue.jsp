<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
    <title>Catalogue</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
<h1>Catalogue</h1>
<hr>
<form method="get" action="catalogue">
    <label for="category">Select Category:</label>
    <select name="category" id="category">
        <option value="">All Categories</option>
        <c:forEach var="category" items="${categories}">
            <option value="${category.idcat}">${category.categorie}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Filter">
</form>

<table border="2" cellpadding="10">
    <thead>
    <tr>
        <th>Reference</th>
        <th>Titre</th>
        <th>Photo</th>
        <th>Prix</th>
        <th>Commander</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="article" items="${articles}">
        <tr>
            <td><a href="detail?num=${article.codeArticle}"><c:out value="${article.codeArticle}" /></a></td>
            <td><c:out value="${article.designation}" /></td>
            <td><img src="<c:out value="${article.photo}" />" width="100px"></td>
            <td><c:out value="${article.prix}" /></td>
            <td>
                <form action="panier" method="get">
                    <input type="hidden" name="codeArticle" value="${article.codeArticle}">
                    <input type="hidden" name="designation" value="${article.designation}">
                    <button type="submit">Ajouter au panier</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
