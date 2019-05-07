package esprit.pfe.esprit.pfe.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.FichePfe;


@Remote
public interface EmployeServiceRemote {

	public Employe getDonnEm(int id);
	public ArrayList afficherEtudiant();
	public ArrayList afficherEnseignent();
	public void affecterEncadrant(int idEtu,int idEnsei);
	public void affecterRapporteur(int idEtu,int idEnsei);
	public FichePfe getEtudiant(int id);
	public FichePfe getFiche(int id);
	public void accepterModif(String NouvFonc,String NouvProb,int id);
	public void FavCat(int id,String fav);
}
