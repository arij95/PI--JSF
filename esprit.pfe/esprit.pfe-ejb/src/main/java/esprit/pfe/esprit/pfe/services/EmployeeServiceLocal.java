package esprit.pfe.esprit.pfe.services;

import java.util.List;

import javax.ejb.Local;

import esprit.pfe.esprit.pfe.persistence.Employe;


@Local
public interface EmployeeServiceLocal {

	public void addemployee(Employe em);
	 void deleteEmploye(int  e);
	 void updateEmployee(Employe e);
	 List<Employe> findEmployee(String ecole);
	 Employe findEmployeefirt(String ecole,int id) ;
}
