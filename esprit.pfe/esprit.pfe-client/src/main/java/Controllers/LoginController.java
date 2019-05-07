package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.media.jfxmedia.MediaManager;

import esprit.pfe.esprit.pfe.persistence.user;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable{

    @FXML
    private StackPane rootPane;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private ImageView imgProgress;
    
    
    

    VerifRemote proxyverif;
	
	String jndiAbsence = "esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";

	 @Override
		public void initialize(URL location, ResourceBundle resources) {
		 Media m = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + "/" + "/src/main/resources/res/FrankSinatra-Killingmesoftly.mp3");
	        MediaPlayer player = new MediaPlayer(m);
	        player.play();
		}
	 
	
	 
	 
    @FXML
    void login(ActionEvent event) throws IOException {
 	proxyverif = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence);
    boolean b=true;
    user u=null;
    		u=proxyverif.verif(txtUsername.getText());
    		if(txtUsername.getText().equals("root")&&txtPassword.getText().equals("root")){
    			Stage dashboardStage = new Stage();
    		dashboardStage.setTitle("");
    		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/AddEmployee.fxml"));
    		Scene scene = new Scene(root);
    		dashboardStage.setScene(scene);
    		dashboardStage.show();
    		 Stage stage = (Stage) btnLogin.getScene().getWindow();
    		    // do what you have to do
    		    stage.close();
    			
    		}
    		
    		
    		else if(u==null){
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    	        alert.setTitle("information Dialog");
    	        alert.setHeaderText(null);
    	        alert.setContentText("This email does not exist!");
    	        alert.show();
    		}
    		else if (u.getMdp().equals(txtPassword.getText()))
    {
    	try{
    	System.out.println("ok");
    	Stage dashboardStage = new Stage();
		dashboardStage.setTitle("");
		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/EtudiantEnregistrement.fxml"));
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
    else if(u.getMdp()!=txtPassword.getText()){
    	System.out.println(u.getMdp()+"---"+txtPassword.getText());
    	Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Either username or password are incorrect!");
        alert.show();
    }
    }

}
