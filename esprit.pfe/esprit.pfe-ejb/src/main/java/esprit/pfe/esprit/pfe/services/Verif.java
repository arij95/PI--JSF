package esprit.pfe.esprit.pfe.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.user;




	@Stateless
	public  class Verif implements VerifRemote, VerifLocal{
		
		@PersistenceContext()
		private EntityManager entityManager;
		
		 public user verif(String email) {
			
			user u=null;
			 try{ Query query= entityManager
		     			.createQuery("SELECT e FROM user e  WHERE e.nom=:l ",user.class)
		     			.setParameter("l", email);
		            u = (user) query.getSingleResult();
		   
		       }
		       catch(Exception e){    	  }
		  		
		     
			 
		 
			 
			 return u;
		 }
		 public void turn1connected(int id) {
			 Query query = entityManager.createNativeQuery("UPDATE `user` SET `connected`=:a " );
				query
				.setParameter("a",0)
						
				.executeUpdate();
			 
			 
			 Query query1 = entityManager.createNativeQuery("UPDATE `user` SET `connected`=:a where `id`=:b " );
				query1
				.setParameter("a",1)
				.setParameter("b",id)
				.executeUpdate();
			 
		 }
		 public user userconnected() {
			 user u=null;
			 try{ Query query= entityManager
		     			.createQuery("SELECT e FROM user e  WHERE connected=:l ",user.class)
		     			.setParameter("l", 1);
		            u = (user) query.getSingleResult();
		   
		       }
		       catch(Exception e){    	  }
		  		
		     
			 
		 
			 
			 return u;
		 }
		 public Etudiant selectetudiantconnected(int id) {
			 Etudiant u=null;
			 try{ Query query= entityManager
		     			.createQuery("SELECT e FROM Etudiant e  WHERE ID=:l ",Etudiant.class)
		     			.setParameter("l", id);
		            u = (Etudiant) query.getSingleResult();
		   
		       }
		       catch(Exception e){    	  }
		  		
		     
			 
		 
			 
			 return u;
		 }
		 public Employe selectemployeconnected(int id) {
			 Employe u=null;
			 try{ Query query= entityManager
		     			.createQuery("SELECT e FROM Employe e  WHERE ID=:l ",Employe.class)
		     			.setParameter("l", id);
		            u = (Employe) query.getSingleResult();
		   
		       }
		       catch(Exception e){    	  }
		  		
		     
			 
		 
			 
			 return u;
		 }
		 /*
		  * public Employe selectemployetapped(String s) {
			 Employe u=null;
			 try{ Query query= entityManager
		     			.createQuery("SELECT e FROM Employe e  WHERE  	emailEmploye=:l ",Employe.class)
		     			.setParameter("l", s);
		            u = (Employe) query.getSingleResult();
		   
		       }
		       catch(Exception e){    	  }
		  		
		     
			 
		 
			 
			 return u;
		 }
		 public Etudiant selectetudianttapped(String s) {
			 Etudiant u=null;
			 try{ Query query= entityManager
		     			.createQuery("SELECT e FROM Etudiant e  WHERE  	emailEtudiant =:l ",Etudiant.class)
		     			.setParameter("l", s);
		            u = (Etudiant) query.getSingleResult();
		   
		       }
		       catch(Exception e){    	  }
		  		
		     
			 
		 
			 
			 return u;
		 }*/
		 
}
