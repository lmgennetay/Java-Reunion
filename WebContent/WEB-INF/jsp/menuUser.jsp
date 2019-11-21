<%@ include file="../template/header.jsp" %>
<div style="width: 200px; margin: 0 auto  ">
<legend>Acceuil</legend>
<fieldset>
	</form>	
		<input type="button" value="Afficher la liste des livres" onclick="window.location.href='http://localhost:8080/bibliotheque/listLivre'" /> <br>
<!--	<input type="button" value="Reserver un livre " onclick="window.location.href='http://localhost:8080/bibliotheque/reserver'" /> <br>
		<input type="button" value="Liste des livre a rendre" onclick="window.location.href='http://localhost:8080/bibliotheque/showMyBook'" /> <br> -->
		<br>
	    <input type="button" value="Logout" onclick="window.location.href='http://localhost:8080/bibliotheque/logout'"/> <br>
	</form>
</fieldset>
</div>
<%@ include file="../template/footer.jsp" %>