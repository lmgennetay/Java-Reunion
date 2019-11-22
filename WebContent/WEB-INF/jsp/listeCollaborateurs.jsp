<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaCollaborateurDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Collaborateur" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<br>
<div class="col-lg-offset-3 col-lg-6" >
	<legend class="text-center">LISTE DES COLLABORATEURS</legend>
	<fieldset>
		<table class="table">
			<thead>
				<tr>
					<th scope="col" >Id</th>
					<th scope="col" >Nom</th>
					<th scope="col" >Prénom</th>
					<th scope="col" >Mail</th>
					<th scope="col" >Rôle</th>
					<th scope="col" ></th>
				</tr>
			</thead>
			<tbody>
			<% Collection<Collaborateur> collaborateurs = (Collection<Collaborateur>) request.getAttribute("collaborateurs"); %>
			<% for(Collaborateur collab : collaborateurs) { %>
				<tr>
					<th scope="row"><%= collab.getId() %></th>
					<td><%= collab.getNom() %></td>
					<td><%= collab.getPrenom() %></td>
					<td><%= collab.getMail() %></td>
					<td><%= collab.getRole().getNom() %></td>
					<td>
						<button type="button" class="btn btn-primary text-center" onclick="location.href = '/Bibliotheque/ShowCollaborateurServlet?id=<%= collab.getId() %>'">Show</button>
					</td>
				</tr>
			<% } %>
			</tbody>
		</table>
		<br><br>
		<div class="row">
			<div class="col-lg-2" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="history.back()"><i class="fa fa-angle-left"></i></button>
			</div>
			<div class="col-lg-10" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="location.href = '/Bibliotheque/addCollaborateurServlet'">Ajouter</button>
			</div>
		</div>
	</fieldset>
	</div>
	<%@ include file="../template/footer.jsp" %>