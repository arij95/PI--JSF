package esprit.pfe.esprit.pfe.services;

import javax.ejb.Local;

import esprit.pfe.esprit.pfe.persistence.Etudiant;


	@Local
	public interface ExistEmailLocal {
		public Etudiant exist(String adresse);
		 public void mdp(String psw,int id);
		 public void turn1(int id);
}
