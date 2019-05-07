package esprit.pfe.esprit.pfe.services;

import javax.ejb.Local;

import esprit.pfe.esprit.pfe.persistence.user;


	@Local
	public interface VerifLocal {
		public user verif(String email);
}
