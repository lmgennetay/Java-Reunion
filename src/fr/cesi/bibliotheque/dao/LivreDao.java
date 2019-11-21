package fr.cesi.bibliotheque.dao;

import java.util.Collection;

import fr.cesi.bibliotheque.entity.Livre;

public interface LivreDao {
	public void addLivre(Livre livre);	
	public void updateLivre(Livre livre);
	public Livre findLivreById(Long id);
	public Collection<Livre> getAllLivres();
	public void removeLivre(Livre livre);
	public void removeLivre(Long id);
	public int getLivreIndexById(Long id);
}
