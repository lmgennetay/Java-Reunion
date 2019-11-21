<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.JpaRoleDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Role" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<div style="width: 600px; margin: 0 auto  ">
<legend> Liste des livres </legend>
	<fieldset>
		<table>
			<thead >
				<tr >
					<th width="50px" style="border-bottom: 1px solid #000" >Id</th>
					<th width="300px" style="border-bottom: 1px solid #000" >Titre</th>
					<th width="200px" style="border-bottom: 1px solid #000" >Auteur</th>
					<th width="100px" style="border-bottom: 1px solid #000" >Categorie</th>
					<th width="100px" style="border-bottom: 1px solid #000" >Reservé</th>
				</tr>
			</thead>
			<tbody>
			<% Collection<Role> roles = (Collection<Role>) request.getAttribute("roles"); %>
			<% for(Role rule : roles) { %>
				<tr>
					<th><%= rule.getId() %></th>
					<th><%= rule.getNom() %></th>
				</tr>
			<% } %>
			</tbody>
			<tfooter >
				<tr >
					<th width="50px"  style="border-bottom: 1px solid #000" ></th>
					<th width="300px" style="border-bottom: 1px solid #000" ></th>
					<th width="200px" style="border-bottom: 1px solid #000" ></th>
					<th width="100px" style="border-bottom: 1px solid #000" ></th>
					<th width="100px" style="border-bottom: 1px solid #000" ></th>
				</tr>
			</tfooter>
		</table>
		<br>
		<input style="float:right" type="button" value="Retour" onclick="history.back()" />
	</fieldset>
	</div>
	<%@ include file="../template/footer.jsp" %>