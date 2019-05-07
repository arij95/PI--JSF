package esprit.pfe.esprit.pfe.services;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import esprit.pfe.esprit.pfe.persistence.FichePfe;





@Stateless
public class FicheService implements FicheServiceRemote{

	@PersistenceContext
	private EntityManager entityManager;
	
	public FicheService() {
		super();
	}
	
	
	public void creefiche(FichePfe pfe){
		entityManager.persist(pfe);
	}
	public FichePfe afficher(int id) {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select p from FichePfe p Where etudiant_ID="+id,FichePfe.class);
		//query.setParameter("id", id);
	
		FichePfe f= new FichePfe();
		f= query.getSingleResult();
		return f;
		
	}
	public void modifierMaj(FichePfe p,int id, String date) {
		int query=entityManager.createQuery("UPDATE FichePfe SET anneeFiche='"+date+"',categFiche='"+p.getCategFiche()+"',descriptionFiche='"+p.getDescriptionFiche()+"',ecoleFiche='"+p.getEcoleFiche()+"',entrepFiche='"+p.getEntrepFiche()+"',nouvfctFiche='"+p.getFctFiche()+"',motCleFiche='"+p.getMotCleFiche()+"',paysFiche='"+p.getPaysFiche()+"',nouvprobleFiche='"+p.getProbleFiche()+"',titreFiche='"+p.getTitreFiche()+"', version="+p.getVersion()+"WHERE ID="+id).executeUpdate();   
			}
	public void modifierMin(FichePfe p,int id, String date) {
		int query=entityManager.createQuery("UPDATE FichePfe SET anneeFiche='"+date+"',categFiche='"+p.getCategFiche()+"',descriptionFiche='"+p.getDescriptionFiche()+"',ecoleFiche='"+p.getEcoleFiche()+"',entrepFiche='"+p.getEntrepFiche()+"',motCleFiche='"+p.getMotCleFiche()+"',paysFiche='"+p.getPaysFiche()+"',titreFiche='"+p.getTitreFiche()+"',version="+p.getVersion()+" WHERE ID="+id).executeUpdate();   
			}
	public FichePfe getDonneFich(int id){
		return entityManager.find(FichePfe.class, id);
	}
	public ArrayList afficherPre(int id) {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select p from FichePfe p Where prevalid_ID="+id,FichePfe.class);
		//query.setParameter("id", id);
	
		ArrayList results= (ArrayList) query.getResultList();
		return results;
		
	}
	public ArrayList afficherRap(int id) {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select p from FichePfe p Where rapporteur_ID="+id,FichePfe.class);
		//query.setParameter("id", id);
	
		ArrayList results= (ArrayList) query.getResultList();
		return results;
		
	}
	public ArrayList afficherEnc(int id) {
		TypedQuery<FichePfe> query=entityManager.createQuery("Select p from FichePfe p Where encadrant_ID="+id,FichePfe.class);
		//query.setParameter("id", id);
	
		ArrayList results= (ArrayList) query.getResultList();
		return results;
		
	}
	public void preVal(int id, int etat) {
		int query=entityManager.createQuery("UPDATE FichePfe SET etatFiche="+etat+"WHERE ID="+id).executeUpdate();   
			}
	public void reject(FichePfe p,int id, String date,int etat) {
		int query=entityManager.createQuery("UPDATE FichePfe SET anneeFiche='"+date+"',categFiche='"+p.getCategFiche()+"',descriptionFiche='"+p.getDescriptionFiche()+"',ecoleFiche='"+p.getEcoleFiche()+"',entrepFiche='"+p.getEntrepFiche()+"',fctFiche='"+p.getFctFiche()+"',motCleFiche='"+p.getMotCleFiche()+"',paysFiche='"+p.getPaysFiche()+"',probleFiche='"+p.getProbleFiche()+"',titreFiche='"+p.getTitreFiche()+"', version="+p.getVersion()+", etatFiche="+etat+" WHERE ID="+id).executeUpdate();   
			}
	public FichePfe verif(int id) {
		FichePfe f=null;
		try{
		TypedQuery<FichePfe> query=entityManager.createQuery("Select p from FichePfe p Where etudiant_ID="+id,FichePfe.class);
		//query.setParameter("id", id);
	
		
		f= query.getSingleResult();
		
		}
    catch(Exception e){    	  }
		return f;
		
	}
	public void noteEnca(int id,float note) {
		int query=entityManager.createQuery("UPDATE FichePfe SET noteEnc="+note+" WHERE ID="+id).executeUpdate();   
			}
	public void noteRapp(int id,float note) {
		int query=entityManager.createQuery("UPDATE FichePfe SET noteRap="+note+" WHERE ID="+id).executeUpdate();   
			}
}
