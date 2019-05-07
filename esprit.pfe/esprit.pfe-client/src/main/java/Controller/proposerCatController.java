package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Categorie;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.services.CatServiceRemote;
import esprit.pfe.esprit.pfe.services.EmployeServiceRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class proposerCatController implements Initializable{

	  @FXML
	    private JFXTextField cat;

	    @FXML
	    private JFXButton acc;
	    
	    @FXML
	    private JFXComboBox<String> categorie;

	    @FXML
	    private JFXButton choose;

	    
	    CatServiceRemote CatProxy;
	    
	    EmployeServiceRemote EmProxy;

	    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/CatService!esprit.pfe.esprit.pfe.services.CatServiceRemote";
	    String jndiLogin1 = "esprit.pfe-ear/esprit.pfe-ejb/EmployeService!esprit.pfe.esprit.pfe.services.EmployeServiceRemote";
	   
	    @FXML
	    void acceept(ActionEvent event) {
	    	Categorie c= new Categorie(cat.getText());
	    	CatProxy = (CatServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	CatProxy.ajoutCat(c);
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		CatProxy = (CatServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		
		ArrayList<Categorie> la= CatProxy.reupCat();
		for(Categorie i : la){
			categorie.getItems().addAll(i.getNom());
		}
		choose.setOnAction(click->{
			EmProxy = (EmployeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin1);
			Employe em = new Employe(1,"a","a","a","a","a","a","Enseignant");
			EmProxy.FavCat(em.getIdEmploye(),categorie.getValue());
			
		});
	}

}
