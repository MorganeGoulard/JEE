<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier livre</title>
</head>
<body>

	<c:import url="/WEB-INF/menu.jsp" />

		<form method="post" action="<c:url value="/ModifierLivre"><c:param name="id" value="${ livre.id }" /></c:url>">
		<div>
			<label for="auteurLivre">Auteur</label>
			<select id="auteurLivre" name="auteurLivre">
				<c:forEach items="${ auteurs }" var="auteur">
					<option value="<c:out value="${ auteur.id }"/>" ${ auteur.id == livre.auteur.id ? "selected" : "" }><c:out value="${ auteur.prenom }"/> <c:out value="${ auteur.nom }"/></option>
				</c:forEach>
			</select>
		</div>
	
		<div>
			<label for="titreLivre">Titre</label>
			<input type="text" id="titreLivre" name="titreLivre" value="<c:out value="${ livre.titre }" /> " />
		</div>
		<div>
			<label for="nbPagesLivre">Nombre de pages</label>
			<input type="text" id="nbPagesLivre" name="nbPagesLivre" value="<c:out value="${ livre.nbPages }" /> " />
		</div>
		<div>
			<label for="categorieLivre">Catégorie</label>
			<input type="text" id="categorieLivre" name="categorieLivre"  value="<c:out value="${ livre.categorie }" /> " />
		</div>
		<div>
			<input type="submit" value="Modifier" />
			<input type="reset" value="Remettre à zéro" />
		</div>
	</form>

</body>
</html>