package Controllers;


import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Session;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.services.ExistEmailRemote;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;

public class EtudiantEnregistrementController implements Initializable{
	@FXML
	private JFXTextField email;
	@FXML
	private JFXButton butt;
	@FXML
	private JFXButton back;
	@FXML
	private Button play;
	@FXML
	private Button pause;
	@FXML
	private Button reload;
	@FXML
	private ImageView img;
	@FXML
	private MediaView mv;
	private MediaPlayer mp;
	private Media me;
	ExistEmailRemote proxyAbsence;
	VerifRemote proxyAbsencee;
	
	String jndiAbsence = "esprit.pfe-ear/esprit.pfe-ejb/ExistEmail!esprit.pfe.esprit.pfe.services.ExistEmailRemote";
	String jndiAbsence1="esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
	// Event Listener on TextField[#email].onAction
	@FXML
	public void email(ActionEvent event) {
		
	}
	 @FXML
	    void back(ActionEvent event) throws IOException {
	    	
	    	Stage dashboardStage = new Stage();
			dashboardStage.setTitle("");
			Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Login2.fxml"));
			Scene scene = new Scene(root);
			dashboardStage.setScene(scene);
			dashboardStage.show();
			 Stage stage = (Stage) back.getScene().getWindow();
			    // do what you have to do
			    stage.close();
	    }
	// Event Listener on Button[#butt].onAction
	@FXML
	public void butt(ActionEvent event) throws IOException {
		String adresse=email.getText();
		 if (!email.getText().isEmpty()&&email.getText().contains("@")&&!email.getText().contains(" ")&&
				 (email.getText().endsWith(".com")||email.getText().endsWith(".fr")||email.getText().endsWith(".tn"))) {
		
		proxyAbsence = (ExistEmailRemote) EJBLookUpUtil.doLookup(jndiAbsence);
		
		

		 Etudiant s= proxyAbsence.exist(adresse);
		 System.out.println(s);

		 
		  if (s==null){
				try {
					sendMail2(adresse);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				 }
		  
		  else if (s.getAutorisationEtudiant()==1&&s.getEnregistrement()==0){
		try {
			proxyAbsence = (ExistEmailRemote) EJBLookUpUtil.doLookup(jndiAbsence);
			proxyAbsence.turn1(s.getIdEtudiant());

			sendMail(adresse,s.getIdEtudiant());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 }
		 else if (s.getAutorisationEtudiant()==0){
				try {
					sendMail1(adresse);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				 }
		 else if (s.getAutorisationEtudiant()==1&&s.getEnregistrement()==1){
			 try {
					sendMail3(adresse);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				 }
		 

		

		 
		 
		 
		 
		 
		 email.setText("");
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You are going to recieve an email with further instructions");
alert.show();
		 }else{
			 Alert alert = new Alert(Alert.AlertType.ERROR);
		        alert.setTitle("information Dialog");
		        alert.setHeaderText(null);
		        alert.setContentText("Error in your email format!");
		alert.show();
		 }
}private String Dir = System.getProperty("user.dir");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		   
		
		
		 String path=new File(Dir,"/src/main/resources/res/a.mp4").getAbsolutePath();
		 me=new Media(new File(path).toURI().toString());
		 mp=new MediaPlayer(me);
		 mv.setMediaPlayer(mp);
		 mp.setAutoPlay(true);
		 mv.setFitHeight(200);
		 mv.setFitWidth(400);
		 
		 
		
	}
	public void play(ActionEvent event){
		mp.play();
	}
	public void pause(ActionEvent event){
		mp.pause();
	}
	public void reload(ActionEvent event){
		mp.seek(mp.getStartTime());
		mp.play();
	}

	
	
	public void sendMail(String adresse,int id) throws SQLException {
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
			message.setSubject("SignUp");
			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkl"
					+ "mnopqrstuvwxyz0123456789!@#$%&*()-_=+;:\'\",<.>/?";
			String pwd = RandomStringUtils.random( 15, characters );
			System.out.println( pwd );
			proxyAbsence = (ExistEmailRemote) EJBLookUpUtil.doLookup(jndiAbsence);
			proxyAbsence.mdp(pwd,id);
			proxyAbsence = (ExistEmailRemote) EJBLookUpUtil.doLookup(jndiAbsence);
			proxyAbsence.ajouteretudiantuser(email.getText(),pwd);
			QR(pwd);
			message.setText("Congratulation! From now you can access to "
					+ "the application with your email and this password   "+pwd);
			

			Transport.send(message);

			System.out.println("Done");
          
 

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

  }
	public void sendMail1(String adresse) throws SQLException {
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
			message.setSubject("SignUp");
			message.setText("You don't have the authorisation to access to"
					+ " the application please contact your internship director ");

			Transport.send(message);

			System.out.println("Done");
          
 

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

  }
	
	public void sendMail2(String adresse) throws SQLException {
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
			message.setSubject("SignUp");
			message.setText("Your adresse is not found in our data base please contact the administration");

			Transport.send(message);

			System.out.println("Done");
          
 

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

  }
	public void sendMail3(String adresse) throws SQLException {
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
			message.setSubject("SignUp");
			message.setText("You have already send a request! Please check your email!");

			Transport.send(message);

			System.out.println("Done");
          
 

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

  }
	
	public void QR(String mdp) {
	Map hints = new HashMap();
	hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
	QRCodeWriter writer = new QRCodeWriter();
	BitMatrix bitMatrix = null;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	try {
	    // Create a qr code with the url as content and a size of 250x250 px
	    bitMatrix = writer.encode("Email: "+email.getText()+"\nPassword: "+mdp, BarcodeFormat.QR_CODE, 250, 250, hints);
	    MatrixToImageConfig config = new MatrixToImageConfig(MatrixToImageConfig.BLACK, MatrixToImageConfig.WHITE);
	    // Load QR image
	    BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, config);
	    // Load logo image
	    
	    File file = new File(Dir,"\\src\\main\\resources\\res\\esprit-logo-png-1.png");
	    BufferedImage logoImage = ImageIO.read(file);
	    // Calculate the delta height and width between QR code and logo
	    int deltaHeight = qrImage.getHeight() - logoImage.getHeight();
	    int deltaWidth = qrImage.getWidth() - logoImage.getWidth();
	    // Initialize combined image
	    BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) combined.getGraphics();
	    // Write QR code to new image at position 0/0
	    g.drawImage(qrImage, 0, 0, null);
	    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	    // Write logo into combine image at position (deltaWidth / 2) and
	    // (deltaHeight / 2). Background: Left/Right and Top/Bottom must be
	    // the same space for the logo to be centered
	    g.drawImage(logoImage, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);
	    // Write combined image as PNG to OutputStream
	    ImageIO.write(combined, "png", new File(Dir,"\\src\\main\\resources\\res\\QR"+email.getText()+".png"));
	    System.out.println("done");
	} catch (Exception e) {
	    System.out.println(e);
	}  
	}
	
}
