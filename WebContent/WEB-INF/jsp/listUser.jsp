<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.UserDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<div style="width: 600px; margin: 0 auto  ">
<legend> Liste des utilisateurs </legend>
	<fieldset>
		<table>
			<thead >
				<tr >
					<th width="50px" style="border-bottom: 1px solid #000" >Id</th>
					<th width="300px" style="border-bottom: 1px solid #000" >Nom</th>
					<th width="200px" style="border-bottom: 1px solid #000" >Prénom</th>
					<th width="100px" style="border-bottom: 1px solid #000" >Rôle</th>
				</tr>
			</thead>
			<tbody>
			<% Collection<User> users = (Collection<User>) request.getAttribute("users"); %>
			<% for(User utilisateur : users) { %>
				<tr>
					<th><%= utilisateur.getId() %></th>
					<th><%= utilisateur.getNom() %></th>
					<th><%= utilisateur.getPrenom() %></th>
					<th><%= utilisateur.getRole() %></th>
				</tr>
			<% } %>
			</tbody>
			<tfooter >
				<tr >
					<th width="50px"  style="border-bottom: 1px solid #000" ></th>
					<th width="300px" style="border-bottom: 1px solid #000" ></th>
					<th width="200px" style="border-bottom: 1px solid #000" ></th>
					<th width="100px" style="border-bottom: 1px solid #000" ></th>
				</tr>
			</tfooter>
		</table>
		<br>
		<input style="float:right" type="button" value="Retour" onclick="history.back()" />
	</fieldset>
	</div>
	<%@ include file="../template/footer.jsp" %>