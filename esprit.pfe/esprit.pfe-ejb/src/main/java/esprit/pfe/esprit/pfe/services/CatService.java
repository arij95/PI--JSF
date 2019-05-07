package esprit.pfe.esprit.pfe.services;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import esprit.pfe.esprit.pfe.persistence.Categorie;





@Stateless
public class CatService implements CatServiceRemote{

	@PersistenceContext
	private EntityManager entityManager;

	public ArrayList reupCat() {
		TypedQuery<Categorie> query=entityManager.createQuery("Select p from Categorie p",Categorie.class);
		//query.setParameter("id", id);
		ArrayList results= (ArrayList) query.getResultList();
		
		
		return results;
	}
	public void ajoutCat(Categorie c){
		entityManager.persist(c);
	}
}
