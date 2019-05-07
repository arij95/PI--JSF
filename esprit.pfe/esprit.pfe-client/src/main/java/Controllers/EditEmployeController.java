package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;

import esprit.pfe.esprit.pfe.persistence.Employe;

import esprit.pfe.esprit.pfe.services.SuperAdminRemote;

import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


	public class EditEmployeController implements Initializable{

		@FXML
	    private TextField username;

	    @FXML
	    private TextField email;

	  

	    @FXML
	    private TextField firstname;

	    @FXML
	    private TextField lastname;

	    @FXML
	    private TextField ecole;

	    @FXML
	    private Button addemp;

	    
		 SuperAdminRemote proxysuper;
			
			String jndiAbsence = "esprit.pfe-ear/esprit.pfe-ejb/SuperAdmin!esprit.pfe.esprit.pfe.services.SuperAdminRemote";
			Employe e=new Employe();
			
		String a="";
			public void setAdmin(Employe h,int id){
				
			                
			    
				e.setIdEmploye(id);
			
			      this.username.setText(h.getUserNameEmploye());
			      this.email.setText(h.getEmailEmploye());
			      this.firstname.setText(h.getPrenomEmploye());
			      this.lastname.setText(h.getNomEmploye());
			      this.ecole.setText(h.getEcoleEmploye());
			      
			      a=h.getEcoleEmploye();
			      
			}
				
			
		
		 @Override
			public void initialize(URL location, ResourceBundle resources) {
			 addemp.setOnAction(new EventHandler<ActionEvent>() {
		            
		            @Override
		public void handle(ActionEvent event) {
		            	proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
		            	if(!proxysuper.verifecole(ecole.getText(),a)){
						 if (firstname.getText().matches("[A-Za-z ]+")&&lastname.getText().matches("[A-Za-z ]+")&&username.getText().matches("[A-Za-z0-9]+")&&
								 ecole.getText().matches("[A-Za-z0-9]+")&&!email.getText().isEmpty()&&email.getText().contains("@")&&!email.getText().contains(" ")&&
								 (email.getText().endsWith(".com")||email.getText().endsWith(".fr")||email.getText().endsWith(".tn"))) {
				e.setEcoleEmploye(ecole.getText());
				e.setEmailEmploye(email.getText());
				e.setEmployeRole("Admin");
				e.setNomEmploye(lastname.getText());
				e.setPrenomEmploye(firstname.getText());
				e.setUserNameEmploye(username.getText());
				proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
				proxysuper.modifadmin(e);
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	            alert.setTitle("information Dialog");
	            alert.setHeaderText(null);
	            alert.setContentText("Your employe is now edited!");
	            alert.show();
						 }else{
							 Alert alert = new Alert(Alert.AlertType.ERROR);
						        alert.setTitle("information Dialog");
						        alert.setHeaderText(null);
						        alert.setContentText("Error in fields type!");
						alert.show();
						 }}else{
							 Alert alert = new Alert(Alert.AlertType.ERROR);
						        alert.setTitle("information Dialog");
						        alert.setHeaderText(null);
						        alert.setContentText("Can not have 2 admin for one school!");
						alert.show();
						 }
	            
		            }});
			}
		 @FXML
		    void add(ActionEvent event) {
			 
			 
			}
		    
		 
		  
}
