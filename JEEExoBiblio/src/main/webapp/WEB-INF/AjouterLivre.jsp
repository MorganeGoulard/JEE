<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un livre</title>
</head>
<body>

	<c:import url="/WEB-INF/menu.jsp" />

	<form method="post" action="<c:url value="/AjouterLivre" />">
		<div>
			<label for="auteurLivre">Auteur</label>
			<select id="auteurLivre" name="auteurLivre">
				<c:forEach items="${ auteurs }" var="auteur">
					<option value="<c:out value="${ auteur.id }"/>"><c:out value="${ auteur.prenom }"/> <c:out value="${ auteur.nom }"/></option>
				</c:forEach>
			</select>
			<span class="erreur">${ erreurs['auteurLivre'] }</span>
		</div>
	
		<div>
			<label for="titreLivre">Titre</label>
			<input type="text" id="titreLivre" name="titreLivre"/>
			<span class="erreur">${ erreurs['titreLivre'] }</span>
			
		</div>
		<div>
			<label for="nbPagesLivre">Nombre de pages</label>
			<input type="number" id="nbPagesLivre" name="nbPagesLivre"/>
			<span class="erreur">${ erreurs['nbPagesLivre'] }</span>
		</div>
		<div>
			<label for="categorieLivre">Catégorie</label>
			<input type="text" id="categorieLivre" name="categorieLivre"/>
			<span class="erreur">${ erreurs['categorieLivre'] }</span>
		</div>
		<div>
			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
		</div>
	</form>

</body>
</html>