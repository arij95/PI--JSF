package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


	public class AddEmplyeeController implements Initializable{

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

	    @FXML
	    private Button back;
	    
		 SuperAdminRemote proxysuper;
			
			String jndiAbsence = "esprit.pfe-ear/esprit.pfe-ejb/SuperAdmin!esprit.pfe.esprit.pfe.services.SuperAdminRemote";
		
		
		
		
		 @Override
			public void initialize(URL location, ResourceBundle resources) {
				// TODO Auto-generated method stub
				
			}
		 @FXML
		    void add(ActionEvent event) {
			 proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
			 boolean  b=proxysuper.verifecole1(ecole.getText());
			 if(b==true){
				 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			        alert.setTitle("information Dialog");
			        alert.setHeaderText(null);
			        alert.setContentText("This school has already an admin!");
			alert.show();
			 }
			 else
				 
			{
				 
				
				 if (firstname.getText().matches("[A-Za-z ]+")&&lastname.getText().matches("[A-Za-z ]+")&&username.getText().matches("[A-Za-z0-9]+")&&
						 ecole.getText().matches("[A-Za-z0-9]+")&&!email.getText().isEmpty()&&email.getText().contains("@")&&!email.getText().contains(" ")&&
						 (email.getText().endsWith(".com")||email.getText().endsWith(".fr")||email.getText().endsWith(".tn"))) {
					 
					 Employe e=new Employe();
					 e.setEcoleEmploye(ecole.getText()) ;
					 e.setEmailEmploye(email.getText());
					 e.setEmployeRole("Admin");
					 e.setNomEmploye(lastname.getText());
					 String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkl"
								+ "mnopqrstuvwxyz0123456789!@#$%&*()-_=+;:\'\",<.>/?";
						String pwd = RandomStringUtils.random( 15, characters );
					 e.setPasswordEmploye(pwd);
					 e.setPrenomEmploye(firstname.getText());
					 e.setUserNameEmploye(username.getText());
					 e.setFavorie("");
					 e.setFirst("");
					 e.setMaxEnEnca(0);
					 e.setMaxEnPreva(0);
					 e.setMaxEnRap(0);
					 e.setMaxPresid(0);
					 e.setNbmax(0);
					 e.setFirst("");
					 
					 proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
					 proxysuper.ajouteradminecole(e);
					 proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
					 proxysuper.ajouteradminecoleuser(e);
					 
					 try {
						sendMail1(email.getText(),username.getText(),pwd);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();}
						Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				        alert.setTitle("information Dialog");
				        alert.setHeaderText(null);
				        alert.setContentText("Employe will appear now in your list!");
				alert.show();
					
				 }else{
					 Alert alert = new Alert(Alert.AlertType.ERROR);
				        alert.setTitle("information Dialog");
				        alert.setHeaderText(null);
				        alert.setContentText("Error in fields type!");
				alert.show();
				 }
				 
				
			}
		    }
		 @FXML
		    void back(ActionEvent event) throws IOException {
		    	
		    	Stage dashboardStage = new Stage();
				dashboardStage.setTitle("");
				Parent root = FXMLLoader.load(getClass().getResource("/interfaces/GererAdmin.fxml"));
				Scene scene = new Scene(root);
				dashboardStage.setScene(scene);
				dashboardStage.show();
				 Stage stage = (Stage) back.getScene().getWindow();
				    // do what you have to do
				    stage.close();
		    }
		 public void sendMail1(String adresse,String user,String mdp) throws SQLException {
		        Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class",
						"javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");
		              

				Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("raniamnissi1995","rania1234");
						}
					});
		              

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("from@no-spam.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(adresse));
					message.setSubject("Reservation");
					message.setText("You can now access to our platform using your username: "+user+" and your password: "+mdp);

					Transport.send(message);

					System.out.println("Done");
		          
		 

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}

		  }
}
