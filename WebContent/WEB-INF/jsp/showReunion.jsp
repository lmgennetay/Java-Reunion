<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaReunionDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Reunion" %>
<%@ page import="fr.cesi.bibliotheque.entity.Collaborateur" %>
<%@ page import="fr.cesi.bibliotheque.entity.Tache" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<br>
<div class="col-lg-offset-4 col-lg-4" >
	<% Reunion reunion = (Reunion) request.getAttribute("reunion"); %>
	<legend> Information de la r�union n�<%= reunion.getId() %> </legend>
	        <b>Objectif :</b> <%= reunion.getObjectif() %><br/>
	        <b>Date de la r�union :</b> <%= reunion.getDate_reunion() %><br/>
	        <b>R�f�rent :</b> <%= reunion.getCollaborateurReferent().getNom() %> <%= reunion.getCollaborateurReferent().getPrenom() %><br/>
	        <br/>
	        
	        <b>Compte rendu de la r�union :</b><br/><%= reunion.getCompterendu() %><br>
	        <br/>
	        <br/>
	        <h4 style="text-align:center;">Liste des participants</h4>
			<table class="table">
				<thead >
					<tr >
						<th scope="col" >Nom</th>
						<th scope="col" >Pr�nom</th>
						<th scope="col" >R�le</th>
						<th scope="col" >Actions</th>
					</tr>
				</thead>
				<tbody>
					<% Collection<Collaborateur> collaborateurs = (Collection<Collaborateur>) reunion.getCollaborateursParticipants(); %>
	        		<% for(Collaborateur collab : collaborateurs) { %>
					<tr>
						<td><%= collab.getNom() %></td>
						<td><%= collab.getPrenom() %></td>
						<td><%= collab.getRole().getNom() %></td>
						<td><button type="button" class="btn btn-sm btn-info" onclick="location.href = '/Bibliotheque/ShowCollaborateurServlet?id=<%= collab.getId() %>'">Voir</button></td>
					</tr>
				<% } %>
				</tbody>
			</table>
	        <br/>
	        <br/>
	        <h4 style="text-align:center;">Liste des taches de la r�union</h4>
			<table class="table">
				<thead >
					<tr >
						<th scope="col" >ID</th>
						<th scope="col" >Nom</th>
						<th scope="col" >Date d'�ch�ance</th>
						<th scope="col" >Actions</th>
					</tr>
				</thead>
				<tbody>
					<% Collection<Tache> taches = (Collection<Tache>) reunion.getTaches(); %>
	        		<% for(Tache task : taches) { %>
					<tr>
						<td><%= task.getId() %></td>
						<td><%= task.getNom() %></td>
						<td><%= task.getDate_echeance() %></td>
						<td><button type="button" class="btn btn-sm btn-info" onclick="location.href = '/Bibliotheque/showTache?id=<%= task.getId() %>'">Voir</button></td>
					</tr>
				<% } %>
				</tbody>
			</table>
			<div class="col-lg-12" >
				<button type="button" class="btn btn-primary btn-sm col-lg-12 text-center" onclick="location.href = '/Bibliotheque/addTache?reunion=<%= reunion.getId() %>'">Ajouter une tache</button>
			</div>
	        <br/>
	        <br/>
		<div class="row">
			<div class="col-lg-2" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="location.href = '/Bibliotheque/listeReunions'"><i class="fa fa-angle-left"></i></button>
			</div>
			<div class="col-lg-10" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="location.href = '/Bibliotheque/editReunions'">Modifier la r�union</button>
			</div>
		</div>
	</div>
	<%@ include file="../template/footer.jsp" %>