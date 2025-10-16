<%@ page import="java.util.List" %>
<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="fr">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Client JSP De SOAP</title>--%>
<%--</head>--%>
<%--<body style="align-content: center;">--%>
<%--<h1>Client JSP De SOAP - Recherche de livre</h1>--%>

<%--<form action="book" method="post">--%>
<%--    <label for="isbn">ISBN :</label><br/>--%>
<%--    <input type="text" id="isbn" name="isbn" required /><br/>--%>
<%--    <input type="submit" value="Rechercher le livre"/>--%>
<%--</form>--%>

<%--<hr/>--%>

<%--<c:if test="${not empty error}">--%>
<%--    <div style="color:red;">--%>
<%--        <p><strong>Erreur: ${error}</strong></p>--%>
<%--    </div>--%>
<%--</c:if>--%>

<%--<c:if test="${not empty livre}">--%>
<%--    <h3>Information du livre :</h3>--%>
<%--    <p>${livre}</p>--%>
<%--</c:if>--%>

<%--<c:if test="${not empty message}">--%>
<%--    <div style="color:blue;">--%>
<%--        <p><strong>${message}</strong></p>--%>
<%--    </div>--%>
<%--</c:if>--%>

<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bibliotheque Client SOAP JSP</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container py-4">
<h1 class="text-center mb-4">Gestion de Bibliotheque</h1>
<h4 class="text-center mb-4">Client SOAP JSP</h4>
<div class="row">
    <!-- Recherche par ISBN -->
    <div class="col-md-6 mb-3">
        <h3>Rechercher un Livre</h3>
        <form method="post" action="book">
            <input type="hidden" name="action" value="search">
            <input type="text" name="isbn" class="form-control" placeholder="ISBN" required>
            <button type="submit" class="btn btn-primary mt-2">Rechercher</button>
        </form>
        <% if (request.getAttribute("livre") != null) { %>
        <div class="alert alert-info mt-2">Resultat: <%= request.getAttribute("livre") %></div>
        <% } %>
    </div>

    <!-- Ajout d'un livre -->
    <div class="col-md-6 mb-3">
        <h3>Ajouter un Livre</h3>
        <form method="post" action="book">
            <input type="hidden" name="action" value="add">
            <input type="text" name="isbn" class="form-control" placeholder="ISBN" required>
            <input type="text" name="title" class="form-control mt-2" placeholder="Titre" required>
            <input type="text" name="author" class="form-control mt-2" placeholder="Auteur" required>
            <input type="number" name="year" class="form-control mt-2" placeholder="Annee" required>
            <input type="text" name="genre" class="form-control mt-2" placeholder="Genre" required>
            <button type="submit" class="btn btn-success mt-2">Ajouter</button>
        </form>
    </div>
</div>

<div class="row">
    <!-- Suppression -->
    <div class="col-md-6 mb-3">
        <h3>Supprimer un Livre</h3>
        <form method="post" action="book">
            <input type="hidden" name="action" value="delete">
            <input type="text" name="isbn" class="form-control" placeholder="ISBN" required>
            <button type="submit" class="btn btn-danger mt-2">Supprimer</button>
        </form>
    </div>

    <!-- Mise à jour -->
    <div class="col-md-6 mb-3">
        <h3>Mettre a Jour un Livre</h3>
        <form method="post" action="book">
            <input type="hidden" name="action" value="update">
            <input type="text" name="isbn" class="form-control" placeholder="ISBN" required>
            <input type="text" name="newTitle" class="form-control mt-2" placeholder="Nouveau Titre" required>
            <input type="text" name="newAuthor" class="form-control mt-2" placeholder="Nouvel Auteur" required>
            <input type="number" name="newYear" class="form-control mt-2" placeholder="Nouvelle Annee" required>
            <input type="text" name="newGenre" class="form-control mt-2" placeholder="Nouveau Genre" required>
            <button type="submit" class="btn btn-warning mt-2">Mettre à Jour</button>
        </form>
    </div>
</div>

<div class="row">
    <!-- Recherche par Auteur -->
    <div class="col-md-6 mb-3">
        <h3>Rechercher par Auteur</h3>
        <form method="post" action="book">
            <input type="hidden" name="action" value="searchAuthor">
            <input type="text" name="auteur" class="form-control" placeholder="Nom de l'Auteur" required>
            <button type="submit" class="btn btn-info mt-2">Rechercher</button>
        </form>
        <% if (request.getAttribute("booksByAuthor") != null) { %>
        <div class="alert alert-secondary mt-2">
            <% for (String book : (List<String>) request.getAttribute("booksByAuthor")) { %>
            <p><%= book %></p>
            <% } %>
        </div>
        <% } %>
    </div>

    <!-- Liste de tous les livres -->
    <div class="col-md-6 mb-3">
        <h3>Afficher Tous les Livres</h3>
        <form method="post" action="book">
            <input type="hidden" name="action" value="allBooks">
            <button type="submit" class="btn btn-dark">Afficher</button>
        </form>
        <% if (request.getAttribute("livres") != null) { %>
        <div class="alert alert-secondary mt-2">
            <% for (String book : (List<String>) request.getAttribute("livres")) { %>
            <p><%= book %></p>
            <% } %>
        </div>
        <% } %>
    </div>
</div>

<% if (request.getAttribute("message") != null) { %>
<div class="alert alert-success mt-2"><%= request.getAttribute("message") %></div>
<% } %>
<% if (request.getAttribute("error") != null) { %>
<div class="alert alert-danger mt-2"><%= request.getAttribute("error") %></div>
<% } %>
</body>
</html>


