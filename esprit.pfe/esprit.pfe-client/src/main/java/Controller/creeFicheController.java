package Controller;

import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Archive;
import esprit.pfe.esprit.pfe.persistence.Categorie;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.FichePfe;
import esprit.pfe.esprit.pfe.services.ArchiveServiceRemote;
import esprit.pfe.esprit.pfe.services.CatServiceRemote;
import esprit.pfe.esprit.pfe.services.FicheServiceRemote;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class creeFicheController implements Initializable{
	@FXML
	private JFXTextField de;
    @FXML
    private JFXTextField prob;
    @FXML
    private JFXTextField fonc;
    @FXML
    private JFXComboBox<String> cat;
    @FXML
    private JFXTextField mot;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextField ent;
    @FXML
    private JFXTextField pays;
    @FXML
    private JFXTextField ecole;
    @FXML
    private JFXDatePicker ann;
    
    @FXML
    private JFXButton cree;
    FicheServiceRemote FicheProxy;
    CatServiceRemote CatProxy;
    ArchiveServiceRemote ArProxy;
    VerifRemote proxyAbsencee;
    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/FicheService!esprit.pfe.esprit.pfe.services.FicheServiceRemote";
    String jndiLogin1 = "esprit.pfe-ear/esprit.pfe-ejb/CatService!esprit.pfe.esprit.pfe.services.CatServiceRemote";
    String jndiLogin2 = "esprit.pfe-ear/esprit.pfe-ejb/ArchiveService!esprit.pfe.esprit.pfe.services.ArchiveServiceRemote";
    String jndiAbsence1="esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		FicheProxy = (FicheServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		CatProxy = (CatServiceRemote)EJBLookUpUtil.doLookup(jndiLogin1);
		ArProxy = (ArchiveServiceRemote)EJBLookUpUtil.doLookup(jndiLogin2);
		
		ArrayList<Categorie> la= CatProxy.reupCat();
		for(Categorie i : la){
			cat.getItems().addAll(i.getNom());
		}
		 
	}
	@FXML
	private void ajouter( ActionEvent event){
		
		proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Etudiant e=proxyAbsencee.selectetudiantconnected(proxyAbsencee.userconnected().getIdrole());
		System.out.println(e);
		
		FichePfe p= new FichePfe(titre.getText(),de.getText(),prob.getText(),fonc.getText(),cat.getValue(),mot.getText(),ent.getText(),Date.from(ann.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),pays.getText(),ecole.getText(),e,0,-1,-1);
		Archive a= new Archive(p.getIdFiche()+1,titre.getText(),de.getText(),prob.getText(),fonc.getText(),cat.getValue(),mot.getText(),ent.getText(),Date.from(ann.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),pays.getText(),ecole.getText(),e.getIdEtudiant(),0);
		FicheProxy = (FicheServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		if(FicheProxy.verif(e.getIdEtudiant())==null)
		{FicheProxy.creefiche(p);
		ArProxy.creeArchive(a);}
		else{
			TrayNotification tray =new TrayNotification();
            tray.setTitle("ERROR");
        tray.setMessage("You already have a PFE plug");
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndWait();
		}
	}

}
