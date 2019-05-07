package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Archive implements Serializable{

	private int Id;
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
	    
	    private int idetudiant;
		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "ID")
			public int getId() {
				return Id;
			}

			public void setId(int id) {
				Id = id;
			}

			
			
			
			public int getIdetudiant() {
				return idetudiant;
			}

			public void setIdetudiant(int idetudiant) {
				this.idetudiant = idetudiant;
			}

			public int getIdFiche() {
				return idFiche;
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

			public Archive() {
				super();
			}

			public Archive(int idFiche, String titreFiche, String descriptionFiche, String probleFiche, String fctFiche,
					String categFiche, String motCleFiche, String entrepFiche, int etatFiche, Date anneeFiche,
					String paysFiche, String ecoleFiche, String nouvprobleFiche, String nouvfctFiche, int version,
					int idetudiant) {
				super();
				this.idFiche = idFiche;
				this.titreFiche = titreFiche;
				this.descriptionFiche = descriptionFiche;
				this.probleFiche = probleFiche;
				this.fctFiche = fctFiche;
				this.categFiche = categFiche;
				this.motCleFiche = motCleFiche;
				this.entrepFiche = entrepFiche;
				this.etatFiche = etatFiche;
				this.anneeFiche = anneeFiche;
				this.paysFiche = paysFiche;
				this.ecoleFiche = ecoleFiche;
				NouvprobleFiche = nouvprobleFiche;
				NouvfctFiche = nouvfctFiche;
				this.version = version;
				this.idetudiant = idetudiant;
			}
			public Archive(int idFiche,String titreFiche, String descriptionFiche, String probleFiche, String fctFiche, String categFiche,
					String motCleFiche, String entrepFiche, Date anneeFiche, String paysFiche, String ecoleFiche,
					int idetudiant, int version) {
				super();
				this.idFiche=idFiche;
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
				this.idetudiant = idetudiant;
				this.version=version;
			}
			
}
