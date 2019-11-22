<%@ include file="WEB-INF/template/header.jsp" %>
<br>
<div class="col-lg-offset-4 col-lg-4" >
	<legend class="text-center">Gestionnaire de réunions</legend>
	<fieldset>
	
	<div class="row">
		<div class="col-lg-offset-3 col-lg-6" >
			<button  type="button" class="btn btn-primary col-lg-12 text-center" onclick="location.href = '/Bibliotheque/listeReunions'">Gestion des réunions</button>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-lg-offset-3 col-lg-6" >
			<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="location.href = '/Bibliotheque/listCollaborateurServlet'">Gestion des collaborateurs</button>
		</div>
	</div>

	</fieldset>
</div>

<%@ include file="WEB-INF/template/footer.jsp" %>