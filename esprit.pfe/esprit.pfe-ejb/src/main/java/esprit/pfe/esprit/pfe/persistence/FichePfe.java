
package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FichePfe implements Serializable {
	
	  
	    private int idFiche;
	  
	 
	    private String titreFiche;
	  
	  
	    private String descriptionFiche;
	    
	  
	    private String probleFiche;
	  
	  
	    private String fctFiche;
	  
	 
	    private String categFiche;
	  
	  
	    private String motCleFiche;
	  
	 
	    private String entrepFiche;
	  
	 
	    private int etatFiche;
	  
	  
	    
	  
	  
	    private Date anneeFiche;
	  
	  
	    private String paysFiche;
	  
	  
	    private String ecoleFiche;

	    private String NouvprobleFiche;
	  
	  
	    private String NouvfctFiche;
	    private int version;
	    private float noteEnc;
	    private float noteRap;
	    
//etu fk

	  //*******************
	  private Etudiant etudiant;
	  @OneToOne
	  public Etudiant getEtudiant() {
			return etudiant;
		}

		public void setEtudiant(Etudiant etudiant) {
			this.etudiant = etudiant;
		}
		private Employe encadrant;
		
	  @ManyToOne
	  public Employe getEncadrant() {
			return encadrant;
		}

		public void setEncadrant(Employe encadrant) {
			this.encadrant = encadrant;
		}
		private Employe rapporteur;
		
		@ManyToOne
		public Employe getRapporteur() {
			return rapporteur;
		}

		public void setRapporteur(Employe rapporteur) {
			this.rapporteur = rapporteur;
		}
		

		//***********
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	public int getIdFiche() {
		return idFiche;
	}

private Employe prevalid;
		
		
		
	@ManyToOne
	public Employe getPrevalid() {
			return prevalid;
		}

		public void setPrevalid(Employe prevalid) {
			this.prevalid = prevalid;
		}

	public void setIdFiche(int idFiche) {
		this.idFiche = idFiche;
	}

	public String getTitreFiche() {
		return titreFiche;
	}

	public void setTitreFiche(String titreFiche) {
		this.titreFiche = titreFiche;
	}

	public String getDescriptionFiche() {
		return descriptionFiche;
	}

	public void setDescriptionFiche(String descriptionFiche) {
		this.descriptionFiche = descriptionFiche;
	}

	public String getProbleFiche() {
		return probleFiche;
	}

	public void setProbleFiche(String probleFiche) {
		this.probleFiche = probleFiche;
	}

	public String getFctFiche() {
		return fctFiche;
	}

	public void setFctFiche(String fctFiche) {
		this.fctFiche = fctFiche;
	}

	public String getCategFiche() {
		return categFiche;
	}

	public void setCategFiche(String categFiche) {
		this.categFiche = categFiche;
	}

	public String getMotCleFiche() {
		return motCleFiche;
	}

	public void setMotCleFiche(String motCleFiche) {
		this.motCleFiche = motCleFiche;
	}

	public String getEntrepFiche() {
		return entrepFiche;
	}

	public void setEntrepFiche(String entrepFiche) {
		this.entrepFiche = entrepFiche;
	}

	public int getEtatFiche() {
		return etatFiche;
	}

	public void setEtatFiche(int etatFiche) {
		this.etatFiche = etatFiche;
	}

	
	@Temporal(TemporalType.DATE)
	public Date getAnneeFiche() {
		return anneeFiche;
	}

	public void setAnneeFiche(Date anneeFiche) {
		this.anneeFiche = anneeFiche;
	}

	public String getPaysFiche() {
		return paysFiche;
	}

	public void setPaysFiche(String paysFiche) {
		this.paysFiche = paysFiche;
	}

	public String getEcoleFiche() {
		return ecoleFiche;
	}

	public void setEcoleFiche(String ecoleFiche) {
		this.ecoleFiche = ecoleFiche;
	}

	public FichePfe() {
		super();
	}

	public FichePfe(String titreFiche, String descriptionFiche, String probleFiche, String fctFiche, String categFiche,
			String motCleFiche, String entrepFiche, Date anneeFiche, String paysFiche, String ecoleFiche,
			Etudiant etudiant, int version, float noteEnc, float noteRap) {
		super();
		this.titreFiche = titreFiche;
		this.descriptionFiche = descriptionFiche;
		this.probleFiche = probleFiche;
		this.fctFiche = fctFiche;
		this.categFiche = categFiche;
		this.motCleFiche = motCleFiche;
		this.entrepFiche = entrepFiche;
		this.anneeFiche = anneeFiche;
		this.paysFiche = paysFiche;
		this.ecoleFiche = ecoleFiche;
		this.etudiant = etudiant;
		this.version=version;
		this.noteEnc=noteEnc;
		this.noteRap=noteRap;
	}

	public FichePfe(String titreFiche, String descriptionFiche, String probleFiche, String fctFiche, String categFiche,
			String motCleFiche, String entrepFiche, String paysFiche, String ecoleFiche, Etudiant etudiant) {
		super();
		this.titreFiche = titreFiche;
		this.descriptionFiche = descriptionFiche;
		this.probleFiche = probleFiche;
		this.fctFiche = fctFiche;
		this.categFiche = categFiche;
		this.motCleFiche = motCleFiche;
		this.entrepFiche = entrepFiche;
		this.paysFiche = paysFiche;
		this.ecoleFiche = ecoleFiche;
		this.etudiant = etudiant;
	}

	

	public FichePfe(String titreFiche,  Date anneeFiche) {
		super();
		this.titreFiche = titreFiche;
		this.anneeFiche = anneeFiche;
	}

	public FichePfe(String titreFiche, String probleFiche, String fctFiche, String categFiche,
			String motCleFiche, String entrepFiche, String paysFiche) {
		super();
		this.titreFiche = titreFiche;
		this.descriptionFiche = descriptionFiche;
		this.probleFiche = probleFiche;
		this.fctFiche = fctFiche;
		this.categFiche = categFiche;
		this.motCleFiche = motCleFiche;
		this.entrepFiche = entrepFiche;
		
		this.paysFiche = paysFiche;
		
	}
	  
	public FichePfe(String titreFiche,String desc, String probleFiche, String fctFiche,
			String categFiche, String motCleFiche, String entrepFiche,
			String paysFiche, String ecoleFiche,int etat,int version,Employe encadrant, Employe rapporteur, float noteEnc, float noteRap) {
		super();
		
		this.titreFiche = titreFiche;
		this.descriptionFiche=desc;
		this.probleFiche = probleFiche;
		this.fctFiche = fctFiche;
		this.categFiche = categFiche;
		this.motCleFiche = motCleFiche;
		this.entrepFiche = entrepFiche;
		this.etatFiche = etat;
		
		
		this.paysFiche = paysFiche;
		this.ecoleFiche = ecoleFiche;
		this.version=version;
		this.encadrant=encadrant;
		this.rapporteur=rapporteur;
		this.noteEnc=noteEnc;
		this.noteRap=noteRap;
		
		
	}
	public FichePfe(String titreFiche,String desc, String probleFiche, String fctFiche,
			String categFiche, String motCleFiche, String entrepFiche,
			String paysFiche, String ecoleFiche,int etat,int version, float noteEnc, float noteRap) {
		super();
		
		this.titreFiche = titreFiche;
		this.descriptionFiche=desc;
		this.probleFiche = probleFiche;
		this.fctFiche = fctFiche;
		this.categFiche = categFiche;
		this.motCleFiche = motCleFiche;
		this.entrepFiche = entrepFiche;
		this.etatFiche = etat;
		
		
		this.paysFiche = paysFiche;
		this.ecoleFiche = ecoleFiche;
		this.version=version;
		
		this.noteEnc=noteEnc;
		this.noteRap=noteRap;
		
		
	}
	public FichePfe(String titreFiche,String desc, String probleFiche, String fctFiche,
			String categFiche, String motCleFiche, String entrepFiche,
			String paysFiche, String ecoleFiche,int etat,int version) {
		super();
		
		this.titreFiche = titreFiche;
		this.descriptionFiche=desc;
		this.probleFiche = probleFiche;
		this.fctFiche = fctFiche;
		this.categFiche = categFiche;
		this.motCleFiche = motCleFiche;
		this.entrepFiche = entrepFiche;
		this.etatFiche = etat;
		
		
		this.paysFiche = paysFiche;
		this.ecoleFiche = ecoleFiche;
		this.version=version;
		
		
		
		
	}

	public String getNouvprobleFiche() {
		return NouvprobleFiche;
	}

	public void setNouvprobleFiche(String nouvprobleFiche) {
		NouvprobleFiche = nouvprobleFiche;
	}

	public String getNouvfctFiche() {
		return NouvfctFiche;
	}

	public void setNouvfctFiche(String nouvfctFiche) {
		NouvfctFiche = nouvfctFiche;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public float getNoteEnc() {
		return noteEnc;
	}

	public void setNoteEnc(float noteEnc) {
		this.noteEnc = noteEnc;
	}

	public float getNoteRap() {
		return noteRap;
	}

	public void setNoteRap(float noteRap) {
		this.noteRap = noteRap;
	}

	
	

}
