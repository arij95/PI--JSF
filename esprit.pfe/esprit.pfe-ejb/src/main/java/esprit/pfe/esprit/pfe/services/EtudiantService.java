package esprit.pfe.esprit.pfe.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.pfe.esprit.pfe.persistence.Etudiant;




@Stateless
public class EtudiantService implements EtudiantServiceRemote{

	@PersistenceContext
	private EntityManager entityManager;
	public Etudiant getDonneEtu(int id){
		return entityManager.find(Etudiant.class,id);
	}
	public void annulation(int id,int ann,String ms){
		int query=entityManager.createQuery("UPDATE Etudiant SET annulation="+ann+", msg='"+ms+"' WHERE ID="+id).executeUpdate();   
	}
	
}
