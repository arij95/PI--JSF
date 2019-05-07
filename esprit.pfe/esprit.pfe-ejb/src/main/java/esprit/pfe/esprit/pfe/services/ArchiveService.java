package esprit.pfe.esprit.pfe.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import esprit.pfe.esprit.pfe.persistence.Archive;



@Stateless
public class ArchiveService implements ArchiveServiceRemote{
	
	@PersistenceContext
	private EntityManager entityManager;

	public void creeArchive(Archive ar){
		entityManager.persist(ar);
	}
}
