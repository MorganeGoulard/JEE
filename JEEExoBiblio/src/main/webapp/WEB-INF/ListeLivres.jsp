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
	
	<c:choose>
			<c:when test="${ empty livres }">
			Aucun livre trouvé... 
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
					<c:forEach items="${ livres }" var="livre" >
						<tr>
							<td><c:out value="${ livre.auteur.nom }"/> <c:out value="${ livre.auteur.prenom }"/></td>
							<td><c:out value="${ livre.titre }"/></td>
							<td><c:out value="${ livre.nbPages }"/></td>
							<td><c:out value="${ livre.categorie }"/></td>
						</tr>	
					</c:forEach>
					</tbody>
				
				</table>
			</c:otherwise>
	</c:choose>
	
</body>
</html>