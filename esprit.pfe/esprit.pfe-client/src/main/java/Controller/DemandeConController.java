package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Convention;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.FichePfe;
import esprit.pfe.esprit.pfe.services.ConventionServiceRemote;
import esprit.pfe.esprit.pfe.services.FicheServiceRemote;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class DemandeConController implements Initializable{

	 @FXML
	    private JFXDatePicker SDate;

	    @FXML
	    private JFXDatePicker Edate;

	    @FXML
	    private JFXTextField company;

	    @FXML
	    private JFXTextField web;

	    @FXML
	    private JFXTextField ad;

	    @FXML
	    private JFXTextField coun;

	    @FXML
	    private JFXTextField name;

	    @FXML
	    private JFXTextField pre;

	    @FXML
	    private JFXTextField Rmail;

	    @FXML
	    private JFXTextField Smail;

	    @FXML
	    private JFXTextField tel;

	    @FXML
	    private JFXButton req;
	    FichePfe f=new FichePfe();
	    FicheServiceRemote FicheProxy;
	    ConventionServiceRemote ConProxy;
	    VerifRemote proxyAbsencee;
	    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/FicheService!esprit.pfe.esprit.pfe.services.FicheServiceRemote";
	    String jndiLogin1 = "esprit.pfe-ear/esprit.pfe-ejb/ConventionService!esprit.pfe.esprit.pfe.services.ConventionServiceRemote";
	    String jndiAbsence1="esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
	    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
	        return java.sql.Date.valueOf(dateToConvert);
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		FicheProxy = (FicheServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		ConProxy = (ConventionServiceRemote)EJBLookUpUtil.doLookup(jndiLogin1);
proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Etudiant e=proxyAbsencee.selectetudiantconnected(proxyAbsencee.userconnected().getIdrole());
	
		
		
		f=FicheProxy.afficher(e.getIdEtudiant());
		System.out.println(f.getEtudiant().getIdEtudiant());
		if(f!=null){
		company.setText(f.getEntrepFiche());
		coun.setText(f.getPaysFiche());}
		req.setOnAction(click -> {
			Convention v=ConProxy.get(e.getIdEtudiant());
			Date DRS=convertToDateViaSqlDate(SDate.getValue());
			Date DDS=convertToDateViaSqlDate(Edate.getValue());
			java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime()); 
			if(v==null){
				if(DDS.after(DRS)&&DRS.after(today)&&DDS.after(today)&&web.getText().matches("[A-Za-z0-9]+")
						&& ad.getText().matches("[A-Za-z0-9 ]+")&&tel.getText().matches("[0-9]+")&&tel.getText().length()==8&&name.getText().matches("[A-Za-z ]+")&&pre.getText().matches("[A-Za-z ]+")&&
						Rmail.getText().contains("@")&&!Rmail.getText().contains(" ")&&
								 (Rmail.getText().endsWith(".com")||Rmail.getText().endsWith(".fr")||Rmail.getText().endsWith(".tn"))&&
								 Smail.getText().contains("@")&&!Smail.getText().contains(" ")&&
								 (Smail.getText().endsWith(".com")||Smail.getText().endsWith(".fr")||Smail.getText().endsWith(".tn"))){
			Convention c= new Convention(Date.from(SDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),Date.from(Edate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),company.getText(),web.getText(),ad.getText(),coun.getText(),name.getText(),pre.getText(),Rmail.getText(),Smail.getText(),Integer.parseInt(tel.getText()),e);
			ConProxy.ajoutConvnetion(c);
			TrayNotification tray =new TrayNotification();
            tray.setTitle("SUCCESS");
        tray.setMessage("Convention demand created with success!");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();}
			else{
				TrayNotification tray =new TrayNotification();
	            tray.setTitle("Warning");
	        tray.setMessage("Error in fields!");
	        tray.setNotificationType(NotificationType.ERROR);
	        tray.showAndWait();
			}
			}else{
				TrayNotification tray =new TrayNotification();
	            tray.setTitle("Warning");
	        tray.setMessage("You already have a request");
	        tray.setNotificationType(NotificationType.ERROR);
	        tray.showAndWait();
			}
		});
		
		
	}

}
