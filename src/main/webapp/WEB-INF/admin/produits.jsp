
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Les Produits</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
<h1>List des Produits</h1>
<hr>
<table border="2" cellpadding="4">
    <thead>
    <tr>
        <th>Reference</th>
        <th>Titre</th>
        <th>Photo</th>
        <th>Prix</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="article" items="${articles}">
        <tr>
            <td><a href="detail?num=${article.codeArticle}"><c:out value="${article.codeArticle}" /></a></td>
            <td><c:out value="${article.designation}" /></td>
            <td><img src="<c:out value="${article.photo}" />" width="50px"></td>
            <td><c:out value="${article.prix}" /></td>
            <td>
                <form action="produits" method="post">
                    <input type="hidden" name="codeArticle" value="${article.codeArticle}">
                    <button type="submit">Supprimer</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="ajouterproduit" class="link">Ajouter un Produit</a><br>

</body>
</html>

