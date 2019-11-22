<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaReunionDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Reunion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<br>
<div class="col-lg-offset-4 col-lg-4" >
	<legend class="text-center">LISTE DES RÉUNIONS</legend>
	<fieldset>
		<table class="table">
			<thead >
				<tr >
					<th scope="col" >Id</th>
					<th scope="col" >Date de la réunion</th>
					<th scope="col" >Lieu</th>
					<th scope="col" >Objectif</th>
					<th scope="col" >Collaborateur Référent</th>
					<th scope="col" ></th>
				</tr>
			</thead>
			<tbody>
			<% Collection<Reunion> reunions = (Collection<Reunion>) request.getAttribute("reunions"); %>
			<% for(Reunion reunion : reunions) { %>
				<tr>
					<th scope="row"><%= reunion.getId() %></th>
					<td><%= reunion.getDate_reunion() %></td>
					<td><%= reunion.getLieu() %></td>
					<td><%= reunion.getObjectif() %></td>
					<td><%= reunion.getCollaborateurReferent().getNom() %> <%= reunion.getCollaborateurReferent().getPrenom() %></td>
					<td><button type="button" class="btn btn-primary text-center" onclick="location.href = '/Bibliotheque/showReunion?id=<%= reunion.getId() %>'">Show</button></td>
				</tr>
			<% } %>
			</tbody>
		</table>
		<br><br>
		<div class="row">
			<div class="col-lg-2" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="location.href = '/Bibliotheque/'"><i class="fa fa-angle-left"></i></button>
			</div>
			<div class="col-lg-10" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="location.href = '/Bibliotheque/setReunion'">Ajouter une réunion</button>
			</div>
		</div>
	</fieldset>
	</div>
	<%@ include file="../template/footer.jsp" %>