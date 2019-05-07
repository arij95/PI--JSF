package esprit.pfe.esprit.pfe.presentation.mbeans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.persistence.RapportValidation;
import esprit.pfe.esprit.pfe.services.RapportValidationService;

@ManagedBean
@SessionScoped
public class RapportBean {
	
	 @EJB
	 RapportValidationService rapportValidationService;
	 
	 
	  private MenuModel model;
	 private RapportValidation rapportvalidation;
	 private Employe employerapport;
		private String remarque;
		private String signature;
		private int valide;
		private Etudiant etud;
		private String rapportdepot;
		private Part part;
		private List<RapportValidation> rapp;
		public RapportValidationService getRapportValidationService() {
			return rapportValidationService;
		}
		public void setRapportValidationService(RapportValidationService rapportValidationService) {
			this.rapportValidationService = rapportValidationService;
		}
		public RapportValidation getRapportvalidation() {
			return rapportvalidation;
		}
		public void setRapportvalidation(RapportValidation rapportvalidation) {
			this.rapportvalidation = rapportvalidation;
		}
		public Employe getEmployerapport() {
			return employerapport;
		}
		public void setEmployerapport(Employe employerapport) {
			this.employerapport = employerapport;
		}
		public String getRemarque() {
			return remarque;
		}
		public void setRemarque(String remarque) {
			this.remarque = remarque;
		}
		public String getSignature() {
			return signature;
		}
		public void setSignature(String signature) {
			this.signature = signature;
		}
		public int getValide() {
			return valide;
		}
		public void setValide(int valide) {
			this.valide = valide;
		}
		public Etudiant getEtud() {
			return etud;
		}
		public void setEtud(Etudiant etud) {
			this.etud = etud;
		}
		public Part getPart() {
			return part;
		}

		public void setPart(Part part) {
			this.part = part;
		}
		
		
		
		public String Upload() throws IOException {
			part.write("C:\\Users\\Y520-I7-1TR-4G\\workspace\\esprit.pfe\\esprit.pfe-web\\src\\main\\webapp\\resources\\images\\"+getFileName(part));
			return "result";
		}
		private static String getFileName(Part part){
			
			for(String cd: part.getHeader("content-disposition").split(";")){
				
				if(cd.trim().startsWith("filename")){
					
					String filename= cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
					return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
				}
				
			}
			return null;
			
		}
	  Employe e = new Employe(2,"lallou", "lallou", "esprit","lallou@lallou.com",
				"lallou", "lallou","professor");
	  Etudiant et= new Etudiant(1,e.getIdEmploye(), "nom", "prenom","esprit","email","user" );
		
	  public String addPlateforme() throws FileNotFoundException, IOException{
		 
			part.write("C:\\Users\\Y520-I7-1TR-4G\\workspace\\esprit.pfe\\esprit.pfe-web\\src\\main\\webapp\\resources\\images\\"+getFileName(part));
	this.rapportdepot=	getFileName(this.part);

	
	rapportValidationService.creerapport(new RapportValidation(e,"This report is not checked yet!","",0,
			et, rapportdepot));

	  	System.out.println("aaaaaa"); 	
	  	return "result";
	  }
	public String getRapportdepot() {
		return rapportdepot;
	}
	public void setRapportdepot(String rapportdepot) {
		this.rapportdepot = rapportdepot;
	}
	
