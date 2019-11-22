<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaCollaborateurDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Collaborateur" %>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaRoleDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Role" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<br>
<div class="col-lg-offset-4 col-lg-4" >
	<legend class="text-center">AJOUTER UN COLLABORATEUR</legend>
	<fieldset>
		  <% Collaborateur collaborateur = (Collaborateur) request.getAttribute("collaborateur"); %>
		  <form method="post"  action=updateCollaborateurServlet>
			  <div class="hidden form-group">
			    <label for="nom">id</label>
			    <input type="text" class="form-control" name="id" id="id" placeholder="id" value="<%= collaborateur.getId() %>">
			  </div>
			  <div class="form-group">
			    <label for="nom">Nom</label>
			    <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom" value="<%= collaborateur.getNom() %>">
			  </div>
			  <div class="form-group">
			    <label for="prenom">Prénom</label>
			    <input type="text" class="form-control" name="prenom" id="prenom" placeholder="Prénom" value="<%= collaborateur.getPrenom() %>">
			  </div>
			  <div class="form-group">
			    <label for="email">Email</label>
			    <input type="email" class="form-control" name="email" id="email" placeholder="Email"value="<%= collaborateur.getMail() %>">
			  </div>
			  <div class="form-group">
			    <label for="role">Rôle</label>
		          <select name="role"  class="browser-default custom-select">
		            <% Collection<Role> roles = (Collection<Role>) request.getAttribute("roles"); %>
					<% for(Role r : roles) { %>
						<% if ( r.getId()  == collaborateur.getRole().getId() ) {  %>
							<option selected value="<%= r.getId() %>"> <%= r.getNom() %> </option>				
						<% }else{ %> 
						<option value="<%= r.getId() %>"> <%= r.getNom() %> </option>
						<% } %>
					<% } %> 
		          </select>
	          </div>
	          <br>
  			<div class="row">
				<div class="col-lg-2" >
					<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="history.back()"><i class="fa fa-angle-left"></i></button>
				</div>
				<div class="col-lg-10">
					<button type="submit" class="btn btn-primary col-lg-12 text-center">Modifier</button>
				</div>
			</div>
		<br>
			<div class="row">
				<div class="col-lg-2" >
				</div>
				
				<div class="col-lg-10" >
					<button type="button" class="btn btn-danger col-lg-12 text-center" onclick="location.href = '/Bibliotheque/removeCollaborateurServlet?id=<%= collaborateur.getId() %>'">Supprimer</button>
				</div>
			</div>
		</form>
	</fieldset>
</div>
<%@ include file="../template/footer.jsp" %>