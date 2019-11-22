<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaReunionDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Reunion" %>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaCollaborateurDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Collaborateur" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 

<div style="width: 400px; margin: 0 auto">
	<legend> Ajouter une Tache </legend>
	<fieldset>
	   	<form method="post" action=addTacheServlet>
	        <label>Nom </label><input type="text" name="nom"/><br/>
	        <label>Date Echeance </label><input type="date" name="date_echeance"/><br/>
	        <label>Description </label><input type="text" name="description"/><br>
	        	      	  	        
	        <% Reunion reunion = (Reunion) request.getAttribute("reunion"); %>
	        <label>id</label><input name="nom" disabled/><%= reunion.getId() %><br/>
	        <label>Objectif</label><input name="date_echeance" disabled/><%= reunion.getObjectif() %><br/>
	        <label>Date reunion</label><input name="date_reunion" disabled/><%= reunion.getDate_reunion() %><br>
	        
	        <select name="listeCollaborateurs" multiple> 
	        	<% List<Collaborateur> listeCollaborateurs = reunion.getCollaborateursParticipants(); %>
				<% for(Collaborateur c : listeCollaborateurs) { %>
					<option value="<%= c.getId() %>"> <%= c.getNom() + " " + c.getPrenom() %> </option>
				<% } %> 
	        </select> 
	        	        	        	        	            
	        <div style="text-align:center;">
	       		<button style="text-align:center;" type="submit">Ajouter une tache</button>
	        </div>
	        <br>
		<input style="float:right" type="button" value="Retour" onclick="history.back()" />
	   	</form>
	</fieldset>
<div>
<%@ include file="../template/footer.jsp" %>   
	