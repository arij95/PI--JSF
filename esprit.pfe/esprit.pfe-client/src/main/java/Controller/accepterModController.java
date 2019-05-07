package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.FichePfe;
import esprit.pfe.esprit.pfe.services.EmployeServiceRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class accepterModController implements Initializable{

	@FXML
    private JFXTextField oldFonc;

    @FXML
    private JFXTextField oldPro;

    @FXML
    private JFXTextField newFonc;

    @FXML
    private JFXTextField newPro;

    @FXML
    private JFXButton acc;
    
  
    
    EmployeServiceRemote EmProxy;

    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/EmployeService!esprit.pfe.esprit.pfe.services.EmployeServiceRemote";

    FichePfe f=new FichePfe();
    @FXML
    void Accepter(ActionEvent event) {
    	EmProxy = (EmployeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
    	EmProxy.accepterModif(newFonc.getText(), newPro.getText(), f.getIdFiche());
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Employe em = new Employe(4,"a","a","a","a","a","a","Enseignant");
		EmProxy = (EmployeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		f = EmProxy.getEtudiant(4);
		 //f= EmProxy.getFiche(e.getIdEtudiant());
		oldFonc.setText(f.getFctFiche());
		oldPro.setText(f.getProbleFiche());
		newFonc.setText(f.getNouvfctFiche());
		newPro.setText(f.getNouvprobleFiche());
		
	}

}
