package Controllers;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;

import esprit.pfe.esprit.pfe.persistence.user;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInLeftTransition;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInLeftTransition1;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInRightTransition;


public class Login2Controller implements Initializable{

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Text lblWelcome;

    @FXML
    private Text lblUserLogin;

    @FXML
    private Text lblUsername;

    @FXML
    private Text lblPassword;

    @FXML
    private Button btnLogin;
    @FXML
    private Button en;

    @FXML
    private Text lblRudyCom;

    @FXML
    private Label lblClose;
    

   
    	 @Override
    	    public void initialize(URL location, ResourceBundle resources) {
    		 Media m = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + "/" + "/src/main/resources/res/FrankSinatra-Killingmesoftly.mp3");
 	        MediaPlayer player = new MediaPlayer(m);
 	        player.play();
    	        Platform.runLater(() -> {
    	            new FadeInRightTransition(lblUserLogin).play();
    	            new FadeInLeftTransition(lblWelcome).play();
    	            new FadeInLeftTransition1(lblPassword).play();
    	            new FadeInLeftTransition1(lblUsername).play();
    	            new FadeInLeftTransition1(txtUsername).play();
    	            new FadeInLeftTransition1(txtPassword).play();
    	            new FadeInRightTransition(btnLogin).play();

    	            lblClose.setOnMouseClicked((MouseEvent event) -> Platform.exit());
    	        });

    	    }

    	    VerifRemote proxyverif;
    		
    		String jndiAbsence = "esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
    		 @FXML
     	    void en(ActionEvent event) throws IOException  {
    			 Stage dashboardStage = new Stage();
 				dashboardStage.setTitle("");
 				Parent root = FXMLLoader.load(getClass().getResource("/interfaces/EtudiantEnregistrement.fxml"));
 				Scene scene = new Scene(root);
 				dashboardStage.setScene(scene);
 				dashboardStage.show();
 				 Stage stage = (Stage) en.getScene().getWindow();
 				    // do what you have to do
 				    stage.close();
    			 
    		 }
    	 @FXML
    	    void aksiLogin(ActionEvent event) throws IOException  {
    		 
    		 proxyverif = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence);
    		    boolean b=true;
    		    user u=null;
    		    		u=proxyverif.verif(txtUsername.getText());
    		    		System.out.println(u);
    		    		////////////////ADMIN
    		    		if(txtUsername.getText().equals("root")&&txtPassword.getText().equals("root")){
    		    			Stage dashboardStage = new Stage();
    		    		dashboardStage.setTitle("");
    		    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/GererAdmin.fxml"));
    		    		Scene scene = new Scene(root);
    		    		dashboardStage.setScene(scene);
    		    		dashboardStage.show();
    		    		 Stage stage = (Stage) btnLogin.getScene().getWindow();
    		    		    // do what you have to do
    		    		    stage.close();
    		    			
    		    		}
    		    		/////////////////NOT FOUND
    		    		
    		    		else if(u==null){
    		    			Alert alert = new Alert(Alert.AlertType.ERROR);
    		    	        alert.setTitle("information Dialog");
    		    	        alert.setHeaderText(null);
    		    	        alert.setContentText("Either username or password are incorrect!");
    		    	        alert.show();
    		    		}
    		    		////////////EXIST
    		    		else if (u.getMdp().equals(txtPassword.getText()))
    		    {
    		    if(u.getRole()==1){
    		    			proxyverif = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence);
    		    System.out.println(u.getId());
	    		proxyverif.turn1connected(u.getId());;
    		    	try{
    		    		
    		    		
    		    	
    		    	Stage dashboardStage = new Stage();
    				dashboardStage.setTitle("");
    				Parent root = FXMLLoader.load(getClass().getResource("/Gui/formMenuEtu.fxml"));
    				Scene scene = new Scene(root);
    				dashboardStage.setScene(scene);
    				dashboardStage.show();
    				 Stage stage = (Stage) btnLogin.getScene().getWindow();
    				    // do what you have to do
    				    stage.close();
    		    	} catch (IOException ex) {
    		            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    		}

    				
    		    }
    		    else if (u.getRole()==2){
    		    	proxyverif = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence);
        		    System.out.println(u.getId());
    	    		proxyverif.turn1connected(u.getId());;
        		    	try{
        		    		
        		    		
        		    	
        		    	Stage dashboardStage = new Stage();
        				dashboardStage.setTitle("");
        				Parent root = FXMLLoader.load(getClass().getResource("/fxml/formMenu.fxml"));
        				Scene scene = new Scene(root);
        				dashboardStage.setScene(scene);
        				dashboardStage.show();
        				 Stage stage = (Stage) btnLogin.getScene().getWindow();
        				    // do what you have to do
        				    stage.close();
        		    	} catch (IOException ex) {
        		            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        		}
    		    }
    		    
    		    }
    		    else if(u.getMdp()!=txtPassword.getText()){
    		    	System.out.println(u.getMdp()+"---"+txtPassword.getText());
    		    	Alert alert = new Alert(Alert.AlertType.ERROR);
    		        alert.setTitle("information Dialog");
    		        alert.setHeaderText(null);
    		        alert.setContentText("Either username or password are incorrect!");
    		        alert.show();
    		    }

    		 
    		 
    		 
    		 
    }
    	 public TextField getTxtUsername() {
    	        return txtUsername;
    	    }

    	    public void setTxtUsername(TextField txtUsername) {
    	        this.txtUsername = txtUsername;
    	    }

    	    public PasswordField getTxtPassword() {
    	        return txtPassword;
    	    }

    	    public void setTxtPassword(PasswordField txtPassword) {
    	        this.txtPassword = txtPassword;
    	    }

    	    public Text getLblWelcome() {
    	        return lblWelcome;
    	    }

    	    public void setLblWelcome(Text lblWelcome) {
    	        this.lblWelcome = lblWelcome;
    	    }

    	    public Text getLblUserLogin() {
    	        return lblUserLogin;
    	    }

    	    public void setLblUserLogin(Text lblUserLogin) {
    	        this.lblUserLogin = lblUserLogin;
    	    }

    	    public Text getLblUsername() {
    	        return lblUsername;
    	    }

    	    public void setLblUsername(Text lblUsername) {
    	        this.lblUsername = lblUsername;
    	    }

    	    public Text getLblPassword() {
    	        return lblPassword;
    	    }

    	    public void setLblPassword(Text lblPassword) {
    	        this.lblPassword = lblPassword;
    	    }

    	    public Button getBtnLogin() {
    	        return btnLogin;
    	    }

    	    public void setBtnLogin(Button btnLogin) {
    	        this.btnLogin = btnLogin;
    	    }

    	    public Text getLblRudyCom() {
    	        return lblRudyCom;
    	    }

    	    public void setLblRudyCom(Text lblRudyCom) {
    	        this.lblRudyCom = lblRudyCom;
    	    }

    	    public Label getLblClose() {
    	        return lblClose;
    	    }

    	    public void setLblClose(Label lblClose) {
    	        this.lblClose = lblClose;
    	    }

    	  
}