	public RapportValidation showRapport(){
		
	  	System.out.println("aaaaaa");
	  	rapportvalidation=rapportValidationService.afficher(et.getIdEtudiant());
	  	System.out.println("aaaaaa"); 
	  	return rapportvalidation;
	  }
	public String checkrapportState(){
		
		
	 return "repportStatus.xhtml?faces-redirect=true";
	}
	private String etat;
public RapportValidation rapportState(){
	RapportValidation rp =new RapportValidation();	
rp=rapportValidationService.afficher(et.getIdEtudiant());
		if(rp.getValide()==0){
			
			rapportvalidation=rapportValidationService.afficherpre(et.getIdEtudiant(),0);
			setEtat("The protractor doesn't check you report yet, please check later.");
		}
		else if (rp.getValide()==1){
			rapportvalidation=rapportValidationService.afficherpre(et.getIdEtudiant(),1);
		setEtat("Congraduation, your report has been valid!");}
		
	 return rapportvalidation;
	}

public List<RapportValidation> getAllReports(){
	
		rapp= rapportValidationService.afficherEnc(e.getIdEmploye());
		
	
	return rapp;
	
}
List<RapportValidation> rrr;
public List<RapportValidation> getNonvalidr(){
	
	rrr=rapportValidationService.afficherprestudent(e.getIdEmploye(),2);
	setEtat("This report is non valid.");
	

return rrr;

}
List<RapportValidation> rrrr;
public List<RapportValidation> getNonchecked(){
	
	rrrr=rapportValidationService.afficherprestudent(e.getIdEmploye(),0);
	setEtat("You didn't check this report yet, please check later.");
	

return rrrr;

}
List<RapportValidation> rr;
public List<RapportValidation> getValidddd(){
	
	rr=rapportValidationService.afficherprestudent(e.getIdEmploye(),1);
	setEtat("This report is already valid.");
	

return rr;

}


public List<RapportValidation> getRrr() {
	return rrr;
}
public void setRrr(List<RapportValidation> rrr) {
	this.rrr = rrr;
}
public List<RapportValidation> getRrrr() {
	return rrrr;
}
public void setRrrr(List<RapportValidation> rrrr) {
	this.rrrr = rrrr;
}
public List<RapportValidation> getRr() {
	return rr;
}
public void setRr(List<RapportValidation> rr) {
	this.rr = rr;
}
public  RapportValidation getSelectedReport(){
	
		rapp= rapportValidationService.afficherEnc(e.getIdEmploye());
		setEtat("You didn't check this report yet!");
	
	return rapportvalidation;
	
}

private RapportValidation rapportvalidation1;
private Employe employerapport1;
	private String remarque1;
	private String signature1;
	private int valide1;
	private Etudiant etud1;
	private String rapportdepot1;
private int idtovalid;
private String rem;
static private int idrep;
private String ppdf;
private String sign;
private int val;

public String getPpdf() {
	return ppdf;
}
public void setPpdf(String ppdf) {
	this.ppdf = ppdf;
}
public void setIdtovalid(int idtovalid) {
	this.idtovalid = idtovalid;
}
public int getIdrep() {
	return idrep;
}
public void setIdrep(int idrep) {
	this.idrep = idrep;
}
public String getRem() {
	return rem;
}
public void setRem(String rem) {
	this.rem = rem;
}
public String EditReportStatus(RapportValidation rapp) throws IOException
{	
	
	this.setRemarque(rapp.getRemarque());
	
	
	this.setSignature(rapp.getSignature());
	this.setValide(rapp.getValide());
	this.setIdrep(rapp.getId_rapport());
	
	System.out.println(idrep);
	return "EditReportStatus.xhtml?faces-redirect=true";
	
	
}


public String updaterapport(){
	System.out.println(idrep);
	rapportValidationService.modifadmin(new RapportValidation(remarque,signature, 
			valide,idrep));
	
	return "showallreportsforenc.xhtml?faces-redirect=true";
	
}

public String Toupdaterapport(){
	
	
	return "showallreportsNonvalid.xhtml?faces-redirect=true";
	
}
public String Tounonseenrapport(){
	
	
	return "showallreportsNonseen.xhtml?faces-redirect=true";
	
}

public String Tovalidrapport(){
	
	
	return "showallreportsvalid.xhtml?faces-redirect=true";
	
}

public RapportValidation showprevalide(){
	
  	System.out.println("aaaaaa");
  	rapportvalidation=rapportValidationService.afficherpre(e.getIdEmploye(), 0);
  	System.out.println("aaaaaa"); 
  	return rapportvalidation;
  }
public RapportValidation showvalide(){
	
  	System.out.println("aaaaaa");
  	rapportvalidation=rapportValidationService.afficherpre(e.getIdEmploye(), 1);
  	System.out.println("aaaaaa"); 
  	return rapportvalidation;
  }
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public List<RapportValidation> getRapp() {
	return rapp;
}
public void setRapp(List<RapportValidation> rapp) {
	this.rapp = rapp;
}
public Integer getIdtovalid() {
	return idtovalid;
}
public void setIdtovalid(Integer idtovalid) {
	this.idtovalid = idtovalid;
}

public void addMessage() {
	 boolean bool = (valide == 0);
    String summary = bool ? "Checked" : "Unchecked";
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
}
public Employe getE() {
	return e;
}
public void setE(Employe e) {
	this.e = e;
}
public Etudiant getEt() {
	return et;
}
public void setEt(Etudiant et) {
	this.et = et;
}
public RapportValidation getRapportvalidation1() {
	return rapportvalidation1;
}
public void setRapportvalidation1(RapportValidation rapportvalidation1) {
	this.rapportvalidation1 = rapportvalidation1;
}
public Employe getEmployerapport1() {
	return employerapport1;
}
public void setEmployerapport1(Employe employerapport1) {
	this.employerapport1 = employerapport1;
}
public String getRemarque1() {
	return remarque1;
}
public void setRemarque1(String remarque1) {
	this.remarque1 = remarque1;
}
public String getSignature1() {
	return signature1;
}
public void setSignature1(String signature1) {
	this.signature1 = signature1;
}
public int getValide1() {
	return valide1;
}
public void setValide1(int valide1) {
	this.valide1 = valide1;
}
public Etudiant getEtud1() {
	return etud1;
}
public void setEtud1(Etudiant etud1) {
	this.etud1 = etud1;
}
public String getRapportdepot1() {
	return rapportdepot1;
}
public void setRapportdepot1(String rapportdepot1) {
	this.rapportdepot1 = rapportdepot1;
}
public String getSign() {
	return sign;
}
public void setSign(String sign) {
	this.sign = sign;
}
public int getVal() {
	return val;
}
public void setVal(int val) {
	this.val = val;
}
public MenuModel getModel() {
	return model;
}
public void setModel(MenuModel model) {
	this.model = model;
}
@PostConstruct
public void init() {
    model = new DefaultMenuModel();

    //First submenu
    //DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

    DefaultMenuItem item = new DefaultMenuItem("External");
   
    //Second submenu
    DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

    item = new DefaultMenuItem("Non valid reports");
    item.setIcon("pi pi-save");
    item.setCommand("#{rapportBean.Toupdaterapport}");
    item.setUpdate("messages");
    secondSubmenu.addElement(item);

    item = new DefaultMenuItem("Valid reports");
    item.setIcon("pi pi-times");
    item.setCommand("#{rapportBean.Tovalidrapport}");
    item.setAjax(false);
    secondSubmenu.addElement(item);

    item = new DefaultMenuItem("Non checked reports");
    item.setIcon("pi pi-times");
    item.setCommand("#{rapportBean.Tounonseenrapport}");
    item.setAjax(false);
    secondSubmenu.addElement(item);

    model.addElement(secondSubmenu);
}


}
