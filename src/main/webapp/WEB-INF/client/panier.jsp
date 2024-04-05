
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Panier</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
<h1>Votre Panier</h1>
<table border="2" cellpadding="10">
    <thead>
    <tr>
        <th>Reference</th>
        <th>Titre</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${not empty sessionScope.cart}">
            <c:forEach var="article" items="${sessionScope.cart}">
                <tr>
                    <td><c:out value="${article.key}" /></td>
                    <td><c:out value="${article.value}" /></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="2">Vide ^^</td>
            </tr>
        </c:otherwise>
    </c:choose>

    </tbody>
</table>

<br>
    <form method="post" action="panier" class="form">
        <input type='hidden' name='clearCart' value='true'>
        <input type="submit" value="Vider le panier"/>
    </form>
<a href="catalogue"><button>Porsuivre l'achat </button></a><br><br>
<a href="enregistre"><button>Enregistrer les commandes</button></a>


</body>
</html>
