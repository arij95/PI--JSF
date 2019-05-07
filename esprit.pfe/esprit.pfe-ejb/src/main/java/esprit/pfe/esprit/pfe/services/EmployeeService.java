package esprit.pfe.esprit.pfe.services;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;



@Stateless
@LocalBean
public class EmployeeService  implements EmployeeServiceRemote, EmployeeServiceLocal{
	
	
	@PersistenceContext
	private EntityManager entityManager;

	public EmployeeService() {
		super();
	}
	@Override
	public void addemployee(Employe em){
		entityManager.merge(em);
	}
	@Override
	public void addstudent(Etudiant em) {
		// TODO Auto-generated method stub
		
	}
	public void deleteEmploye(int  e){
		//entityManager.remove(e);
		entityManager.createQuery("DELETE FROM Employe i WHERE i.idEmploye = :id").setParameter("id",e)
		.executeUpdate();
		}
	/*public void updateEmployee(Employe e) {
		Query query = entityManager.createNativeQuery("UPDATE Employe SET `nomEmploye`=:a "
				+ ", `prenomEmploye`=:b ,`employeRole`=:c , `emailEmploye`=:d ,`userNameEmploye`=:e "
				+ " WHERE idEmploye=:l " );
		query
		.setParameter("a", e.getNomEmploye())
		.setParameter("b", e.getPrenomEmploye())
		.setParameter("c", e.getEmployeRole())
		.setParameter("d", e.getEmailEmploye())
		.setParameter("e", e.getUserNameEmploye())
		
		.setParameter("l", e.getIdEmploye())		
		.executeUpdate();
		
		
	}*/
	public void updateEmployee(Employe em){
		entityManager.merge(em);
	}
	public List<Employe> findEmployee(String ecole) {
		
		
		TypedQuery<Employe> query=entityManager.createQuery("select DISTINCT m from Employe m where m.ecoleEmploye = :ecole",Employe.class);
		//query.setParameter("id", id);
		
		List<Employe> aa =null;
		aa=	query.setParameter("ecole", ecole).getResultList();
		
	//List<Archive>f=query.getResultList();
		//Archive f= new Archive();
		//f= query.getResultList();
		return aa;

	}
public Employe findEmployeefirt(String ecole,int id) {
		
		
		TypedQuery<Employe> query=entityManager.createQuery("select DISTINCT m from Employe m where m.first = :ecole and m.idEmploye=id",Employe.class);
		//query.setParameter("id", id);
		
		Employe aa =null;
		aa=	query.setParameter("ecole", ecole).setParameter("id", id).getSingleResult();
		
	//List<Archive>f=query.getResultList();
		//Archive f= new Archive();
		//f= query.getResultList();
		return aa;

	}

public List<Employe> findsearch(String post) {
	
	
	TypedQuery<Employe> query=entityManager.createQuery("Select DISTINCT e from Employe e where e.employeRole=:post",Employe.class);
	//query.setParameter("id", id);
	List<Employe>  f=query.setParameter("post", post).getResultList();
	
	
	return f;

}
}
