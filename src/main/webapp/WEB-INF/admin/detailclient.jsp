<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Detail Client</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
<h2>Details du Client</h2>
<table border="2" cellpadding="10">
    <thead>
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Adresse</th>
        <th>Code Postal</th>
        <th>Ville</th>
        <th>Tel</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${client.id}" /></td>
            <td><c:out value="${client.email}" /></td>
            <td><c:out value="${client.nom}" /></td>
            <td><c:out value="${client.prenom}" /></td>
            <td><c:out value="${client.adresse}" /></td>
            <td><c:out value="${client.codePostal}" /></td>
            <td><c:out value="${client.ville}" /></td>
            <td><c:out value="${client.tel}" /></td>
        </tr>
    </tbody>
</table>
</body>
</html>
