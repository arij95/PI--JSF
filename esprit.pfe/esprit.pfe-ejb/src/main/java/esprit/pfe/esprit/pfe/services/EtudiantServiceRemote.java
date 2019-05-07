package esprit.pfe.esprit.pfe.services;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.Etudiant;

@Remote
public interface EtudiantServiceRemote {

	public Etudiant getDonneEtu(int id);
	public void annulation(int id,int ann,String ms);
}
