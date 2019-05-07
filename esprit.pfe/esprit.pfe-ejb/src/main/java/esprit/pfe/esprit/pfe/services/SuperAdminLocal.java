package esprit.pfe.esprit.pfe.services;

import java.util.List;

import javax.ejb.Local;

import esprit.pfe.esprit.pfe.persistence.Employe;

	@Local
	public interface SuperAdminLocal {
		public void ajouteradminecole(Employe e);
		public boolean verifecole(String ecole,String a);
		public boolean verifecole1(String ecole);

		public List<Employe> afficheadmin();
		public void supprimeradmin(int id);
		public void modifadmin(Employe e);
		public List<Employe> search(String ecole);
}
