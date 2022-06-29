<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rechercher livre</title>
</head>
<body>

	<c:import url="/WEB-INF/menu.jsp" />

	<h1> Recherche d'un livre </h1>
	
	
	<c:choose>
			<c:when test="${ empty livre }">
			Le livre recherché n'existe pas
			</c:when>
			<c:otherwise>
			<table>
			<thead>
				<tr>
					<th>auteur</th>
					<th>titre</th>
					<th>nombre de pages</th>
					<th>catégorie</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${ livre.auteur.nom } ${ livre.auteur.prenom }"/></td>
					<td><c:out value="${ livre.titre }"/></td>
					<td><c:out value="${ livre.nbPages }"/></td>
					<td><c:out value="${ livre.categorie }"/></td>
				</tr>
			</tbody>
			</table>

			</c:otherwise>
	</c:choose>		
	
	
	<a href="/ListeLivres">Retour à la liste de livres</a>

</body>
</html>