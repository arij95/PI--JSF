package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.services.EtudiantServiceRemote;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class annulController implements Initializable{

    @FXML
    private JFXTextField ms;

    @FXML
    private JFXButton can;
    EtudiantServiceRemote EtudiantProxy;
    VerifRemote proxyAbsencee;
    String jndiLogin1 = "esprit.pfe-ear/esprit.pfe-ejb/EtudiantService!esprit.pfe.esprit.pfe.services.EtudiantServiceRemote";
    String jndiAbsence1="esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		EtudiantProxy = (EtudiantServiceRemote)EJBLookUpUtil.doLookup(jndiLogin1);
		can.setOnAction(clcik->{
			proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
			EtudiantProxy.annulation(proxyAbsencee.userconnected().getId(), 1, ms.getText());
		});
		
		
	}

}
