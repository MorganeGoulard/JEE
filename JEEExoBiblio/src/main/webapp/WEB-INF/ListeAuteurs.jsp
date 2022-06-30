<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Auteurs</title>
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />
	
	<c:choose>
			<c:when test="${ empty auteurs }">
			Aucun auteur trouvé... 
			</c:when>
			<c:otherwise>
				<table>
					<thead>
						<tr>
							<th>Nom</th>
							<th>Prenom</th>
							<th colspan = "2">Actions</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ auteurs }" var="auteur" >
						<tr>
							<td><c:out value="${ auteur.nom }"/></td>
							<td><c:out value="${ auteur.prenom }"/></td>
							<td><a href="<c:url value="/DetailsAuteur"><c:param name="id" value="${ auteur.id }" /></c:url>">Voir détails</a></td>
							<td><a href="<c:url value="/SupprimerAuteur"><c:param name="id" value="${ auteur.id }" /></c:url>">Supprimer</a></td>
							
						</tr>	
					</c:forEach>
					</tbody>
				
				</table>
			</c:otherwise>
	</c:choose>
	
		<div><a href="<c:url value="/AjouterAuteur" />">Ajouter un auteur</a></div>
	
	
</body>
</html>