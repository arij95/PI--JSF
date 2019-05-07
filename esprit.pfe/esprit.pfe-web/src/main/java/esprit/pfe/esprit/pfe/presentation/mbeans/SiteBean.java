package esprit.pfe.esprit.pfe.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import esprit.pfe.esprit.pfe.persistence.Employe;

import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.persistence.SiteUniversity;
import esprit.pfe.esprit.pfe.services.PlateformeService;

@ManagedBean
@SessionScoped
public class SiteBean {
	@EJB
	PlateformeService plateformeservice;
	private String siteName;
	private String director;
	 private String nomEmploye;
	 private Employe Emplo;
	private Plateforme plateforme;
	private SiteUniversity site;
	private List<Employe> empl;
	//private String nomEmploye ;
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Plateforme getPlateforme() {
		return plateforme;
	}
	public void setPlateforme(Plateforme plateforme) {
		this.plateforme = plateforme;
	}
	public SiteUniversity getSite() {
		return site;
	}
	public void setSite(SiteUniversity site) {
		this.site = site;
	}
	
	Employe e = new Employe(1,"arij", "arij", "esprit","arij@arij.com",
			"arij", "arij","Admin");
	Plateforme p= new Plateforme(1, e,e.getEcoleEmploye() , "2018/2019", "mmmmm.jpg");

    public List<Employe> getemployeee(){
    	System.out.println(empl);
    	empl= plateformeservice.finddirecteurstage(p.getUniversity(), "Internship director");
    	System.out.println(empl);
    	return empl;
    	
    	
    }
    
    List<SiteUniversity> sitee;
    public List<SiteUniversity> getAllSItes(){
    	
    	sitee= plateformeservice.findAllSite(p.getId_plateforme());
    	System.out.println(sitee);
    	return sitee;
    	
    	
    }
    
    public void addSite(){
    	System.out.println("aaaaaa");
    	
    	plateformeservice.addsite( new SiteUniversity(siteName, director,p));
    	
    	
    }
    public void deleteSite(int id)
    {
    	plateformeservice.deleteSite(id);
    	
    }
	public List<Employe> getEmpl() {
		return empl;
	}
	public void setEmpl(List<Employe> empl) {
		this.empl = empl;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public Employe getEmplo() {
		return Emplo;
	}
	public void setEmplo(Employe emplo) {
		Emplo = emplo;
	}
	public PlateformeService getPlateformeservice() {
		return plateformeservice;
	}
	public void setPlateformeservice(PlateformeService plateformeservice) {
		this.plateformeservice = plateformeservice;
	}
	public Employe getE() {
		return e;
	}
	public void setE(Employe e) {
		this.e = e;
	}
	public Plateforme getP() {
		return p;
	}
	public void setP(Plateforme p) {
		this.p = p;
	}
	public List<SiteUniversity> getSitee() {
		return sitee;
	}
	public void setSitee(List<SiteUniversity> sitee) {
		this.sitee = sitee;
	}
	
	
	
}
