<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaCollaborateurDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Collaborateur" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<br>
<div class="col-lg-offset-4 col-lg-4" >
	<legend class="text-center">AJOUTER UNE RÉUNION</legend>
	<fieldset>
		<form method="post" action=setReunion>
			<div class="form-group">
		    <label for="date_reunion">Date</label>
		    <input type="date" class="form-control" name="date_reunion" id="date_reunion" placeholder="">
		  </div>
		  <div class="form-group">
		    <label for="lieu">Lieu</label>
		    <input type="text" class="form-control" name="lieu" id="lieu" placeholder="Lieu">
		  </div>
		  <div class="form-group">
		    <label for="objectif">Objectif</label>
		    <input type="text" class="form-control" name="objectif" id="objectif" placeholder="objectif">
		  </div>
		  <div class="form-group">
		    <label for="compterendu">Compte Rendu</label>
		    <textarea class="form-control" name="compterendu" id="compterendu" placeholder="Compte rendu..."></textarea>
		  </div>
		  <div class="form-group">
		    <label for="referent">Référent</label>
	          <select name="referent"  class="browser-default custom-select">
	            <% Collection<Collaborateur> collaborateurs = (Collection<Collaborateur>) request.getAttribute("Collaborateurs"); %>
				<% for(Collaborateur c : collaborateurs) { %>
					<option value="<%= c.getId() %>"> <%= c.getPrenom() %> <%= c.getNom() %> </option>
				<% } %> 
	          </select>
          </div>
		  <div class="form-group">
		    <label for="participants">Participants</label>
	          <select name="participants"  class="browser-default custom-select" multiple>
				<% for(Collaborateur c : collaborateurs) { %>
					<option value="<%= c.getId() %>"> <%= c.getPrenom() %> <%= c.getNom() %> </option>
				<% } %> 
	          </select>
          </div>
  
		  <div class="row">
			<div class="col-lg-2" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="history.back()"><i class="fa fa-angle-left"></i></button>
			</div>
				<div class="col-lg-10" >
					<button type="submit" class="btn btn-primary col-lg-12 text-center">Ajouter</button>
				</div>
			</div>
  		</form>
	</fieldset>
</div>
<%@ include file="../template/footer.jsp" %>