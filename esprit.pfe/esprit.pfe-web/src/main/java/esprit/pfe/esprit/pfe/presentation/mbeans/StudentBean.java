package esprit.pfe.esprit.pfe.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import esprit.pfe.esprit.pfe.persistence.ClasseStudent;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.Optionne;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.services.PlateformeService;

@ManagedBean(name="StudentBean")
@SessionScoped
public class StudentBean {
	
	
	@EJB
	PlateformeService plateformeservice;
	 private String nomEtudiant;
	    
	   
	    private String prenomEtudiant;
	    
	    
	    private String ecoleEtudiant;
	    
	    
	    private String emailEtudiant;
	    
	    
	    private String passwordEtudiant;
	    
	    
	    private String userNameEtudiant;
	   
	    private int classenum;
	  
	    
	  
		private String optionstudent;
	    
	    
	    private boolean creditPedagogiqueEtudiant;
	    
	    
	    private boolean creditFinaciereEtudiant;
	    private Etudiant etudiant;
	    
	  private Optionne optionne;
	    private int encadrant;

	    private int autorisationEtudiant;
	   

		public String getNomEtudiant() {
			return nomEtudiant;
		}



		public void setNomEtudiant(String nomEtudiant) {
			this.nomEtudiant = nomEtudiant;
		}



		public String getPrenomEtudiant() {
			return prenomEtudiant;
		}



		public void setPrenomEtudiant(String prenomEtudiant) {
			this.prenomEtudiant = prenomEtudiant;
		}



		public String getEcoleEtudiant() {
			return ecoleEtudiant;
		}



		public void setEcoleEtudiant(String ecoleEtudiant) {
			this.ecoleEtudiant = ecoleEtudiant;
		}



		public String getEmailEtudiant() {
			return emailEtudiant;
		}



		public void setEmailEtudiant(String emailEtudiant) {
			this.emailEtudiant = emailEtudiant;
		}



		public String getPasswordEtudiant() {
			return passwordEtudiant;
		}



		public void setPasswordEtudiant(String passwordEtudiant) {
			this.passwordEtudiant = passwordEtudiant;
		}



		public String getUserNameEtudiant() {
			return userNameEtudiant;
		}



		public void setUserNameEtudiant(String userNameEtudiant) {
			this.userNameEtudiant = userNameEtudiant;
		}



		public int getClassenum() {
			return classenum;
		}



		public void setClassenum(int classenum) {
			this.classenum = classenum;
		}



		public String getOptionstudent() {
			return optionstudent;
		}



		public void setOptionstudent(String optionstudent) {
			this.optionstudent = optionstudent;
		}



		public boolean isCreditPedagogiqueEtudiant() {
			return creditPedagogiqueEtudiant;
		}



		public void setCreditPedagogiqueEtudiant(boolean creditPedagogiqueEtudiant) {
			this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
		}



		public boolean isCreditFinaciereEtudiant() {
			return creditFinaciereEtudiant;
		}



		public void setCreditFinaciereEtudiant(boolean creditFinaciereEtudiant) {
			this.creditFinaciereEtudiant = creditFinaciereEtudiant;
		}



		public int getEncadrant() {
			return encadrant;
		}



		public int getAutorisationEtudiant() {
			return autorisationEtudiant;
		}



		public void setAutorisationEtudiant(int autorisationEtudiant) {
			this.autorisationEtudiant = autorisationEtudiant;
		}



		public void setEncadrant(int encadrant) {
			this.encadrant = encadrant;
		}
	    
	    
		public Optionne getOptionne() {
			return optionne;
		}



		public void setOptionne(Optionne optionne) {
			this.optionne = optionne;
		}


		Employe e = new Employe(1,"arij", "arij", "esprit","arij@arij.com",
				"arij", "arij","Admin");
	 Plateforme p= new Plateforme(1, e,e.getEcoleEmploye() , "2018/2019", "1556743890864.jpg");
	  public void addStudent(){
	    	System.out.println("aaaaaa");
	    	plateformeservice.addstudent( new Etudiant(nomEtudiant,prenomEtudiant, p.getUniversity(), emailEtudiant,
	    			 userNameEtudiant, creditPedagogiqueEtudiant,creditFinaciereEtudiant,
	    			 optionstudent, classenum));
	    	System.out.println(opp);
	    	
	    }
	  
	  private List<Optionne> opp;
	    public List<Optionne> getopt(){
	    	System.out.println(opp);
	    	opp= plateformeservice.findOption(p.getId_plateforme());
	    	System.out.println(opp);
	    	return opp;
	    	
	    	
	    }
	  
			
	    private List<ClasseStudent> cl;
	    public List<ClasseStudent> getcla(){
	    	
	    	cl= plateformeservice.findClassee(p.getId_plateforme());
	    	return cl;
	    	
	    }
	  private List<Etudiant> etud;
	    public List<Etudiant> getAllEtudiants(){
	    	etud= plateformeservice.findAllStudent(p.getUniversity());
	    	return etud;
	    	
	    }
	    
	    public void deleteEmployee(int id)
	    {
	    	plateformeservice.deleteStudent(id);
	    	
	    }



		public List<Etudiant> getEtud() {
			return etud;
		}



		public void setEtud(List<Etudiant> etud) {
			this.etud = etud;
		}



		public List<Optionne> getOpp() {
			return opp;
		}



		public void setOpp(List<Optionne> opp) {
			this.opp = opp;
		}



		public List<ClasseStudent> getCl() {
			return cl;
		}



		public void setCl(List<ClasseStudent> cl) {
			this.cl = cl;
		}



		public Etudiant getEtudiant() {
			return etudiant;
		}



		public void setEtudiant(Etudiant etudiant) {
			this.etudiant = etudiant;
		}
		
}
