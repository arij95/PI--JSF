package projet.pi.pfe.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.ClasseStudent;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.Optionne;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;
import javafx.util.Callback;
public class ManageStudentAdminController implements Initializable{

	 @FXML
	    private JFXTextField searchstudent;
	    
	    @FXML
	    private JFXButton searchstudentbutt;
	    @FXML
	    private JFXButton addstudentbutt;
	    @FXML
	    private TableView<Etudiant> tablemanagestudent;
	   
	    @FXML
	    private TableColumn<Etudiant, String> namestudent;
	    @FXML
	    private TableColumn<Etudiant, String> prenamestudent;
	    @FXML
	    private TableColumn<Etudiant, String> emailstudent;
	    @FXML
	    private TableColumn<Etudiant, String> optionstudent;
	    @FXML
	    private TableColumn<Etudiant, Integer> classstudent;
	    @FXML
	    private TableColumn<Etudiant, Boolean> fnc;
	    @FXML
	    private TableColumn<Etudiant, Boolean> pdc;
	    
	    @FXML
	  
	    private TableColumn<Etudiant, Integer> autor;
	    @FXML
	    private JFXTextField firstname;
	    @FXML
	    private JFXTextField lastname;
	    @FXML
	    private JFXTextField username;
	    @FXML
	    private JFXTextField email;
	    @FXML
	    private JFXComboBox<String> option;
	    @FXML
	    private JFXComboBox<Integer> classe;
	    @FXML
	    private JFXRadioButton fcyes;
	    @FXML
	    private JFXRadioButton pcno;
	    @FXML
	    private JFXRadioButton fcno;
	    @FXML
	    private JFXRadioButton pcyes;
	  
	    @FXML
	    private JFXButton add;
	    @FXML
	    private JFXButton deletestudent;
	    @FXML
	    private JFXButton backstudent;
	    @FXML
	    private ToggleGroup fc;
	    @FXML
	    private ToggleGroup pc;
		@FXML
		private AnchorPane addstudentpane;
		@FXML
		private AnchorPane addstudentpane1;
		@FXML
		private AnchorPane managestudentpane;
		 @FXML
		    private JFXTextField firstname1;
		    @FXML
		    private JFXTextField lastname1;
		    @FXML
		    private JFXTextField username1;
		    @FXML
		    private JFXTextField email1;
		    @FXML
		    private JFXComboBox<String> option1;
		    @FXML
		    private JFXComboBox<Integer> classe1;
		    @FXML
		    private JFXRadioButton fcyes1;
		    @FXML
		    private JFXRadioButton pcno1;
		    @FXML
		    private JFXRadioButton fcno1;
		    @FXML
		    private JFXRadioButton pcyes1;
		  
		    @FXML
		    private JFXButton add1;
		
		 PlateformeServiceRemote PlateformeProxy;

		    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/PlateformeService!esprit.pfe.esprit.pfe.services.PlateformeServiceRemote";
		    VerifRemote proxyAbsencee;
		    String jndiAbsence1="esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
		 Employe em= new Employe(1,"aaaa","aaaa","aaaa","aaaa","Admin");
		 
			//Plateforme pp = new Plateforme(1,em,"aaaa","20178/2019","mmmmm.jpg");
		
	    @Override
	public void initialize(URL location, ResourceBundle resources) {
	    	proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
			
			Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
	    	PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	    	option.setOnAction(click->{
	    		String a=option.getValue();
				System.out.println(a+"rrrrrrrrrr");
				classe.getItems().clear();
				List<ClasseStudent>  ll= PlateformeProxy.findClassee(PlateformeProxy.optionName(a).getIdOption());
				for(ClasseStudent i : ll){
					
					classe.getItems().addAll(i.getClassNumber());
				}
	    	});
	    	 List<Optionne>  la= PlateformeProxy.findOption(pp.getId_plateforme());
				for(Optionne i : la){
					option1.getItems().addAll(i.getOptionName());
				}
	    	 option1.setOnAction(click->{
		    		String a=option1.getValue();
					System.out.println(a+"rrrrrrrrrr");
					classe1.getItems().clear();
					List<ClasseStudent>  ll= PlateformeProxy.findClassee(PlateformeProxy.optionName(a).getIdOption());
					for(ClasseStudent i : ll){
						
						classe1.getItems().addAll(i.getClassNumber());
					}
		    	});
	    	
	    	/*classe.setOnAction(click->{
	    		classe.getItems().clear();
	    	});
	    	/*String a=option.getValue();
			System.out.println(a);*/
		// TODO Auto-generated method stub
	    	addstudentpane.setOpacity(0);
	      
	         new FadeInUpTransition(managestudentpane).play();
	    rafrechir();
	   
	}
	   

