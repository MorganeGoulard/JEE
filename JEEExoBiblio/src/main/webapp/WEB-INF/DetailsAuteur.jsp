<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rechercher un auteur </title>
</head>
<body>

	<c:import url="/WEB-INF/menu.jsp" />

	<h1> Recherche d'un auteur </h1>
	
	
	<c:choose>
			<c:when test="${ empty auteur }">
			L'auteur recherché n'existe pas
			</c:when>
			<c:otherwise>
			<table>
			<thead>
				<tr>
					<th>nom</th>
					<th>prenom</th>
					<th>téléphone</th>
					<th>email</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${ auteur.nom }"/></td>
					<td><c:out value="${ auteur.prenom }"/></td>
					<td><c:out value="${ auteur.telephone }"/></td>
					<td><c:out value="${ auteur.email }"/></td>
				</tr>
			</tbody>
			</table>

			</c:otherwise>
	</c:choose>		
	
	
	<a href="/ListeAuteurs">Retour à la liste d'auteurs</a>

</body>
</html>