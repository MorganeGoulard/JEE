<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste livres</title>
</head>
<body>
<c:import url="/WEB-INF/menu.jsp" />

	<div>${ sessionScope.confirmationMsg }</div>
	
	<c:choose>
			<c:when test="${ empty livres }">
			Aucun livre trouvé... 
			</c:when>
			<c:otherwise>
				<table>
					<thead>
						<tr>
							<th>Auteur</th>
							<th>Titre</th>
							<th colspan="3">Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ livres }" var="livre" >
						<tr>
							<td><c:out value="${ livre.auteur.nom }"/> <c:out value="${ livre.auteur.prenom }"/></td>
							<td><c:out value="${ livre.titre }"/></td>
							<td><a href="<c:url value="/ListeLivres"><c:param name="id" value="${ livre.id }" /></c:url>">Voir détails</a></td>
							<td><a href="<c:url value="/SupprimerLivre"><c:param name="id" value="${ livre.id }" /></c:url>">Supprimer</a></td>
							<td><a href="<c:url value="/ModifierLivre"><c:param name="id" value="${ livre.id }" /></c:url>">Modifier</a></td>
						</tr>	
					</c:forEach>
					</tbody>
				
				</table>
			</c:otherwise>
	</c:choose>
	
	<div><a href="<c:url value="/AjouterLivre" />">Ajouter un livre</a></div>
	
</body>
</html>