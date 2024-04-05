
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>

<h1>Welcome ${sessionScope.nom}</h1>
<hr>
<div class="container">
<a href="commandes" class="link">Consulter les Commandes</a><br>
<a href="produits" class="link">Modifier Les Produits</a><br>
</div>

</body>
</html>
