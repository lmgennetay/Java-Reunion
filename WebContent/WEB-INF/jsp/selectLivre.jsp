<%@ include file="../template/header.jsp" %>
<div style="width: 400px; margin: 0 auto">
<legend> Selection d'un livre </legend>
	<fieldset>
		<form method="post" action=showLivre>
			<label>Id du livre </label><input name="id"/><br/>
			<br>
		    <br>
		    <button style="float: right" type="submit">Afficher</button>
		    <br>
		     <br>
		     <input type="button" value="Retour au menu" 
				onclick="window.location.href='http://localhost:8080/bibliotheque'"
			/>
		</form>
	</fieldset>
</div>
<%@ include file="../template/footer.jsp" %>