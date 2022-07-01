<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier auteur</title>
</head>
<body>

	<c:import url="/WEB-INF/menu.jsp" />
	
		<form method="post" action="<c:url value="/ModifierAuteur"><c:param name="id" value="${ auteur.id }" /></c:url>">
		<div>
			<label for="nomAuteur">Nom</label>
			<input type="text" id="nomAuteur" name="nomAuteur" value="<c:out value="${ auteur.nom }" />"/>
			<span class="erreur">${ erreurs['nomAuteur'] }</span>
		</div>
		<div>
			<label for="prenomAuteur">Prénom</label>
			<input type="text" id="prenomAuteur" name="prenomAuteur" value="<c:out value="${ auteur.prenom }" />"/>
			<span class="erreur">${ erreurs['prenomAuteur'] }</span>
		</div>
		<div>
			<label for="telephoneAuteur">Téléphone</label>
			<input type="number" id="telephoneAuteur" name="telephoneAuteur" value="<c:out value="${ auteur.telephone }" />"/>
			<span class="erreur">${ erreurs['telephoneAuteur'] }</span>
		</div>
		<div>
			<label for="emailAuteur">Email</label>
			<input type="text" id="emailAuteur" name="emailAuteur" value="<c:out value="${ auteur.email }" />"/>
			<span class="erreur">${ erreurs['emailAuteur'] }</span>
		</div>
		<div>
			<input type="submit" value="Modifier"/>
			<input type="reset" value="Remettre à zéro"/>
		</div>
		
	</form>


</body>
</html>