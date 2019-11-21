<%@ include file="../template/header.jsp" %> 
<%@ page import="fr.cesi.bibliotheque.entity.Livre" %>
<div style="width: 400px; margin: 0 auto">
	<legend> Fiche du livre </legend>
	<fieldset>
	   	<% Livre livre = (Livre) request.getAttribute("livre"); %>
	   		<label>Id </label><input name="id" value="<%= livre.getId() %>" /><br/>
	        <label>Titre </label><input name="titre" value="<%= livre.getTitre() %>"/><br/>
	        <label>Auteur </label><input name="auteur" value="<%= livre.getAuteur() %>"/><br/>
	        <label>Categorie </label><input name="categorie" value="<%= livre.getCategorie() %>"/><br>
	        <br>
	        <div style="text-align:center;">
	       		<button style="text-align:center;" type="submit">Ajouter un livre</button>
	        </div>
	        <br>
		<input style="float:right" type="button" value="Retour" onclick="history.back()" />
	</fieldset>
<div>
	
<%@ include file="../template/footer.jsp" %>
