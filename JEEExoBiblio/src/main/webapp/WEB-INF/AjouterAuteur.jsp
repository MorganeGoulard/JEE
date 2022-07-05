<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un auteur</title>
</head>
<body>

	<c:import url="/WEB-INF/menu.jsp" />

	<form method="post" action="<c:url value="/AjouterAuteur" />">
		<div>
			<label for="nomAuteur">Nom</label>
			<input type="text" id="nomAuteur" name="nomAuteur"/>
			<span class="erreur">${ erreurs['nomAuteur'] }</span>
		</div>
		<div>
			<label for="prenomAuteur">Prénom</label>
			<input type="text" id="prenomAuteur" name="prenomAuteur"/>
			<span class="erreur">${ erreurs['prenomAuteur'] }</span>
		</div>
		<div>
			<label for="telephoneAuteur">Téléphone</label>
			<input type="number" id="telephoneAuteur" name="telephoneAuteur"/>
			<span class="erreur">${ erreurs['telephoneAuteur'] }</span>
		</div>
		<div>
			<label for="emailAuteur">Email</label>
			<input type="text" id="emailAuteur" name="emailAuteur"/>
			<span class="erreur">${ erreurs['emailAuteur'] }</span>
		</div>
		<div>
			<input type="submit" value="Ajouter"/>
			<input type="reset" value="Remettre à zéro"/>
		</div>
		
	</form>
	
	

</body>
</html>