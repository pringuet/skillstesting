package tech.positivethinking;

import java.util.ArrayList;
import java.util.List;

/**
 * Partitionnment d'une liste en sous-listes. 
 * @author Pascal Ringuet
 */
public class SkillsTesting {

	/**
	 * Cette méthode partitionne une liste en sous-liste de taille <b>taille</b>.
	 * @param liste La liste à partitionner.
	 * @param taille La taille des partitions.
	 * @return Une liste composée de sous-liste de taille <b>taille</b>
	 */
	public List<List<Integer>> partition(final List<Integer> liste, final int taille) {
		
		if (liste == null || liste.size() == 0) {
			throw new IllegalArgumentException("La liste doit �tre valoris�e");
		}
		
		if (taille <= 0) {
			throw new IllegalArgumentException("La taille des sous-listes doit �tre strictement positive");
		}
		
		if (liste.size() < taille) {
			throw new IllegalArgumentException("La taille de la liste est inf�rieure � la taille des sous-listes");
		}
		
		final List<Integer> listeOriginale = new ArrayList<>(liste);
		List<List<Integer>> listeResultante = new ArrayList<List<Integer>>();
		while (listeOriginale.size() > 0) {
			List<Integer> subList;
			if (listeOriginale.size() >= taille) {
				subList = listeOriginale.subList(0, taille);
			} else {
				subList = listeOriginale.subList(0, listeOriginale.size());
			}
			listeResultante.add(new ArrayList<Integer>(subList));
			listeOriginale.removeAll(subList);
		}
		return listeResultante; 
	}
}
