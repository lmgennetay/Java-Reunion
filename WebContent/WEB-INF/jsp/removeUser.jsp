<%@ include file="../template/header.jsp" %>
<%@ page import="fr.cesi.bibliotheque.entity.Livre" %>
<%@ page import="fr.cesi.bibliotheque.dao.LivreDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>

<div style="width: 600px; margin: 0 auto  ">
	<form method="post" action="removeLivre">
		<legend> Effacer un Livre</legend>
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
				<% Collection<Livre> livres = (Collection<Livre>) request.getAttribute("livres"); %>
				<% if (livres != null) { %>
					<% for(Livre book : livres) { %>
						<tr>
							<th><%= book.getId() %></th>
							<th><%= book.getTitre() %></th>
							<th><%= book.getAuteur() %></th>
							<th><%= book.getCategorie() %></th>
							<% if ( book.getReserv() == true  ){ %>
								<th><input type="checkbox" name="reserv" checked/> </th>
							<% } else {%>
								<th><input type="checkbox" name="reserv" /> </th>
							<% } %>
						</tr>
					<% } %>
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
	      <label>Id du livre a effacer </label><input name="id"/><br>
	      <br>
	      <br>
	      <button style="float: left" type="submit">effacer</button> <br>
	      <br>
	      <input style="float:right" type="button" value="Retour" onclick="history.back()" />
	   </fieldset>
	</form>
</div>
<%@ include file="../template/footer.jsp" %>   