package esprit.pfe.esprit.pfe.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import esprit.pfe.esprit.pfe.persistence.ClasseStudent;
import esprit.pfe.esprit.pfe.persistence.Departement;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.Optionne;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.persistence.SiteUniversity;
import esprit.pfe.esprit.pfe.persistence.user;
import esprit.pfe.esprit.pfe.util.GenericDAO;







@Stateless
@LocalBean
public class PlateformeService extends GenericDAO<Plateforme>  implements PlateformeServiceLocal, PlateformeServiceRemote{
	
	
	@PersistenceContext
	private EntityManager entityManager;

	public PlateformeService() {
		super(Plateforme.class);
	}
	
	public Plateforme Plateformeuser(int id){
		TypedQuery<Plateforme> query=entityManager.createQuery("SELECT e FROM Plateforme e JOIN e.employe s WHERE s.idEmploye = :id",Plateforme.class);
		//query.setParameter("id", id);
		
		Plateforme aa =null;
		aa=	query.setParameter("id", id).getSingleResult();
		
	//List<Archive>f=query.getResultList();
		//Archive f= new Archive();
		//f= query.getResultList();
		return aa;
		
	}
	
	@Override
	public void addinterview(Plateforme i) {

		entityManager.merge(i);
		/*Query query = entityManager.createNativeQuery("INSERT into plateforme (university , site ,year, image,employe_ID)"+
		" Values ( :a ,:b, :c, :d,:t)",Plateforme.class);
	
		query
		.setParameter("a", i.getUniversity())
		.setParameter("b", i.getSite())
		.setParameter("c", i.getYear())
		.setParameter("d", i.getImage())
		.setParameter("t",i.getEmploye().getIdEmploye())
		
		.executeUpdate();
*/
	}

	public void addstudent(Etudiant e) {

		entityManager.merge(e);
		
	}
	public void ajouteretuduser(Etudiant e) {
		Query query = entityManager.createNativeQuery("INSERT into user (nom,  	prenom , 	username ,  "
				+ "	role,ecoleEmploye,connected,idrole)"+
		" Values ( :a ,:b, :c,:t,:e,:f,:g)",user.class);
			
				query
				.setParameter("a",e.getNomEtudiant())
				.setParameter("b", e.getPrenomEtudiant())
				.setParameter("c",e.getUserNameEtudiant())
				
				.setParameter("t",0)
				.setParameter("e",e.getEcoleEtudiant())
				.setParameter("f",0)
				.setParameter("g",e.getIdEtudiant())
				
				.executeUpdate();
		
		
	}
	public void ajouterempuser(Employe e) {
		Query query = entityManager.createNativeQuery("INSERT into user (nom,  	prenom , 	username ,  "
				+ "	role,ecoleEmploye,connected,idrole)"+
		" Values ( :a ,:b, :c,:t,:e,:f,:g)",user.class);
			
				query
				.setParameter("a",e.getNomEmploye())
				.setParameter("b", e.getPrenomEmploye())
				.setParameter("c",e.getUserNameEmploye())
				
				.setParameter("t",0)
				.setParameter("e",e.getEcoleEmploye())
				.setParameter("f",0)
				.setParameter("g",e.getIdEmploye())
				
				.executeUpdate();
		
		
	}
	public Employe selectemployetapped(String s) {
		 Employe u=null;
		 try{ Query query= entityManager
	     			.createQuery("SELECT e FROM Employe e  WHERE  	prenomEmploye=:l ",Employe.class)
	     			.setParameter("l", s);
	            u = (Employe) query.getSingleResult();
	   
	       }
	       catch(Exception e){    	  }
	  		
	     
		 
	 
		 
		 return u;
	 }
	 public Etudiant selectetudianttapped(String s) {
		 Etudiant u=null;
		 try{ Query query= entityManager
	     			.createQuery("SELECT e FROM Etudiant e  WHERE  	userNameEtudiant=:l ",Etudiant.class)
	     			.setParameter("l", s);
	            u = (Etudiant) query.getSingleResult();
	   
	       }
	       catch(Exception e){    	  }
	  		
	     
		 
	 
		 
		 return u;
	 }
	//private EntityManager em;

	
	public List<Etudiant> findAllStudent(String ecole) {
		
		
		TypedQuery<Etudiant> query=entityManager.createQuery("Select DISTINCT e from Etudiant e where e.ecoleEtudiant=:ecole",Etudiant.class);
		//query.setParameter("id", id);
		List<Etudiant>  f=query.setParameter("ecole", ecole).getResultList();
		
		
		return f;
	
	}

