package esprit.pfe.esprit.pfe.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.ClasseStudent;
import esprit.pfe.esprit.pfe.persistence.Departement;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.Optionne;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.persistence.SiteUniversity;
import esprit.pfe.esprit.pfe.util.IGenericDAO;





@Remote
public interface PlateformeServiceRemote extends IGenericDAO<Plateforme> {
	void addinterview(Plateforme i);
	public void ajouteretuduser(Etudiant e);
	public Employe selectemployetapped(String s);
	public Etudiant selectetudianttapped(String s);
	void addstudent(Etudiant e);
	List<Etudiant> findAllStudent(String ecole);
	 void addsite(SiteUniversity e);
	 List<SiteUniversity> findAllSite(int id);
	 List<SiteUniversity> findSitefordep();
	 void deleteSite(int e);
	 void adddepartment(Departement e);
	 public void ajouterempuser(Employe e);
	 List<Departement> findDep(int id) ;
	 void deleteDepart(int  e);
	 ArrayList<SiteUniversity> findSiteDep();
	 List<Optionne> findOption(int id);
	 public void addOption(Optionne e);
	 public void deleteOption(int  e);
	 List<ClasseStudent> findClasse(int id);
	 void addClasse(ClasseStudent e);
	 void deleteClasse(int  e);
	 ArrayList<ClasseStudent> recupClass();
	 Integer findAllSitep();
	
	 List<ClasseStudent> findClassee(int id);
	 Optionne optionName(String name);
	 void deleteStudent(int  e);
	 Plateforme Plateformeuser(int id);
	 List<Employe> findchefdep(String ecole, String role) ;
	 List<Employe> finddirecteurstage(String ecole, String role) ;
	 void updateStudent(Etudiant e);
	 void updateSite(SiteUniversity e) ;
	 void updatedepartment(Departement e);
	 void updateOption(Optionne e);
	 void updateClasse(ClasseStudent e);
	 List<Departement> findDepp();
	 public List<Employe> findsearch(String post) ;
	 
}
