<%--
  Created by IntelliJ IDEA.
  User: anassalama
  Date: 15/3/2024
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="languages.text" var="bundle"/>


<html>
<head>
    <title>Accueil</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">

</head>
<body>


<h1><fmt:message key="dashboard.label.greeting" bundle="${bundle}"/> <c:out value="${sessionScope.nom}"/></h1>
<hr>

<div class="container">
<a href="catalogue" class="link"><fmt:message key="dashboard.label.see.catalogue" bundle="${bundle}"/></a><br>
<a href="panier" class="link"><fmt:message key="dashboard.label.see.cart" bundle="${bundle}"/></a>
</div>

</body>
</html>
