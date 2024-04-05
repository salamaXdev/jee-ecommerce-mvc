<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Details</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
<h2>Les Details de l'article</h2>
<hr>
<div class="container2">
    <img src="<c:out value="${article.photo}"/>" width="300px"/>
    <h3 class="info">Reference : <c:out value="${article.codeArticle}"/></h3>
    <h3 class="info">Titre : <c:out value="${article.designation}"/></h3>
    <h3 class="info">Quantité en stock : <c:out value="${article.stock}"/></h3>
    <h3 class="info">Prix : <c:out value="${article.prix}"/></h3>
</div>
<c:choose>
<c:when test="${sessionScope.type=='admin'}">
    <a href="commandes" class="link">retour</a><br>
</c:when>
<c:otherwise>
    <a href="catalogue" class="link">retour</a><br>
    <a href="panier?codeArticle=${article.codeArticle}&designation=${article.designation}" class="link">Ajouter au panier</a><br>
</c:otherwise>
</c:choose>
</body>
</html>
