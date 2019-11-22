<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaRoleDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Role" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<br>
<div class="col-lg-offset-4 col-lg-4" >
	<legend class="text-center">AJOUTER UN COLLABORATEUR</legend>
	<fieldset>
		<form method="post" action=addCollaborateur>
		  <div class="form-group">
		    <label for="nom">Nom</label>
		    <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom">
		  </div>
		  <div class="form-group">
		    <label for="prenom">Prénom</label>
		    <input type="text" class="form-control" name="prenom" id="prenom" placeholder="Prénom">
		  </div>
		  <div class="form-group">
		    <label for="email">Email</label>
		    <input type="email" class="form-control" name="email" id="email" placeholder="Email">
		  </div>
		   <div class="form-group">
		    <label for="role">Rôle</label>
		    <input type="role" class="form-control" name="role" id="role" placeholder="Role">
		  </div>
		  
		  <label>Rôle :</label> 
          <select name="role">
            <% Collection<Role> roles = (Collection<Role>) request.getAttribute("roles"); %>
			<% for(Role r : roles) { %>
				<option value="<%= r.getId() %>"> <%= r.getNom() %> </option>
			<% } %> 
          </select>
  
		  <div class="row">
			<div class="col-lg-2" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="history.back()"><i class="fa fa-angle-left"></i></button>
			</div>
				<div class="col-lg-10" >
					<button type="submit" class="btn btn-primary col-lg-12 text-center">Ajouter un collaborateur</button>
				</div>
			</div>
  		</form>
	</fieldset>
</div>
<%@ include file="../template/footer.jsp" %>