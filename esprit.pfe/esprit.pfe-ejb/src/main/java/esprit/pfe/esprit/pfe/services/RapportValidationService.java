package esprit.pfe.esprit.pfe.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Optionne;
import esprit.pfe.esprit.pfe.persistence.RapportValidation;

@Stateless
@LocalBean
public class RapportValidationService implements RapportValidationServiceRemote{

	@PersistenceContext
	private EntityManager entityManager;
	
	public RapportValidationService() {
		super();
	}
	
	public void creerapport(RapportValidation rp){
		entityManager.persist(rp);
	}
	
	public RapportValidation afficher(int id) {
		TypedQuery<RapportValidation> query=entityManager.createQuery("Select p from RapportValidation p Where etud_ID="+id,RapportValidation.class);
		//query.setParameter("id", id);
	
		RapportValidation f= new RapportValidation();
		f= query.getSingleResult();
		return f;
		
	}
	public RapportValidation afficherpourenc(int id) {
		TypedQuery<RapportValidation> query=entityManager.createQuery("Select p from RapportValidation p Where employerapport_ID="+id,RapportValidation.class);
		//query.setParameter("id", id);
	
		RapportValidation f= new RapportValidation();
		f= query.getSingleResult();
		return f;
		
	}
	
	public List<RapportValidation> afficherEnc(int id) {
		TypedQuery<RapportValidation> query=entityManager.createQuery("Select p from RapportValidation p Where employerapport_ID="+id,RapportValidation.class);
		//query.setParameter("id", id);
	
		List<RapportValidation> f =null;
		f= query.getResultList();
		return f;
		
	}
	public RapportValidation afficherpre(int id, int valide) {
		TypedQuery<RapportValidation> query=entityManager.createQuery("Select DISTINCT p from RapportValidation p Where  etud_ID= "+id+" and valide="+valide,RapportValidation.class);
		//query.setParameter("id", id);
	
		RapportValidation f= new RapportValidation();
		f=	query.getSingleResult();
		
		return f;
		
	}
	public List<RapportValidation> afficherprestudent(int id, int valide) {
		TypedQuery<RapportValidation> query=entityManager.createQuery("Select DISTINCT p from RapportValidation p join p.employerapport m2 Where  m2.idEmploye= :id and p.valide=:valide",RapportValidation.class);
		//query.setParameter("id", id);
	
		List<RapportValidation> f =null;
		f=	query.setParameter("id", id).setParameter("valide", valide).getResultList();
		
		return f;
		
	}
	
	public void delete(int  e){
		//entityManager.remove(e);
		entityManager.createQuery("DELETE FROM RapportValidation i WHERE i.id_rapport = :id").setParameter("id",e)
		.executeUpdate();
		}

	/*
	public void modifierPourEncadrant(RapportValidation p,int id, String remarque, String sign,int valide) {
		int query=entityManager.createQuery("UPDATE RapportValidation SET remarque='"+remarque+"',signature='"+sign+"',valide='"+valide+"',rapportdepot='"+p.getRapportdepot()+"WHERE id_rapport="+id).executeUpdate();   
			}*/
	public void modifadmin(RapportValidation e) {
		Query query = entityManager.createNativeQuery("UPDATE `RapportValidation` SET `remarque`=:a "
				+ ", `signature`=:b , `valide`=:c "
				+ " WHERE id_rapport=:l " );
		query
		.setParameter("a", e.getRemarque())
		.setParameter("b", e.getSignature())
		.setParameter("c", e.getValide())
		.setParameter("l", e.getId_rapport())
		.executeUpdate();
		
		
	}

	public void modifierPourEncadrant(RapportValidation em){
		entityManager.merge(em);
	}
}
