package esprit.pfe.esprit.pfe.services;


import javax.ejb.Remote;

import esprit.pfe.esprit.pfe.persistence.Etudiant;


@Remote
public interface ExistEmailRemote  {
	
	public Etudiant exist(String adresse);
	 public void mdp(String psw,int id);
	 public void turn1(int id); public void ajouteretudiantuser(String username,String mdp);}
