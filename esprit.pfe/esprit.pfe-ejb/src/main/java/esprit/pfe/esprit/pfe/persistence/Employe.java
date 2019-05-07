package esprit.pfe.esprit.pfe.persistence;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;




@Entity
public class Employe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    private int idEmploye;
	
	   
	    private String nomEmploye;
	    
	  
		 
	    private String prenomEmploye;
	    
	   
	    private String ecoleEmploye;
	    
	    
	    private String emailEmploye;
	    
	    
	    private String passwordEmploye;
	    
		   
	    private String userNameEmploye;
	    
	    private int nbmax;
	    private String favorie;
	    private String first;
	    
	  
	    public String getFirst() {
			return first;
		}
		public void setFirst(String first) {
			this.first = first;
		}

		private String employeRole;

	    
		   
		    private int maxEnRap;
		    private int maxEnEnca;
		    private int maxEnPreva;
		    private int maxPresid;
		  
		    private Plateforme plateforme;
		    private List<RapportValidation> rapport;
		    private List<PptValidation> ppt;
	    
//************

public int getMaxEnRap() {
				return maxEnRap;
			}
			public void setMaxEnRap(int maxEnRap) {
				this.maxEnRap = maxEnRap;
			}
			public int getMaxEnEnca() {
				return maxEnEnca;
			}
			public void setMaxEnEnca(int maxEnEnca) {
				this.maxEnEnca = maxEnEnca;
			}
			public int getMaxEnPreva() {
				return maxEnPreva;
			}
			public void setMaxEnPreva(int maxEnPreva) {
				this.maxEnPreva = maxEnPreva;
			}
			public int getMaxPresid() {
				return maxPresid;
			}
			public void setMaxPresid(int maxPresid) {
				this.maxPresid = maxPresid;
			}
			
			@OneToOne(mappedBy = "employe", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
			public Plateforme getPlateforme() {
		return plateforme;
	}
			public void setPlateforme(Plateforme plateforme) {
				this.plateforme = plateforme;
			}
			public static long getSerialversionuid() {
				return serialVersionUID;
			}
		//**************
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")    
public int getIdEmploye() {
	return idEmploye;
}
		
private List<FichePfe> fichesEnca;


@OneToMany(mappedBy="encadrant")
public List<FichePfe> getFichesEnca() {
	return fichesEnca;
}
public void setFichesEnca(List<FichePfe> fichesEnca) {
	this.fichesEnca = fichesEnca;
}

private List<FichePfe> fichesRap;

@OneToMany(mappedBy="rapporteur")
public List<FichePfe> getFichesRap() {
	return fichesRap;
}
public void setFichesRap(List<FichePfe> fichesRap) {
	this.fichesRap = fichesRap;
}

private List<FichePfe> fichesPre;

@OneToMany(mappedBy="prevalid")
public List<FichePfe> getFichesPre() {
	return fichesPre;
}
@OneToMany(mappedBy = "employerapport")
public List<RapportValidation> getRapport() {
	return rapport;
}
public void setRapport(List<RapportValidation> rapport) {
	this.rapport = rapport;
}

@OneToMany(mappedBy="employeppt")
public List<PptValidation> getPpt() {
	return ppt;
}
public void setPpt(List<PptValidation> ppt) {
	this.ppt = ppt;
}
public void setFichesPre(List<FichePfe> fichesPre) {
	this.fichesPre = fichesPre;
}
		public Employe() {
	super();
}
		public Employe(int idEmploye, String nomEmploye, String prenomEmploye, String ecoleEmploye, String emailEmploye,
				String passwordEmploye, String userNameEmploye,String employeRole) {
			super();
			this.idEmploye = idEmploye;
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			this.ecoleEmploye = ecoleEmploye;
			this.emailEmploye = emailEmploye;
			this.passwordEmploye = passwordEmploye;
			this.userNameEmploye = userNameEmploye;
			this.employeRole = employeRole;
		}

		public Employe(int idEmploye, String nomEmploye, String prenomEmploye, String ecoleEmploye, String emailEmploye,
				String userNameEmploye, String employeRole) {
			super();
			this.idEmploye = idEmploye;
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			this.ecoleEmploye = ecoleEmploye;
			this.emailEmploye = emailEmploye;
			this.userNameEmploye = userNameEmploye;
			this.employeRole = employeRole;
		}
		


		

		public void setIdEmploye(int idEmploye) {
			this.idEmploye = idEmploye;
		}


		public String getNomEmploye() {
			return nomEmploye;
		}


		public void setNomEmploye(String nomEmploye) {
			this.nomEmploye = nomEmploye;
		}


		public String getPrenomEmploye() {
			return prenomEmploye;
		}


		public void setPrenomEmploye(String prenomEmploye) {
			this.prenomEmploye = prenomEmploye;
		}


		public String getEcoleEmploye() {
			return ecoleEmploye;
		}


		public void setEcoleEmploye(String ecoleEmploye) {
			this.ecoleEmploye = ecoleEmploye;
		}


		public String getEmailEmploye() {
			return emailEmploye;
		}


		public void setEmailEmploye(String emailEmploye) {
			this.emailEmploye = emailEmploye;
		}


		public String getPasswordEmploye() {
			return passwordEmploye;
		}


		public void setPasswordEmploye(String passwordEmploye) {
			this.passwordEmploye = passwordEmploye;
		}


		public String getUserNameEmploye() {
			return userNameEmploye;
		}


		public void setUserNameEmploye(String userNameEmploye) {
			this.userNameEmploye = userNameEmploye;
		}

		 
		public String getEmployeRole() {
			return employeRole;
		}


		public void setEmployeRole(String employeRole) {
			this.employeRole = employeRole;
		}
		
		@Override
		public String toString() {
			return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
					+ ", ecoleEmploye=" + ecoleEmploye + ", emailEmploye=" + emailEmploye + ", passwordEmploye="
					+ passwordEmploye + ", userNameEmploye=" + userNameEmploye + ", employeRole=" + employeRole + "]";
		}
		public int getNbmax() {
			return nbmax;
		}
		public void setNbmax(int nbmax) {
			this.nbmax = nbmax;
		}
		public String getFavorie() {
			return favorie;
		}
		public void setFavorie(String favorie) {
			this.favorie = favorie;
		}
		public Employe(String nomEmploye, String prenomEmploye, String ecoleEmploye, String emailEmploye,
				String passwordEmploye, String userNameEmploye, String employeRole) {
			super();
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			this.ecoleEmploye = ecoleEmploye;
			this.emailEmploye = emailEmploye;
			this.passwordEmploye = passwordEmploye;
			this.userNameEmploye = userNameEmploye;
			this.employeRole = employeRole;
		}



		

		public Employe(String nomEmploye, String prenomEmploye, String ecoleEmploye, String emailEmploye,
				String passwordEmploye, String userNameEmploye, int nbmax, String favorie, String employeRole,
				List<FichePfe> fichesEnca, List<FichePfe> fichesRap, List<FichePfe> fichesPre) {
			super();
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			this.ecoleEmploye = ecoleEmploye;
			this.emailEmploye = emailEmploye;
			this.passwordEmploye = passwordEmploye;
			this.userNameEmploye = userNameEmploye;
			this.nbmax = nbmax;
			this.favorie = favorie;
			this.employeRole = employeRole;
			this.fichesEnca = fichesEnca;
			this.fichesRap = fichesRap;
			this.fichesPre = fichesPre;
		}
		public Employe(int idEmploye, String nomEmploye, String prenomEmploye, String ecoleEmploye, String emailEmploye,
				String passwordEmploye, String userNameEmploye, int nbmax, String favorie, String employeRole,
				List<FichePfe> fichesEnca, List<FichePfe> fichesRap, List<FichePfe> fichesPre) {
			super();
			this.idEmploye = idEmploye;
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			this.ecoleEmploye = ecoleEmploye;
			this.emailEmploye = emailEmploye;
			this.passwordEmploye = passwordEmploye;
			this.userNameEmploye = userNameEmploye;
			this.nbmax = nbmax;
			this.favorie = favorie;
			this.employeRole = employeRole;
			this.fichesEnca = fichesEnca;
			this.fichesRap = fichesRap;
			this.fichesPre = fichesPre;
		}

		public Employe(String nomEmploye, String prenomEmploye, String emailEmploye, String userNameEmploye,
				String employeRole, int maxEnRap,int maxEnEnca , int maxEnPreva, int maxPresid,String ecoleEmploye) {
			super();
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			
			this.userNameEmploye = userNameEmploye;
			this.emailEmploye = emailEmploye;
			this.employeRole = employeRole;
			this.maxEnRap = maxEnRap;
			this.maxEnEnca = maxEnEnca;
			this.maxEnPreva = maxEnPreva;
			this.maxPresid = maxPresid;
			this.ecoleEmploye=ecoleEmploye;

			
		}
		public Employe(String nomEmploye, String prenomEmploye, String emailEmploye, String userNameEmploye,
				String employeRole,String ecoleEmploye) {
			super();
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			
			this.userNameEmploye = userNameEmploye;
			this.emailEmploye = emailEmploye;
			this.employeRole = employeRole;
			this.ecoleEmploye=ecoleEmploye;

			
		}
		public Employe(String nomEmploye, String prenomEmploye, String ecoleEmploye, String emailEmploye,
				String passwordEmploye, String userNameEmploye, int nbmax, String favorie, String first) {
			super();
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			this.ecoleEmploye = ecoleEmploye;
			this.emailEmploye = emailEmploye;
			this.passwordEmploye = passwordEmploye;
			this.userNameEmploye = userNameEmploye;
			this.nbmax = nbmax;
			this.favorie = favorie;
			this.first = first;
		}

		public Employe(int idEmploye, String nomEmploye, String prenomEmploye, String emailEmploye,
				String userNameEmploye, String employeRole) {
			super();
			this.idEmploye = idEmploye;
			this.nomEmploye = nomEmploye;
			this.prenomEmploye = prenomEmploye;
			this.emailEmploye = emailEmploye;
			this.userNameEmploye = userNameEmploye;
			this.employeRole = employeRole;
		}
		
		
		
	
		
		
		



		



	
	    
	   
	    //*************** relations fiche w soutn !!!
	     
	
	 
	 	
	    
	    
	    
}
