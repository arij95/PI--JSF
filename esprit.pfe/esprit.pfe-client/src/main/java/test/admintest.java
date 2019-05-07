package test;

import javax.naming.NamingException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class admintest extends Application {

	public static void main(String[] args) throws NamingException
	{
		
		  
		  launch(args);
   
	}
	
	public void start(Stage stage) throws Exception {
		
       // FXMLLoader loader = new FXMLLoader();
		//FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
       // Parent rootNode =  FXMLLoader.load(getClass().getClassLoader().getResource("/fxml/Login.fxml"));
        String fxmlFile = "/interfaces/login2.fxml";
      
      //  FXMLLoader loader = new FXMLLoader();
        Parent rootNode = FXMLLoader.load(getClass().getResource(fxmlFile));

       // log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 600, 400);
        
       // Scene scene = new Scene(rootNode, 400, 200);

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    

	}

}
