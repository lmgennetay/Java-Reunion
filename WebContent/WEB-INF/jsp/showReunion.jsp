<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaReunionDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Reunion" %>
<%@ page import="fr.cesi.bibliotheque.entity.Collaborateur" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<br>
<div class="col-lg-offset-4 col-lg-4" >
	<% Reunion reunion = (Reunion) request.getAttribute("reunion"); %>
	<legend> Information de la r�union n�<%= reunion.getId() %> </legend>
	        Objectif :<%= reunion.getObjectif() %><br/>
	        Date de la r�union :<%= reunion.getDate_reunion() %><br/>
	        R�f�rent :<%= reunion.getCollaborateurReferent().getNom() %> <%= reunion.getCollaborateurReferent().getPrenom() %><br/>
	        Compte rendu de la r�union :<%= reunion.getCompterendu() %><br>
	        <br>
	        Liste des participants :
			<table class="table">
				<thead >
					<tr >
						<th scope="col" >Nom</th>
						<th scope="col" >Pr�nom</th>
						<th scope="col" >R�le</th>
						<th scope="col" >Voir</th>
					</tr>
				</thead>
				<tbody>
					<% Collection<Collaborateur> collaborateurs = (Collection<Collaborateur>) reunion.getCollaborateursParticipants(); %>
	        		<% for(Collaborateur collab : collaborateurs) { %>
					<tr>
						<td><%= collab.getNom() %></td>
						<td><%= collab.getPrenom() %></td>
						<td><%= collab.getRole().getNom() %></td>
						<td><button type="button" class="btn btn-primary" onclick="location.href = '/Bibliotheque/ShowCollaborateurServlet?id=<%= collab.getId() %>'">Show</button></td>
					</tr>
				<% } %>
				</tbody>
			</table>
	        <br><br>
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