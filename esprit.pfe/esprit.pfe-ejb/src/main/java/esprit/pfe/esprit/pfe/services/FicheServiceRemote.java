package esprit.pfe.esprit.pfe.services;

import java.util.ArrayList;

import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.FichePfe;



@Remote
public interface FicheServiceRemote {

	public void creefiche(FichePfe pfe);
	public FichePfe afficher(int id);
	public void modifierMaj(FichePfe p,int id, String date);
	public void modifierMin(FichePfe p,int id, String date);
	public FichePfe getDonneFich(int id);
	public ArrayList afficherPre(int id);
	public ArrayList afficherRap(int id);
	public ArrayList afficherEnc(int id);
	public void preVal(int id, int etat);
	public void reject(FichePfe p,int id, String date,int etat);
	public FichePfe verif(int id) ;
	public void noteEnca(int id,float note);
	public void noteRapp(int id,float note);
}
