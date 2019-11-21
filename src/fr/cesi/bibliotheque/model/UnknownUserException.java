package fr.cesi.bibliotheque.model;

public class UnknownUserException extends Exception{
	public UnknownUserException(Long id) {
		super("L'utilisateur avec id=" + id + " n'existe pas.");
	}
}
