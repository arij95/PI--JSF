package esprit.pfe.esprit.pfe.services;




import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;










@Stateless
public  class ExistEmail implements ExistEmailRemote, ExistEmailLocal{

	@PersistenceContext()
	private EntityManager entityManager;
	
	
	

	
	
	 public Etudiant exist(String adresse) {
		
		 Etudiant s = null;
       try{ Query query= entityManager
     			.createQuery("SELECT e FROM Etudiant e  WHERE"
     					+ " emailEtudiant =:l ",Etudiant.class)
     			.setParameter("l", adresse);
           s = (Etudiant) query.getSingleResult();
          if (s == null){
        	  s.setIdEtudiant(0);;
       	   s.setAutorisationEtudiant(-1);;
       	   s.setEnregistrement(-1);
       	   s.setClassenum(0);
       	   s.setEmailEtudiant("");
       	   s.setPasswordEtudiant("");
       	   s.setNomEtudiant("");
       	   s.setPrenomEtudiant("");
          }
       }
       catch(Exception e){
    	  
    	   
     	  ;}
       return s;
      
}
	 
	 public void mdp(String psw,int id) {
		 
		Query query = entityManager.createNativeQuery("UPDATE `Etudiant` SET `passwordEtudiant`=:a"
				+ " WHERE ID=:l " );
		query
		.setParameter("a", psw)
		.setParameter("l", id)
		
		.executeUpdate();
		 
	 }
	 public void turn1(int id) {
		 
			Query query = entityManager.createNativeQuery("UPDATE `Etudiant` SET `enregistrement`=1"
					+ " WHERE ID=:l " );
			query
			
			.setParameter("l", id)
			
			.executeUpdate();
			 
		 }
	 public void ajouteretudiantuser(String username,String mdp) {
			Query query = entityManager.createNativeQuery("INSERT into user (username,mdp,role,connected)"+
			" Values ( :a ,:b,:c,:d)",Employe.class);
				
					query
					.setParameter("a",username )
					.setParameter("b",mdp)
					.setParameter("c",0)
					.setParameter("d",0)
				
					.executeUpdate();
			
			
		}
}
