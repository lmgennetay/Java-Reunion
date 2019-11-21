package fr.cesi.bibliotheque.model;

public class UnknownLivreException extends Exception{
	public UnknownLivreException(Long id) {
		super("Le livre avec id=" + id + " n'existe pas.");
	}
}
