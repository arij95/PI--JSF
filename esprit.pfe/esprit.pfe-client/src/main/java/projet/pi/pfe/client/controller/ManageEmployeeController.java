package projet.pi.pfe.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.services.EmployeeServiceRemote;
import esprit.pfe.esprit.pfe.services.PlateformeServiceRemote;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;




public class ManageEmployeeController implements Initializable{
	 EmployeeServiceRemote EmployeeProxy;

	    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/EmployeeService!esprit.pfe.esprit.pfe.services.EmployeeServiceRemote";
	    PlateformeServiceRemote PlateformeProxy;

	    String jndi = "esprit.pfe-ear/esprit.pfe-ejb/PlateformeService!esprit.pfe.esprit.pfe.services.PlateformeServiceRemote";

	    VerifRemote proxyAbsencee;
	    String jndiAbsence1="esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
	    /*ADD*/
	 @FXML
	    private JFXTextField firstname;
	    @FXML
	    private JFXTextField lastname;
	    @FXML
	    private JFXTextField username;
	    @FXML
	    private JFXTextField email;
	    @FXML
	    private JFXComboBox<String> post;
	    
	    @FXML
	    private JFXButton add;
	    
	  /*UPDATE*/
	    @FXML
	    private JFXTextField firstname1;
	    @FXML
	    private JFXTextField lastname1;
	    @FXML
	    private JFXTextField username1;
	    @FXML
	    private JFXTextField email1;
	    @FXML
	    private JFXComboBox<String> post1;
	    
	    @FXML
	    private JFXButton add1;
	    
	    /*SHOW*/
	    @FXML
	    private JFXTextField searchstudent;
	    
	    @FXML
	    private JFXButton searchstudentbutt;
	   
	    @FXML
	    private TableView<Employe> tablemanagestudent;
	   
