package esprit.pfe.esprit.pfe.services;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.pfe.esprit.pfe.persistence.Convention;
import esprit.pfe.esprit.pfe.persistence.FichePfe;;



@Stateless
public class ConventionService implements ConventionServiceRemote{

	@PersistenceContext
	private EntityManager entityManager;
	
	public void ajoutConvnetion(Convention c){
		entityManager.persist(c);
	}
	public Convention get(int id) {
		Convention c=null;
		 try{
		Query query=entityManager.createQuery("Select p from Convention p Where etudiant_ID="+id,Convention.class);
		c=(Convention) query.getSingleResult();
		 }
	       catch(Exception e){    	  }
		return c;
		/*Query query=(Query) entityManager.createQuery("Select p from Convention p Where etudiant_ID="+id,Convention.class);
		//query.setParameter("id", id);
	
		Convention c= new Convention();
		c= (Convention) query.getSingleResult();
		return c;*/
		
	}
}
