package esprit.pfe.esprit.pfe.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.RapportValidation;

@Remote
public interface RapportValidationServiceRemote {
	
	public void creerapport(RapportValidation rp);
	public RapportValidation afficher(int id) ;
	public List<RapportValidation> afficherEnc(int id);
	public void delete(int  e);
	public RapportValidation afficherpre(int id, int valide) ;
	public List<RapportValidation> afficherprestudent(int id, int valide);
	public RapportValidation afficherpourenc(int id);
	public void modifierPourEncadrant(RapportValidation em);
	public void modifadmin(RapportValidation e);
	//public void modifierPourEncadrant(RapportValidation p,int id, String remarque, String sign,int valide);

}
