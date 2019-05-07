package projet.pi.pfe.client.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.services.EmployeeServiceRemote;
import esprit.pfe.esprit.pfe.services.PlateformeServiceRemote;
import esprit.pfe.esprit.pfe.services.SuperAdminRemote;
import esprit.pfe.esprit.pfe.services.Upload;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;


import  javax.ejb.EJBException;
public class PlateformeController implements Initializable{
	 File selectedfile;
	    String path_img;
	    Upload u = new Upload();
	 
	    @FXML
	    private JFXTextField annee;
	    
	    @FXML
	    private JFXButton ajouter;
	    @FXML
	    private JFXButton browse;
	    @FXML
	    private ListView<String> logo;
	    
	    PlateformeServiceRemote PlateformeProxy;
	    VerifRemote proxyAbsencee;
	    EmployeeServiceRemote EmployeeProxy;
	    String jndi = "esprit.pfe-ear/esprit.pfe-ejb/PlateformeService!esprit.pfe.esprit.pfe.services.PlateformeServiceRemote";
	    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/PlateformeService!esprit.pfe.esprit.pfe.services.PlateformeServiceRemote";
		
	    String jndiAbsence1="esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
	    SuperAdminRemote proxysuper;
		
		String jndiAbsence = "esprit.pfe-ear/esprit.pfe-ejb/SuperAdmin!esprit.pfe.esprit.pfe.services.SuperAdminRemote";
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	
	    	}
	    @FXML
 	private void ajouter( ActionEvent event) throws IOException {
	    	proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
			
			Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getId());
			PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
			proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
			Plateforme  p = new Plateforme(e,e.getEcoleEmploye(),
	    	
	    	(annee.getText()),
	    	(selectedfile.getName()));
			PlateformeProxy.addinterview(p);
			//EmployeeProxy = (EmployeeServiceRemote)EJBLookUpUtil.doLookup(jndi);
			e.setFirst("aaa");
			proxysuper.modifadmin(e);
	    	  FileChooser fc = new FileChooser();
	          fc.getExtensionFilters().addAll(
	                  new FileChooser.ExtensionFilter("image","*.jpg", "*.png")
	          );
		
 	
		System.out.println("aaaaaaaaaa");
	}    
@FXML
private void browse( ActionEvent event) throws IOException {
	
      
             
      FileChooser fc = new FileChooser();
     fc.getExtensionFilters().addAll(
             new FileChooser.ExtensionFilter("image","*.jpg", "*.png")
     );
     selectedfile = fc.showOpenDialog(null);
     if (selectedfile != null) {
         System.out.println("aaaaaaaaaa");
         Upload u= new Upload();
          try {
              u.upload(selectedfile);
          } catch (IOException ex) {
              Logger.getLogger(PlateformeController.class.getName()).log(Level.SEVERE, null, ex);
          }
          logo.getItems().add(selectedfile.getName());

         path_img = selectedfile.getAbsolutePath();
         System.out.println("sssssssssssssssss");
     } else {
         System.out.println("FICHIER erroné");
     }
 

         

}
}
