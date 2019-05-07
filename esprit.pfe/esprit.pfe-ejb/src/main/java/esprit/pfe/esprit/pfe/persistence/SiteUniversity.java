package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SiteUniversity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String siteName;
	private String director;
	
	private Plateforme plateforme;
	private List<Departement> depart = new ArrayList<>();   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	 
	
	public SiteUniversity(String siteName) {
		super();
		this.siteName = siteName;
	}
	
	public SiteUniversity() {
		super();
		
	}
	@ManyToOne
	public Plateforme getPlateforme() {
		return plateforme;
	}
	public void setPlateforme(Plateforme plateforme) {
		this.plateforme = plateforme;
	}
	 
	public SiteUniversity(String siteName, Plateforme plateforme) {
		super();
		this.siteName = siteName;
		this.plateforme = plateforme;
	}
	@OneToMany(mappedBy = "sitee",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Departement> getDepart() {
		return depart;
	}
	public void setDepart(List<Departement> depart) {
		this.depart = depart;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public SiteUniversity(String siteName, String director) {
		super();
		this.siteName = siteName;
		this.director = director;
	}
	public SiteUniversity(String siteName, String director, Plateforme plateforme) {
		super();
		this.siteName = siteName;
		this.director = director;
		this.plateforme = plateforme;
	}
	
	
	
	 
	
	
	
	
	
	
}
