<%@ include file="../template/header.jsp" %> 
<div style="width: 200px; margin: 0 auto  ">
	<legend>Menu Administrateur</legend>
	<fieldset>
		<form>
			<input type="button" value="Ajouter un utilisateur" onclick="window.location.href='http://localhost:8080/bibliotheque/addUser'" /> <br>
			<input type="button" value="Afficher la liste des utilisateur" onclick="window.location.href='http://localhost:8080/bibliotheque/listUser'" /> <br>
			<input type="button" value="Supprimer un utilisateur" onclick="window.location.href='http://localhost:8080/bibliotheque/removeUser'" /> <br>
			<br>
			<input type="button" value="Ajouter un livre" onclick="window.location.href='http://localhost:8080/bibliotheque/addLivre'" /> <br>
			<input type="button" value="Afficher la liste des livres" onclick="window.location.href='http://localhost:8080/bibliotheque/listLivre'" /> <br>
			<input type="button" value="Supprimer un livre" onclick="window.location.href='http://localhost:8080/bibliotheque/removeLivre'" /> <br>
			
		    <br>
		    <input type="button" value="detail d'un livre" onclick="window.location.href='http://localhost:8080/bibliotheque/showLivre'" /> <br>
	<!--		<input type="button" value="Afficher la liste des livres disponibles" onclick="window.location.href='http://localhost:8080/bibliotheque/listLivresDispo'" /> <br>
			<input type="button" value="Afficher la liste des livres reservés" onclick="window.location.href='http://localhost:8080/bibliotheque/listLivresReserv'" /> <br>
			<br> 
			<input type="button" value="Retour livre" onclick="window.location.href='http://localhost:8080/bibliotheque/removeLivre'" /> <br> -->
		    <input type="button" value="Logout" onclick="window.location.href='http://localhost:8080/bibliotheque/logout'"/> <br>
		</form>
	</fieldset>
</div>
<%@ include file="../template/footer.jsp" %>