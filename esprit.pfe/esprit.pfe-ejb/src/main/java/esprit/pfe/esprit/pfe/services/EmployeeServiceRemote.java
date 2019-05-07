package esprit.pfe.esprit.pfe.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;


@Remote
public interface EmployeeServiceRemote {
	public void addemployee(Employe em);
	void addstudent(Etudiant em);
	 void deleteEmploye(int  e);
	 void updateEmployee(Employe e);
	 List<Employe> findEmployee(String ecole);
	 Employe findEmployeefirt(String ecole,int id) ;
}
