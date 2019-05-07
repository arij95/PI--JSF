package esprit.pfe.esprit.pfe.services;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.Convention;



@Remote
public interface ConventionServiceRemote {

	public void ajoutConvnetion(Convention c);
	public Convention get(int id);
}
