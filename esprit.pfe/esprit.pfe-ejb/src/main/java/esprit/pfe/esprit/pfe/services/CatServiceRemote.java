package esprit.pfe.esprit.pfe.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.Categorie;



@Remote
public interface CatServiceRemote {
	public ArrayList reupCat();
	public void ajoutCat(Categorie c);
}
