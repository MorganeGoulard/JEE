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

	<h1> Détails de ${ auteur.nom } ${ auteur.prenom} </h1>
	
	
	<c:choose>
			<c:when test="${ empty auteur }">
			L'auteur recherché n'existe pas
			</c:when>
			<c:otherwise>
			<table>
			<thead>
				<tr>
					<th>téléphone</th>
					<th>email</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${ auteur.telephone }"/></td>
					<td><c:out value="${ auteur.email }"/></td>
				</tr>
			</tbody>
			</table>

			</c:otherwise>
	</c:choose>		
	
	
	<p><a href="<c:url value="/ListeAuteurs" />">Retour à la liste d'auteur</a></p>

</body>
</html>