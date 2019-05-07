package esprit.pfe.esprit.pfe.services;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.user;


	@Remote
	public interface VerifRemote  {
		public user verif(String email);
		public void turn1connected(int id);
		 public user userconnected();
		 public Employe selectemployeconnected(int id);
		 public Etudiant selectetudiantconnected(int id);
}
