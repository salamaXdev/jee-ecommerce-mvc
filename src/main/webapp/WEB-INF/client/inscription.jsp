
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
<div class="form-container">
    <h2 class="title">Inscrivez-vous</h2>
    <form action="inscription" method="post">
        <div class="input-group">
            <div class="input-group-item">
                <label for="email">Email :</label>
                <input type="email" id="email" name="email" class="input-field" required>
            </div>
            <div class="input-group-item">
                <label for="nom">Nom :</label>
                <input type="text" id="nom" name="nom" class="input-field" required>
            </div>
        </div>
        <div class="input-group">
            <div class="input-group-item">
                <label for="prenom">Prénom :</label>
                <input type="text" id="prenom" name="prenom" class="input-field" required>
            </div>
            <div class="input-group-item">
                <label for="adresse">Adresse :</label>
                <input type="text" id="adresse" name="adresse" class="input-field">
            </div>
        </div>
        <div class="input-group">
            <div class="input-group-item">
                <label for="codePostal">Code Postal :</label>
                <input type="text" id="codePostal" name="codePostal" class="input-field">
            </div>
            <div class="input-group-item">
                <label for="ville">Ville :</label>
                <input type="text" id="ville" name="ville" class="input-field">
            </div>
        </div>
        <div class="input-group">
            <div class="input-group-item">
                <label for="tel">Téléphone :</label>
                <input type="tel" id="tel" name="tel" class="input-field">
            </div>
            <div class="input-group-item">
                <label for="motPasse">Mot de passe :</label>
                <input type="password" id="motPasse" name="motPasse" class="input-field" required>
            </div>
        </div>
        <input type="submit" value="S'inscrire" class="submit-button">
    </form>
</div>

</body>
</html>
