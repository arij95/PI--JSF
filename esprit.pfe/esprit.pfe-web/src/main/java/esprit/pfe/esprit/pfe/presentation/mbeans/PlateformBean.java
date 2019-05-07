package esprit.pfe.esprit.pfe.presentation.mbeans;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.servlet.http.Part;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.persistence.SiteUniversity;
import esprit.pfe.esprit.pfe.services.EmployeeService;
import esprit.pfe.esprit.pfe.services.PlateformeService;
import esprit.pfe.esprit.pfe.services.Upload;





@ManagedBean
@SessionScoped
public class PlateformBean {
	 @EJB
	 PlateformeService plateformeService;
	
	
	  
    private  Plateforme plateforme;
    private int id_plateforme;
	private Employe employe;
	private String university;

	private String year;
	private String image;
	private File file;
	private Part part;
	
	
	public String processUpload() {
		UploadHelper uploadHelper = new UploadHelper();
		this.image = uploadHelper.processUpload(this.part);
		return "result";
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
  Employe e = new Employe(1,"arij", "arij", "esprit","arij@arij.com",
			"arij", "arij","Admin");
  public String addPlateforme() throws FileNotFoundException, IOException{
	 
		part.write("C:\\Users\\Y520-I7-1TR-4G\\workspace\\esprit.pfe\\esprit.pfe-web\\src\\main\\webapp\\resources\\images\\"+getFileName(part));
this.image=	getFileName(this.part);

		
  	plateformeService.addinterview(new Plateforme(e, e.getEcoleEmploye(), year,image));

  	System.out.println("aaaaaa"); 	
  	return "result";
  }
  public Plateforme showPlateforme(){
	  	System.out.println("aaaaaa");
	  	plateforme=plateformeService.Plateformeuser(e.getIdEmploye());
	  	System.out.println("aaaaaa"); 
	  	return plateforme;
	  }
  //private List<Plateforme> plateforme;
 // private List<Plateforme> plate;
 
	public Plateforme getPlateforme() {
		return plateforme;
	}
	public void setPlateforme(Plateforme plateforme) {
		this.plateforme = plateforme;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public int getId_plateforme() {
		return id_plateforme;
	}
	public void setId_plateforme(int id_plateforme) {
		this.id_plateforme = id_plateforme;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
	


	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public PlateformeService getPlateformeService() {
		return plateformeService;
	}
	public void setPlateformeService(PlateformeService plateformeService) {
		this.plateformeService = plateformeService;
	}
	
	
	
    
    
}
