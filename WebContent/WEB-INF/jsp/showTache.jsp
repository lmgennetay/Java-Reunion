<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.cesi.bibliotheque.dao.jpa.JpaTacheDao" %>
<%@ page import="fr.cesi.bibliotheque.entity.Tache" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ include file="../template/header.jsp" %> 
<br>
<div class="col-lg-offset-4 col-lg-4" >
	<% Tache tache = (Tache) request.getAttribute("tache"); %>
	<legend> Information de la tache n�<%= tache.getId() %> </legend>
	        <b>Nom :</b> <%= tache.getNom() %><br/>
	        <b>Date �ch�ance :</b> <%= tache.getDate_echeance() %><br/>
	        <b>Tache concernant la r�union :</b> <%= tache.getReunion().getObjectif() %><br/>
	        <br/>
	        <b>Description de la tache :</b><br/><%= tache.getDescription() %><br>
	        <br><br>
		<div class="row">
			<div class="col-lg-2" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="history.back()"><i class="fa fa-angle-left"></i></button>
			</div>
			<div class="col-lg-10" >
				<button type="button" class="btn btn-primary col-lg-12 text-center" onclick="location.href = '/Bibliotheque/editTache?id="<%= tache.getId() %>"'">Modifier la tache</button>
			</div>
		</div>
	</div>
	<%@ include file="../template/footer.jsp" %>