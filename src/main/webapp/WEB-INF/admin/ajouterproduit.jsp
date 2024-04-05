
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ajouter un Produit</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">

</head>
<body>
    <div class="container">
        <h2 class="title">Ajouter un Produit</h2>

        <form action="ajouterproduit" method="post" class="form">
            <div class="form-group">
                <label for="designation">Designation :</label>
                <input type="text" id="designation" name="designation" class="form-control" required placeholder="Titre de l'article">
            </div>
            <div class="form-group">
                <label for="prix">Prix :</label>
                <input type="text" id="prix" name="prix" class="form-control" required placeholder="100DH">
            </div>
            <div class="form-group">
                <label for="stock">Stock :</label>
                <input type="number" id="stock" name="stock" class="form-control" required placeholder="300">
            </div>

            <div class="form-group">
                <label for="photo">Photo :</label>
                <input type="text" id="photo" name="photo" class="form-control" required placeholder="URL de l'image">
            </div>

            <label for="category">Select Category:</label>
            <select name="category" id="category">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.idcat}">${category.categorie}</option>
                </c:forEach>
            </select>

            <input type="submit" value="Ajouter" class="btn btn-primary">
        </form>

    </div>
</body>
</html>
