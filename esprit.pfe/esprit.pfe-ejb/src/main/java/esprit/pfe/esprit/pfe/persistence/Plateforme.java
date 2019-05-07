package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * Entity implementation class for Entity: Plateforme
 *
 */
@Entity

public class Plateforme implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	private int id_plateforme;
	private Employe employe;
	private String university;
	
	private String year;
	private String image;
	private List<SiteUniversity> site = new ArrayList<>();


	public Plateforme() {
		super();
	}  
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getId_plateforme() {
		return id_plateforme;
	}
	public void setId_plateforme(int id_plateforme) {
		this.id_plateforme = id_plateforme;
	}
	@OneToOne
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}   
	
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}   
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	public Plateforme(int id_plateforme, Employe employe, String university, String year, String image) {
		super();
		this.setId_plateforme(id_plateforme);
		this.employe = employe;
		this.university = university;
		this.year = year;
		this.image = image;
	}
	public Plateforme(Employe employe, String university, String year, String image) {
		super();
		this.employe = employe;
		this.university = university;
		
		this.year = year;
		this.image = image;
	}
	
	public Plateforme(int id_plateforme, String university, String year, String image) {
		super();
		this.setId_plateforme(id_plateforme);
		this.university = university;
		this.year = year;
		this.image = image;
	}
	 @OneToMany(mappedBy = "plateforme", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	   
	public List<SiteUniversity> getSite() {
		return site;
	}
	public void setSite(List<SiteUniversity> site) {
		this.site = site;
	}
	
	
	
	
	/*@OneToMany(
	        cascade = CascadeType.ALL
	    )
	@JoinColumn(name = "plateforme_id")
	public List<SiteUniversity> getSite() {
		return site;
	}
	public void setSite(List<SiteUniversity> site) {
		this.site = site;
	}
	*/
   
}

