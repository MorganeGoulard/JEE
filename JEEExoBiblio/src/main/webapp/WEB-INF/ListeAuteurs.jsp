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
							<th>nom</th>
							<th>prenom</th>
							<th>téléphone</th>
							<th>email</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ auteurs }" var="auteur" >
						<tr>
							<td><c:out value="${ auteur.nom }"/></td>
							<td><c:out value="${ auteur.prenom }"/></td>
							<td><c:out value="${ auteur.telephone }"/></td>
							<td><c:out value="${ auteur.email }"/></td>
						</tr>	
					</c:forEach>
					</tbody>
				
				</table>
			</c:otherwise>
	</c:choose>
	
</body>
</html>