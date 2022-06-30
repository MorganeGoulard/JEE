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

	<h1> Détail de ${ livre.titre } de ${ livre.auteur.nom } ${ ivre.auteur.prenom }</h1>
	
	
	<c:choose>
			<c:when test="${ empty livre }">
			Le livre recherché n'existe pas
			</c:when>
			<c:otherwise>
			<table>
			<thead>
				<tr>
					<th>Nombre de pages</th>
					<th>Catégorie</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${ livre.nbPages }"/></td>
					<td><c:out value="${ livre.categorie }"/></td>
				</tr>
			</tbody>
			</table>

			</c:otherwise>
	</c:choose>		
	
	
	<div><a href="<c:url value="/ListeLivres" />">Retour à la liste de livres</a></div>

</body>
</html>