package esprit.pfe.esprit.pfe.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import esprit.pfe.esprit.pfe.persistence.Departement;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.persistence.SiteUniversity;
import esprit.pfe.esprit.pfe.services.PlateformeService;

@ManagedBean
@SessionScoped
public class DepartmentBean {
	
	@EJB
	PlateformeService plateformeservice;
	
	private String department;
	private String departmenthead;
 private SiteUniversity site;
	 private Employe Emplo;
	private Departement dep;
	private  SiteUniversity sii;
	List<Employe> empl;
	 List<SiteUniversity> sitedep;
	
	public PlateformeService getPlateformeservice() {
		return plateformeservice;
	}

	public void setPlateformeservice(PlateformeService plateformeservice) {
		this.plateformeservice = plateformeservice;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmenthead() {
		return departmenthead;
	}

	public void setDepartmenthead(String departmenthead) {
		this.departmenthead = departmenthead;
	}

	public SiteUniversity getSite() {
		return site;
	}

	public void setSite(SiteUniversity site) {
		this.site = site;
	}

	public List<Employe> getEmpl() {
		return empl;
	}

	public void setEmpl(List<Employe> empl) {
		this.empl = empl;
	}

	public List<SiteUniversity> getSitedep() {
		
		return sitedep;
	}

	public void setSitedep(List<SiteUniversity> sitedep) {
		this.sitedep = sitedep;
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

	public List<Departement> getDepp() {
		return depp;
	}

	public void setDepp(List<Departement> depp) {
		this.depp = depp;
	}
	Employe e = new Employe(1,"arij", "arij", "esprit","arij@arij.com",
			"arij", "arij","Admin");
	Plateforme p= new Plateforme(1, e,e.getEcoleEmploye() , "2018/2019", "mmmmm.jpg");
	
	 public List<Employe> getemployeee(){
	    	System.out.println(empl);
	    	empl= plateformeservice.findchefdep(p.getUniversity(), "department head");
	    	System.out.println(empl);
	    	return empl;
	    	
	    	
	    }
	 
	 public List<SiteUniversity> getsitefordep(){
	    
		 sitedep= plateformeservice.findAllSite(p.getId_plateforme());
		 System.out.println(sitedep);
	    	return sitedep;
	    	
	    	
	    }
	 List<Departement> depp;
	    public List<Departement> getAllDep(){
	    	
	    	depp= plateformeservice.findDep(p.getId_plateforme());
	    	
	    	return depp;
	    	
	    	
	    }
	    
	    public void addDep(){
	    	System.out.println("addd");
	    	
	    	plateformeservice.adddepartment(new Departement(department,site,departmenthead));
	    	
	    	System.out.println("adde");
	    	
	    }
	    public void deleteSite(int id)
	    {
	    	plateformeservice.deleteDepart(id);
	    	
	    }

		public Departement getDep() {
			return dep;
		}

		public void setDep(Departement dep) {
			this.dep = dep;
		}

		public SiteUniversity getSii(Integer id) {
			if (id == null){
	            throw new IllegalArgumentException("no id provided");
	        }
	        for (SiteUniversity sii :sitedep ){
	            if (id.equals(sii.getId())){
	                return sii;
	            }
	        }
	        return null;
	    }
		
		public void setSii(SiteUniversity sii) {
			this.sii = sii;
		}

		public Employe getEmplo() {
			return Emplo;
		}

		public void setEmplo(Employe emplo) {
			Emplo = emplo;
		}

}
