package Controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Categorie;
import esprit.pfe.esprit.pfe.persistence.FichePfe;
import esprit.pfe.esprit.pfe.services.CatServiceRemote;
import esprit.pfe.esprit.pfe.services.EmployeServiceRemote;
import esprit.pfe.esprit.pfe.services.FicheServiceRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class preValideController implements Initializable{

	@FXML
    private TableView<FichePfe> tb;

    @FXML
    private TableColumn<FichePfe, String> tit;

    @FXML
    private TableColumn<FichePfe, String> desc;

    @FXML
    private TableColumn<FichePfe, String> fonc;

    @FXML
    private TableColumn<FichePfe, String> prob;

    @FXML
    private JFXButton pre;

    @FXML
    private JFXTextField prob1;

    @FXML
    private JFXTextField fonc1;

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
    private JFXTextField de;

    @FXML
    private JFXComboBox<String> cat;

    @FXML
    private JFXButton rej;
    @FXML
    private JFXTextField etat;
    @FXML
    private AnchorPane an;
	
    FicheServiceRemote FicheProxy;
    CatServiceRemote CatProxy;
    EmployeServiceRemote EmployeProxy;
    
    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/FicheService!esprit.pfe.esprit.pfe.services.FicheServiceRemote";
    
    String jndiLogin2 = "esprit.pfe-ear/esprit.pfe-ejb/EmployeService!esprit.pfe.esprit.pfe.services.EmployeServiceRemote";
    String jndiLogin3 = "esprit.pfe-ear/esprit.pfe-ejb/CatService!esprit.pfe.esprit.pfe.services.CatServiceRemote";
    ArrayList<FichePfe> fiches=new ArrayList<FichePfe>();
	
    FichePfe f= new FichePfe();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		FicheProxy = (FicheServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		pre.setVisible(false);
		EmployeProxy = (EmployeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin2);
		CatProxy = (CatServiceRemote)EJBLookUpUtil.doLookup(jndiLogin3);
		ArrayList<Categorie> la= CatProxy.reupCat();
		for(Categorie i : la){
			cat.getItems().addAll(i.getNom());
		}
		fiches=FicheProxy.afficherPre(4);
		ObservableList obs1=FXCollections.observableArrayList(fiches);
	     tb.setItems(obs1);
	     tit.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("titreFiche"));
	     desc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("descriptionFiche"));
	     fonc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("fctFiche"));
	     prob.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("probleFiche"));
	     
	     tb.setOnMouseClicked(click->{
	    	 f=tb.getSelectionModel().getSelectedItem();
		     
	    	 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
	 		String strDate = dateFormat.format(f.getAnneeFiche());  
	 	 	titre.setText(f.getTitreFiche());
	 		de.setText(f.getDescriptionFiche());
	 		prob1.setText(f.getProbleFiche());
	 		fonc1.setText(f.getFctFiche());
	 		cat.setValue(f.getCategFiche());
	 		mot.setText(f.getMotCleFiche());
	 		ent.setText(f.getEntrepFiche());
	 		ann.setPromptText(strDate);
	 		//(f.getAnneeFiche().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	 		pays.setText(f.getPaysFiche());
	 		ecole.setText(f.getEcoleFiche());
	 		if(f.getEtatFiche()==0){
	 			etat.setText("Non traitee");
	 		}
	 		else if (f.getEtatFiche()==1){
	 		etat.setText("traite");}
	 		else if (f.getEtatFiche()==2){
	 			etat.setText("pre-validate");
	 		}
	 		if(f.getEtatFiche()!=2){
	 			pre.setVisible(true);
	 			pre.setOnAction(cli->{
	 				FicheProxy.preVal(f.getIdFiche(), 2);
	 				fiches=FicheProxy.afficherPre(4);
	 				ObservableList obs2=FXCollections.observableArrayList(fiches);
	 			     tb.setItems(obs2);
	 			     tit.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("titreFiche"));
	 			     desc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("descriptionFiche"));
	 			     fonc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("fctFiche"));
	 			     prob.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("probleFiche"));
	 				 TrayNotification tray =new TrayNotification();
			            tray.setTitle("Success");
			        tray.setMessage("The Pfe plug is pre-valdiated");
			        tray.setNotificationType(NotificationType.SUCCESS);
			        tray.showAndWait();
			        tb.refresh();
	 			});
	 		}else
	 		{
	 			pre.setVisible(false);
	 		}
	 		rej.setOnAction(cli->{
	 			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");  
				String strDate1 = dateFormat1.format(Date.from(ann.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));  
	 			FichePfe f1=new FichePfe(titre.getText(),desc.getText(),prob.getText(),fonc.getText(),cat.getValue(),mot.getText(),ent.getText(),pays.getText(),ecole.getText(),0,f.getVersion());
	 			FicheProxy.reject(f1, f.getIdFiche(), strDate1, 0);
	 			fiches=FicheProxy.afficherPre(4);
	 			ObservableList obs3=FXCollections.observableArrayList(fiches);
	 		     tb.setItems(obs3);
	 		     tit.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("titreFiche"));
	 		     desc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("descriptionFiche"));
	 		     fonc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("fctFiche"));
	 		     prob.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("probleFiche"));
	 		});
	     });
	     
	    	 
	     
	 	
	 	
	 	
	 	

}}