	//	PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	 public void rafrechir()
	    {Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
    	PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	        /* add column to the tableview and set its items */
	        ObservableList<Etudiant> listestudents = FXCollections.observableArrayList(PlateformeProxy.findAllStudent(pp.getUniversity()));
	       
	        tablemanagestudent.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
	       namestudent.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Etudiant, String>, ObservableValue<String>>() {
	           
	                @Override
	                public ObservableValue<String> call(TableColumn.CellDataFeatures<Etudiant, String> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getNomEtudiant());
	                }
	        });
	        prenamestudent.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Etudiant, String>, ObservableValue<String>>() {
	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Etudiant, String> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getPrenomEtudiant());
	            }
	        });
	      
	        emailstudent.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Etudiant, String>, ObservableValue<String>>() {
	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Etudiant, String> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getEmailEtudiant());
	            }
	        });
	        fnc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Etudiant, Boolean>, ObservableValue<Boolean>>() {
	            @Override
	            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Etudiant, Boolean> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().isCreditFinaciereEtudiant());
	            }
	        });
	        pdc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Etudiant, Boolean>, ObservableValue<Boolean>>() {
	            @Override
	            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Etudiant, Boolean> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().isCreditPedagogiqueEtudiant());
	            }
	        });
	        autor.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Etudiant, Integer>, ObservableValue<Integer>>() {
	            @Override
	            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Etudiant, Integer> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getAutorisationEtudiant());
	            }
	        });
	        optionstudent.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Etudiant, String>, ObservableValue<String>>() {
	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Etudiant, String> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getOptionstudent());
	            }
	        });
	        classstudent.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Etudiant, Integer>, ObservableValue<Integer>>() {
	            @Override
	            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Etudiant, Integer> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getClassenum());
	            }
	        });
	    }
	 @FXML
	 	private void addstudentbutt( ActionEvent event) throws IOException{
		 Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
	    	PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
		 managestudentpane.setOpacity(0);
		 addstudentpane.setOpacity(1);
	       
	        new FadeInUpTransition(addstudentpane).play();
	        List<Optionne>  la= PlateformeProxy.findOption(pp.getId_plateforme());
			for(Optionne i : la){
				option.getItems().addAll(i.getOptionName());
			}
			
			
	 }
	 
	 @FXML
		private void add( ActionEvent event){
		 Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
	    	PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
		 String a=option.getValue();
			System.out.println(a);
			if(fcyes.isSelected() && pcyes.isSelected()){
				Boolean yes=true ;
			Etudiant p= new Etudiant(firstname.getText(),lastname.getText(),pp.getUniversity(),email.getText(),username.getText(),
					yes,yes,0,option.getValue(),classe.getValue());
			PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
			PlateformeProxy.addstudent(p);
			System.out.println(p);
			PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
			Etudiant as=PlateformeProxy.selectetudianttapped(username.getText());
			System.out.println(as);
			PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
			PlateformeProxy.ajouteretuduser(as);
			System.out.println("bbbbb");}
			else {
				Boolean no =false;
				Etudiant p= new Etudiant(firstname.getText(),lastname.getText(),pp.getUniversity(),email.getText(),username.getText(),
						no,no,0,option.getValue(),classe.getValue());
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				PlateformeProxy.addstudent(p);
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				Etudiant as=PlateformeProxy.selectetudianttapped(username.getText());
				System.out.println(as);
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				PlateformeProxy.ajouteretuduser(as);
				System.out.println(p);}
			}
	 @FXML
		private void add1( ActionEvent event){
		 Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
	    	PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
		 String a=option.getValue();
			System.out.println(a);
			if(fcyes.isSelected() && pcyes.isSelected()){
				Boolean yes=true ;
			Etudiant p= new Etudiant(firstname.getText(),lastname.getText(),pp.getUniversity(),email.getText(),username.getText(),
					yes,yes,0,option.getValue(),classe.getValue());
			PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
			PlateformeProxy.addstudent(p);
			System.out.println("bbbbb");}
			else {
				Boolean no =false;
				Etudiant p= new Etudiant(firstname.getText(),lastname.getText(),pp.getUniversity(),email.getText(),username.getText(),
						no,no,0,option.getValue(),classe.getValue());
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				PlateformeProxy.addstudent(p);
				System.out.println("cccccc");}
			}
	 @FXML
	 	private void backstudent( ActionEvent event) throws IOException{
		
		 managestudentpane.setOpacity(1);
		 addstudentpane.setOpacity(0);
		
	        new FadeInUpTransition(managestudentpane).play();
			
	 }
	 @FXML
	 	private void deletestudent( ActionEvent event) throws IOException {
			
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				if (tablemanagestudent.getSelectionModel().getSelectedItem() != null) {
		        
		                int id = tablemanagestudent.getSelectionModel().getSelectedItem().getIdEtudiant();
		               System.out.println(id);
		                PlateformeProxy.deleteClasse(id);
		                Alert alert = new Alert(Alert.AlertType.ERROR);
			             alert.setTitle("information Dialog");
			             alert.setHeaderText(null);
			             alert.setContentText("Are you sure to delete this employe?");
			             alert.showAndWait();
			             if(alert.getResult() == ButtonType.OK){
			            	 PlateformeProxy.deleteStudent(id);
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
	 /*
	  *  @FXML
	    private JFXTextField firstname;
	    @FXML
	    private JFXTextField lastname;
	    @FXML
	    private JFXTextField username;
	    @FXML
	    private JFXTextField email;
	    @FXML
	    private JFXComboBox<String> option;
	    @FXML
	    private JFXComboBox<Integer> classe;
	    @FXML
	    private JFXRadioButton fcyes;
	    @FXML
	    private JFXRadioButton pcno;
	    @FXML
	    private JFXRadioButton fcno;
	    @FXML
	    private JFXRadioButton pcyes;
	  
	    @FXML
	    private JFXButton add;
	  */
	 
	 @FXML
		private void edit3( ActionEvent event){
		 
		  if(tablemanagestudent.getSelectionModel().getSelectedItem()==null){
	            Config2.dialog(Alert.AlertType.INFORMATION, "Please select a task to update ..");
	        } else { addstudentpane1.setOpacity(1);
	        managestudentpane.setOpacity(0);
	        addstudentpane.setOpacity(0);
	        addstudentpane1.toFront();
	           new FadeInUpTransition(addstudentpane1).play();
	           managestudentpane.setVisible(false);
	            addstudentpane.setVisible(false);
	          
	        	firstname1.setText(tablemanagestudent.getSelectionModel().getSelectedItem().getNomEtudiant());
	            lastname1.setText(tablemanagestudent.getSelectionModel().getSelectedItem().getPrenomEtudiant());
	            option.getEditor().setText(String.valueOf(tablemanagestudent.getSelectionModel().getSelectedItem().getOptionstudent()));
	            username1.setText(tablemanagestudent.getSelectionModel().getSelectedItem().getUserNameEtudiant());
	            email1.setText(tablemanagestudent.getSelectionModel().getSelectedItem().getEmailEtudiant());
	            option1.setOnAction(click->{
		    		String a=option1.getValue();
					System.out.println(a+"rrrrrrrrrr");
					classe1.getItems().clear();
					List<ClasseStudent>  ll= PlateformeProxy.findClassee(PlateformeProxy.optionName(a).getIdOption());
					for(ClasseStudent i : ll){
						
						classe1.getItems().addAll(i.getClassNumber());
					}
		    	});
	        }
}
}
