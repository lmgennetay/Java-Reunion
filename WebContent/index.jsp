<%@ include file="WEB-INF/template/header.jsp" %>
<div style="width: 200px; margin: 0 auto  ">
<legend>Connexion à CESI - BIBLIOBOX </legend>
	<fieldset>
		<form method="post" action=login>
			<label>Identifiant </label><input name="identifiant"/><br/><br/>
	        <label>Mot de passe </label><input name="password"/><br/>
	        <br>
	        <button style="float: right" type="submit">Connexion</button>	
        </form>       
	</fieldset>
</div> 
<%@ include file="WEB-INF/template/footer.jsp" %>