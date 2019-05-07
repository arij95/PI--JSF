package esprit.pfe.esprit.pfe.presentation.mbeans;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.services.EmployeeService;

@ManagedBean
@SessionScoped
public class EmployeeManagementBean {
	
	  @EJB
	  EmployeeService employeservice;
	  
	    private String nomEmploye;
	    
	  
		 
	    private String prenomEmploye;
	    
	   
	    private String ecoleEmploye;
	    
	    
	    private String emailEmploye;
	    
	    
	    private String passwordEmploye;
	    
		   
	    private String userNameEmploye;
		private String employeRole;

	    private int nbmax;
	    private String favorie;
	    private String first;
	  
	    public String getFirst() {
			return first;
		}
		public void setFirst(String first) {
			this.first = first;
		}

		
	    
		   
		    private int maxEnRap;
		    private int maxEnEnca;
		    private int maxEnPreva;
		    private int maxPresid;
		  
		    private Plateforme plateforme;
		    private List<Employe> employees;
			public EmployeeService getEmployeservice() {
				return employeservice;
			}
			public void setEmployeservice(EmployeeService employeservice) {
				this.employeservice = employeservice;
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
			public String getEmployeRole() {
				return employeRole;
			}
			public void setEmployeRole(String employeRole) {
				this.employeRole = employeRole;
			}
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
			public Plateforme getPlateforme() {
				return plateforme;
			}
			public void setPlateforme(Plateforme plateforme) {
				this.plateforme = plateforme;
			}
			
			 public List<Employe> getEmployees() {
				return employees;
			}
			public void setEmployees(List<Employe> employees) {
				this.employees = employees;
			}




			Employe e = new Employe(1,"arij", "arij", "esprit","arij@arij.com",
						"arij", "arij","Admin");
			 Plateforme p= new Plateforme(1, e,e.getEcoleEmploye() , "2018/2019", "1556743890864.jpg");
			  public void addEmploye(){
			    	System.out.println("aaaaaa");
			    	employeservice.addemployee( new Employe(nomEmploye,  prenomEmploye,  emailEmploye,
							  userNameEmploye, employeRole,p.getUniversity()));
			    	System.out.println("aaaaaa");
			    	
			    }
			 
			    public List<Employe> getAllEmployees(){
			    	employees= employeservice.findEmployee(p.getUniversity());
			    	return employees;
			    	
			    }
			    
			    public void deleteEmployee(int id)
			    {
			    	employeservice.deleteEmploye(id);
			    	
			    }
			    private Integer emplup;
			    public String EditEmployee(Employe employees) throws IOException
			    {
			    	this.setNomEmploye(employees.getNomEmploye());
			    	this.setPrenomEmploye(employees.getPrenomEmploye());
			    	this.setUserNameEmploye(employees.getUserNameEmploye());
			    	this.setEmailEmploye(employees.getEmailEmploye());
			    	this.setEmployeRole(employees.getEmployeRole());
			    	this.setEmplup(employees.getIdEmploye());
			    	return "EditEmployee.xhtml?faces-redirect=true";
			    	
			    }
			    public String updateEmploye(){
			    	
			    	employeservice.updateEmployee( new Employe(emplup,nomEmploye,  prenomEmploye, p.getUniversity() ,
			    			emailEmploye,
							  userNameEmploye, employeRole));
			    	return "showAllEmployee.xhtml?faces-redirect=true";
			    	
			    }
			    
			    public String doupdate(){
		    		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		    		return "arij/EditEmployee?faces-redirect=true";
		    		
		    	}
			    public void forward() throws IOException{
			        String uri = "arij/EditEmploye.xhtml";
			        FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
			    }
				public Integer getEmplup() {
					return emplup;
				}
				public void setEmplup(Integer emplup) {
					this.emplup = emplup;
				}
				
				
}
