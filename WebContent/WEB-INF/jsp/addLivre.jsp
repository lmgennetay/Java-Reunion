<%@ include file="../template/header.jsp" %>
<div style="width: 400px; margin: 0 auto">
	<legend> Ajouter un livre </legend>
	<fieldset>
	   	<form method="post" action=addLivre>
	        <label>Titre </label><input name="titre"/><br/>
	        <label>Auteur </label><input name="auteur"/><br/>
	        <label>Categorie </label><input name="categorie"/><br>
	        <br>
	        <div style="text-align:center;">
	       		<button style="text-align:center;" type="submit">Ajouter un livre</button>
	        </div>
	        <br>
		<input style="float:right" type="button" value="Retour" onclick="history.back()" />
	   	</form>
	</fieldset>
<div>
<%@ include file="../template/footer.jsp" %>   
	