	    @FXML
	    private TableColumn<Employe, String> firstnameaff;
	    @FXML
	    private TableColumn<Employe, String> lastnameaff;
	    @FXML
	    private TableColumn<Employe, String> emailaff;
	    @FXML
	    private TableColumn<Employe, String> usernameaff;
	    @FXML
	    private TableColumn<Employe, String> postaff;
	    @FXML
	    private JFXButton addemployeebutt;
	    @FXML
	    private JFXButton edit3;
	    @FXML
	    private JFXButton deleteemployee;
	   
	    
	    @FXML
	    private AnchorPane paneaddempl1;
	    @FXML
	    private AnchorPane paneaddempl;
	    @FXML
	    private AnchorPane manageemployeepane;
	   
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndi);
    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
       paneaddempl.setOpacity(0);
       paneaddempl1.setOpacity(0);
       manageemployeepane.setOpacity(1);
       new FadeInUpTransition(manageemployeepane).play();
  rafrechir();
		post.getItems().addAll(
			    "Internship director",
			    "department head",
			    "Internship Framer",
			    "professor",
			    "protractor"
			);
		//post.getItems().setAll(EmployeRole.values());
		
    	rafrechir();
	}

	
	/*************************ADD***********************************************///
	  @FXML
			private void add( ActionEvent event){
		  proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
			
			Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		    	PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndi);
		    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
				//Etudiant e= new Etudiant(1,"a","a","a","a","a","a","a","a",true,true);
				Employe p= new Employe(firstname.getText(),lastname.getText(),email.getText(),username.getText(),post.getValue(),5,5,5,5,pp.getUniversity());
				EmployeeProxy = (EmployeeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				EmployeeProxy.addemployee(p);
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndi);
				Employe as=PlateformeProxy.selectemployetapped(p.getPrenomEmploye());
				System.out.println(as);
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndi);
				PlateformeProxy.ajouterempuser(as);
				
				
				System.out.println("aaaaaaaaaa");
			}
	
	/************************************UPDATE*************************************************////
	  
	  @FXML
		private void add1( ActionEvent event){
		  proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
			
			Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
	    	PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndi);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	    	Employe project = tablemanagestudent.getSelectionModel().getSelectedItem();
			//Etudiant e= new Etudiant(1,"a","a","a","a","a","a","a","a",true,true);
	    	project.setNomEmploye(firstname1.getText());
	    	project.setPrenomEmploye(lastname1.getText());
	    	project.setUserNameEmploye(username1.getText());
	    	project.setEmailEmploye(email1.getText());
	    	project.setUserNameEmploye(username1.getText());
	    	project.setEmployeRole(post1.getValue());
			
			EmployeeProxy = (EmployeeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
			EmployeeProxy.updateEmployee(project);
			System.out.println("aaaaaaaaaa");
		}
	//////////*************************SHOW***************************************///////
	  public void rafrechir()
	    {
		  proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
			
			Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
			EmployeeProxy = (EmployeeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndi);
		 Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	        /* add column to the tableview and set its items */
	        ObservableList<Employe> listestudents = FXCollections.observableArrayList(EmployeeProxy.findEmployee(pp.getUniversity()));
	       
	        tablemanagestudent.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
	        firstnameaff.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
	           
	                @Override
	                public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getNomEmploye());
	                }
	        });
	        lastnameaff.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getPrenomEmploye());
	            }
	        });
	      
	        emailaff.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getEmailEmploye());
	            }
	        });
	        usernameaff.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getUserNameEmploye());
	            }
	        });
	        postaff.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getEmployeRole());
	            }
	        });
	     }
	  
	  @FXML
		private void edit3( ActionEvent event){
		  if(tablemanagestudent.getSelectionModel().getSelectedItem()==null){
	            Config2.dialog(Alert.AlertType.INFORMATION, "Please select a task to update ..");
	        } else {
	        	paneaddempl.setOpacity(0);
	            
	            manageemployeepane.setOpacity(0);
	            paneaddempl1.setOpacity(1);
	            new FadeInUpTransition(paneaddempl1).play();
	           
	            post1.getItems().addAll(
	    			    "Internship director",
	    			    "department head",
	    			    "Internship Framer",
	    			    "professor",
	    			    "protractor"
	    			);
	        	firstname1.setText(tablemanagestudent.getSelectionModel().getSelectedItem().getNomEmploye());
	            lastname1.setText(tablemanagestudent.getSelectionModel().getSelectedItem().getPrenomEmploye());
	            post1.getEditor().setText(String.valueOf(tablemanagestudent.getSelectionModel().getSelectedItem().getEmployeRole()));
	            username1.setText(tablemanagestudent.getSelectionModel().getSelectedItem().getUserNameEmploye());
	            email1.setText(tablemanagestudent.getSelectionModel().getSelectedItem().getEmailEmploye());
	        }
}
	  
	 

	  @FXML
	 	private void deleteemployee( ActionEvent event) throws IOException {
			
		  EmployeeProxy = (EmployeeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				if (tablemanagestudent.getSelectionModel().getSelectedItem() != null) {
		        
		                int id = tablemanagestudent.getSelectionModel().getSelectedItem().getIdEmploye();
		               System.out.println(id);
		               EmployeeProxy.deleteEmploye(id);
		                Alert alert = new Alert(Alert.AlertType.ERROR);
			             alert.setTitle("information Dialog");
			             alert.setHeaderText(null);
			             alert.setContentText("Are you sure to delete this employe?");
			             alert.showAndWait();
			             if(alert.getResult() == ButtonType.OK){
			            	 EmployeeProxy.deleteEmploye(id);
			            	  rafrechir();
			         	     } 
		              
		              
		        } else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select a site");
		            alert.show();
		        }
		}  
	  @FXML
	 	private void addemployeebutt( ActionEvent event) throws IOException{
		 
	    	//manageemployeepane.setOpacity(0);
	    //	paneaddempl1.setOpacity(0);
		// paneaddempl.setOpacity(1);
	    	paneaddempl1.setOpacity(0);
          
          manageemployeepane.setOpacity(0);
          paneaddempl.setOpacity(1);
          new FadeInUpTransition(paneaddempl).play();
	     
			
			
	 }
}
