<%@ include file="../template/header.jsp" %>
<div style="width: 400px; margin: 0 auto">
	<legend> Ajouter un membre </legend>
	<fieldset>
	   	<form method="post" action=addUser>
	        <label>Nom </label><input name="nom"/><br/>
	        <label>Prénom </label><input name="prenom"/><br/>
	        <label>Mot de passe </label><input name="password"/><br/>
	        <label>Type </label><input name="type"/><br>
	        <br>
       		<span>rôle : administrateur / utilisateur</span>
       		<br><br>
	        <div style="text-align:center;">
	        <input style="float:left;margin-left: 60px" type="button" value="Retour" onclick="history.back()" />
	        <button style="text-align:right" type="submit">Ajouter un utilisateur</button>
	        <br>
	        </div>
	   	</form>
	</fieldset>
<div>
<%@ include file="../template/footer.jsp" %>   
	