	public void addsite(SiteUniversity e) {
		
		entityManager.merge(e);
		
		
	}
	

public List<SiteUniversity> findAllSite(int id) {
	TypedQuery<SiteUniversity> query=entityManager.createQuery("SELECT DISTINCT e FROM SiteUniversity e JOIN e.plateforme s WHERE s.id_plateforme = :id",SiteUniversity.class);
	
	List<SiteUniversity> aa =null;
	aa=	query.setParameter("id", id).getResultList();
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return aa;
}

public Integer findAllSitep() {
	TypedQuery<Integer> query=entityManager.createQuery("Select a.Plateforme.id_plateforme from SiteUniversity a",Integer.class);
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return query.getSingleResult();
}

public List<SiteUniversity> findSitefordep() {
	
	
	TypedQuery<SiteUniversity> query=entityManager.createQuery("Select siteName from SiteUniversity e ",SiteUniversity.class);
	//query.setParameter("id", id);
	List<SiteUniversity>  f=query.getResultList();
	
	
	return f;

}

@Override
public void deleteSite(int e){
	//entityManager.remove(e);
	entityManager.createQuery("DELETE FROM SiteUniversity i WHERE i.id = :id").setParameter("id",e)
	.executeUpdate();
}

public void adddepartment(Departement e) {
	
	entityManager.merge(e);
	
	
}
	
public List<Departement> findDep(int id) {
	
	
	TypedQuery<Departement> query=entityManager.createQuery("select DISTINCT m2 from Departement m2 join m2.sitee p2 join p2.plateforme u2 where u2.id_plateforme = :id",Departement.class);
	//query.setParameter("id", id);
	
	List<Departement> aa =null;
	aa=	query.setParameter("id", id).getResultList();
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return aa;

}
public List<Departement> findDepp() {
	
	
	TypedQuery<Departement> query=entityManager.createQuery("select DISTINCT m2 from Departement m2",Departement.class);
	//query.setParameter("id", id);
	
	List<Departement> aa =null;
	aa=	query.getResultList();
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return aa;

}
public List<Employe> findchefdep(String ecole, String role) {
	
	
	TypedQuery<Employe> query=entityManager.createQuery("select DISTINCT m from Employe m where m.ecoleEmploye = :ecole and m.employeRole = :role",Employe.class);
	//query.setParameter("id", id);
	
	List<Employe> aa =null;
	aa=	query.setParameter("ecole", ecole).setParameter("role", "department head").getResultList();
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return aa;

}
public List<Employe> finddirecteurstage(String ecole, String role) {
	
	
	TypedQuery<Employe> query=entityManager.createQuery("select DISTINCT m from Employe m where m.ecoleEmploye = :ecole and m.employeRole = :role",Employe.class);
	//query.setParameter("id", id);
	
	List<Employe> aa =null;
	aa=	query.setParameter("ecole", ecole).setParameter("role", "Internship director").getResultList();
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return aa;

}

public void deleteDepart(int  e){
//entityManager.remove(e);
entityManager.createQuery("DELETE FROM Departement i WHERE i.id = :id").setParameter("id",e)
.executeUpdate();
}

public void deleteStudent(int  e){
	//entityManager.remove(e);
	entityManager.createQuery("DELETE FROM Etudiant i WHERE i.idEtudiant = :id").setParameter("id",e)
	.executeUpdate();
	}
	
public ArrayList<SiteUniversity> findSiteDep() {
	TypedQuery<SiteUniversity> query=entityManager.createQuery("Select p from SiteUniversity p",SiteUniversity.class);
	//query.setParameter("id", id);
	ArrayList<SiteUniversity> results= (ArrayList<SiteUniversity>) query.getResultList();
	
	
	return results;
}
public List<Optionne> findOption(int id) {
	
	
	TypedQuery<Optionne> query=entityManager.createQuery("select DISTINCT p from Optionne p join p.dep m2 join m2.sitee p2 join p2.plateforme u2 where u2.id_plateforme = :id",Optionne.class);
	//query.setParameter("id", id);
	
	List<Optionne> aa =null;
	aa=	query.setParameter("id", id).getResultList();
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return aa;
	}
	
	

	
	
public void addOption(Optionne e) {
	
	entityManager.merge(e);
	
	
}
public void deleteOption(int  e){
	//entityManager.remove(e);
	entityManager.createQuery("DELETE FROM Optionne i WHERE i.idOption = :id").setParameter("id",e)
	.executeUpdate();
	}
/*public ArrayList<ClasseStudent> findClasse() {
	TypedQuery<ClasseStudent> query=entityManager.createQuery("Select p from ClasseStudent p",ClasseStudent.class);
	//query.setParameter("id", id);
	ArrayList<ClasseStudent> results= (ArrayList<ClasseStudent>) query.getResultList();
	
	
	return results;
}*/
public List<ClasseStudent> findClasse(int id) {
	
	
	TypedQuery<ClasseStudent> query=entityManager.createQuery("select DISTINCT g from ClasseStudent g join g.optionne p join p.dep m2 join m2.sitee p2 join p2.plateforme u2 where u2.id_plateforme = :id",ClasseStudent.class);
	//query.setParameter("id", id);
	
	List<ClasseStudent> aa =null;
	aa=	query.setParameter("id", id).getResultList();
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return aa;
	}
public List<ClasseStudent> findClassee(int id) {
	
	
	TypedQuery<ClasseStudent> query=entityManager.createQuery("select DISTINCT g from ClasseStudent g join g.optionne p  where p.idOption =:id",ClasseStudent.class);
	//query.setParameter("id", id);
	
	List<ClasseStudent> aa =null;
	aa=	query.setParameter("id", id).getResultList();
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return aa;
	}
public Optionne optionName(String name){
	TypedQuery<Optionne> query=entityManager.createQuery("select  g from Optionne g where g.optionName = :name",Optionne.class);
	//query.setParameter("id", id);
	
	Optionne aa =null;
	aa=	query.setParameter("name", name).getSingleResult();
	
//List<Archive>f=query.getResultList();
	//Archive f= new Archive();
	//f= query.getResultList();
	return aa;
	
}

public void addClasse(ClasseStudent e) {
	
	entityManager.merge(e);
	
	
}
public void deleteClasse(int  e){
	//entityManager.remove(e);
	entityManager.createQuery("DELETE FROM ClasseStudent i WHERE i.id = :id").setParameter("id",e)
	.executeUpdate();
	}
public ArrayList<ClasseStudent> recupClass() {
	TypedQuery<ClasseStudent> query=entityManager.createQuery("Select p from ClasseStudent p",ClasseStudent.class);
	//query.setParameter("id", id);
	ArrayList<ClasseStudent> results= (ArrayList<ClasseStudent>) query.getResultList();
	
	
	return results;
}

public ArrayList<ClasseStudent> findClasseOption(int id) {
	TypedQuery<ClasseStudent> query=entityManager.createQuery("Select p from ClasseStudent p WHERE p.Optionnne.idOption=:id",ClasseStudent.class);
	//query.setParameter("id", id);
	ArrayList<ClasseStudent> results= (ArrayList<ClasseStudent>) query.setParameter("id", id).getResultList();
	
	
	return results;
}


public void updateStudent(Etudiant e) {
	Query query = entityManager.createNativeQuery("UPDATE Employe SET `nomEtudiant`=:a "
			+ ", `prenomEtudiant`=:b ,`emailEtudiant`=:c , `userNameEtudiant`=:d ,`creditPedagogiqueEtudiant`=:e"
			+ ",`creditFinaciereEtudiant`=:f, `optionstudent`=:g, `classenum`=:h` "
			+ " WHERE idEtudiant=:l " );
	query
	.setParameter("a", e.getNomEtudiant())
	.setParameter("b", e.getPrenomEtudiant())
	.setParameter("c", e.getEmailEtudiant())
	.setParameter("d", e.getUserNameEtudiant())
	.setParameter("e", e.isCreditPedagogiqueEtudiant())
	.setParameter("f", e.isCreditFinaciereEtudiant())
	.setParameter("g", e.getOptionstudent())
	.setParameter("h", e.getClassenum())
	
	.setParameter("l", e.getIdEtudiant())		
	.executeUpdate();
	
	
}
public void updateSite(SiteUniversity e) {
	Query query = entityManager.createNativeQuery("UPDATE SiteUniversity SET `siteName`=:a "
			+ ", `director`=:b  "
			+ " WHERE id=:l " );
	query
	.setParameter("a", e.getSiteName())
	.setParameter("b", e.getDirector())
	
	
	.setParameter("l", e.getSiteName())		
	.executeUpdate();
	
	
}
public void updatedepartment(Departement e) {
	Query query = entityManager.createNativeQuery("UPDATE Departement SET `department`=:a "
			+ ", `departmenthead`=:b, `sitee`=:c  "
			+ " WHERE id=:l " );
	query
	.setParameter("a", e.getDepartment())
	.setParameter("b", e.getDepartmenthead())
	.setParameter("c", e.getSitee())
	
	.setParameter("l", e.getId())		
	.executeUpdate();
	
	
}
public void updateOption(Optionne e) {
	Query query = entityManager.createNativeQuery("UPDATE Optionne SET `optionName`=:a "
			+ ", `dep`=:b  "
			+ " WHERE IdOption=:l " );
	query
	.setParameter("a", e.getOptionName())
	.setParameter("b", e.getDep())

	
	.setParameter("l", e.getIdOption())		
	.executeUpdate();
	
	
}
/*public void updateClasse(ClasseStudent e) {
	Query query = entityManager.createNativeQuery("UPDATE class SET `optionne`=:a "
			+ ", `classNumber`=:b  "
			+ " WHERE id=:l " );
	query
	.setParameter("a", e.getOptionne().getIdOption())
	.setParameter("b", e.getClassNumber())

	
	.setParameter("l", e.getId())		
	.executeUpdate();
	
	
}
*/
public void updateClasse(ClasseStudent e){
	entityManager.merge(e);
}

@Override
public List<Employe> findsearch(String post) {
	// TODO Auto-generated method stub
	return null;
}

}
