package projet.pi.pfe.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.ClasseStudent;
import esprit.pfe.esprit.pfe.persistence.Departement;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Optionne;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.persistence.SiteUniversity;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import tn.esprit.b1.esprit1718b1erp.app.client.animations.FadeInUpTransition;


public class UniversityMenuController implements Initializable{
	
		 PlateformeServiceRemote PlateformeProxy;

		    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/PlateformeService!esprit.pfe.esprit.pfe.services.PlateformeServiceRemote";
		    Employe e= new Employe(1,"aaaa","aaaa","aaaa","aaaa","Admin");
			 
			// Plateforme pp= PlateformeProxy.Plateformeuser(em.getIdEmploye());
		    
	@FXML
	private AnchorPane universitymanagement;
	@FXML
	private AnchorPane paneClass;
	@FXML
	private AnchorPane paneDepart;
	@FXML
	private AnchorPane panesite;
	@FXML
	private AnchorPane paneClass1;
	@FXML
	private AnchorPane paneOption;
	@FXML
	private JFXButton msite;
	@FXML
	private JFXButton mdepartment;
	@FXML
	private JFXButton moption;
	@FXML
	private JFXButton mclass;
	
	@FXML
	private JFXButton backclass;
	@FXML
	private JFXButton backdep;
	@FXML
	private JFXButton backsite;
	@FXML
	private JFXButton backoption;
	
	/*SITE*/
	@FXML
	private JFXTextField newsite;
	@FXML
	private JFXButton add2;
	@FXML
	private JFXButton drop2;
	@FXML
	private ComboBox<String> director;
	  @FXML
	    private TableView<SiteUniversity> tablesite2;
	   
	    @FXML
	    private TableColumn<SiteUniversity, String> Site2;
	    @FXML
	    private TableColumn<SiteUniversity, String> sitedirec;
	    
	    /*DEPARTEMENT*/
	    
	    @FXML
		private JFXTextField newdepartment;
		@FXML
		private JFXButton add1;
		@FXML
		private JFXButton drop1;
		@FXML
		private ComboBox<String> dephead;
		 @FXML
		    private TableView<Departement> tablesite;
		  
		    @FXML
		    private TableColumn<Departement, String> site;
		    @FXML
		    private TableColumn<Departement, String> depp;
		    @FXML
		    private TableColumn<Departement, String> headdep;
		    @FXML
		    private TableView<SiteUniversity> tablesite1;
		  
		    @FXML
		    private TableColumn<SiteUniversity, String> site1;
		   
	    
	    /*OPTION*/
		    @FXML
			private JFXTextField newoption1;
			@FXML
			private JFXButton add3;
			@FXML
			private JFXButton drop3;
			 @FXML
			    private TableView<Departement> tabledep4;
			  
			    @FXML
			    private TableColumn<Departement, String> dep11;
			    @FXML
			    private TableColumn<Optionne, String> depp1;
			    @FXML
			    private TableView<Optionne> tabledep11;
			  
			    @FXML
			    private TableColumn<Optionne, String> Option1;
			    
			    /*CLASS*/
			    @FXML
				private JFXTextField newoption;
				@FXML
				private JFXButton add;
				@FXML
				private JFXButton drop;
				 @FXML
				    private TableView<Optionne> tabledepupd;
				  
				    @FXML
				    private TableColumn<Optionne, String> dep1upd;
				    @FXML
				    private TableView<Optionne> tabledep;
				  
				    @FXML
				    private TableColumn<Optionne, String> dep1;
				    @FXML
				    private TableColumn<ClasseStudent, Integer> classs;
				    @FXML
				    private TableView<ClasseStudent> tabledep1;
				  
				    @FXML
				    private TableColumn<ClasseStudent, String> Option;
				    @FXML
				    private TableColumn<Integer,Integer> grade;
				    @FXML
					private JFXTextField newoption2;
					@FXML
					private JFXButton addupd;
					@FXML
					private JFXButton editclass;
					 VerifRemote proxyAbsencee;
					    String jndiAbsence1="esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
	/**********************************SITE******************************************************************/
	
	 @FXML
	 	private void add2( ActionEvent event) throws IOException {
		 proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
			
			Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				SiteUniversity  p = new SiteUniversity((newsite.getText()),director.getValue(),pp);
				PlateformeProxy.addsite(p);
				System.out.println(PlateformeProxy.findAllSite(pp.getId_plateforme()));
				rafrechirSite();
				System.out.println(PlateformeProxy.findAllSite(2));
			System.out.println("SIte");
		}  
	 
	public void rafrechirSite()
	    {
		proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	        /* add column to the tableview and set its items */
		 System.out.println("aaaaaaarrrrrrttt");
		System.out.println(PlateformeProxy.findAllSite(1));
	        ObservableList<SiteUniversity> listestudents = FXCollections.observableArrayList(PlateformeProxy.findAllSite(pp.getId_plateforme()));
	       
	        tablesite2.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
	       Site2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SiteUniversity, String>, ObservableValue<String>>() {
	           
	                @Override
	                public ObservableValue<String> call(TableColumn.CellDataFeatures<SiteUniversity, String> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getSiteName());
	                }
	        });
	       sitedirec.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SiteUniversity, String>, ObservableValue<String>>() {
	           
               @Override
               public ObservableValue<String> call(TableColumn.CellDataFeatures<SiteUniversity, String> param) {
                   return new ReadOnlyObjectWrapper(param.getValue().getDirector());
               }
       });
}
	 @FXML
	 	private void drop2( ActionEvent event) throws IOException {
			
				
				
				if (tablesite2.getSelectionModel().getSelectedItem() != null) {
		        
		                int id = tablesite2.getSelectionModel().getSelectedItem().getId();
		               System.out.println(id);
		               PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		                PlateformeProxy.deleteSite(id);
		           
		            rafrechirSite();
		        } else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select a site");
		            alert.show();
		        }
		}  
	 
	/************************************DEPARTEMENT******************************************************************///
	
	 public void rafrechirSitee()
	    {proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	        /* add column to the tableview and set its items */
		 ObservableList<SiteUniversity> listestudents = FXCollections.observableArrayList(PlateformeProxy.findAllSite(pp.getId_plateforme()));
	       
	        tablesite1.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
	       site1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SiteUniversity, String>, ObservableValue<String>>() {
	           
	                @Override
	                public ObservableValue<String> call(TableColumn.CellDataFeatures<SiteUniversity, String> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getSiteName());
            }
    });
}
	 public void rafrechirDep()
	    {proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	        /* add column to the tableview and set its items */
		 ObservableList<Departement> listestudents = FXCollections.observableArrayList(PlateformeProxy.findDep(pp.getId_plateforme()));
	       
	        tablesite.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
	       site.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Departement, String>, ObservableValue<String>>() {
	           
	                @Override
	                public ObservableValue<String> call(TableColumn.CellDataFeatures<Departement, String> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getSitee().getSiteName());
         }
 });
	       depp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Departement, String>, ObservableValue<String>>() {
	           
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Departement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDepartment());
    }
});
	       headdep.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Departement, String>, ObservableValue<String>>() {
	           
	            @Override
	            public ObservableValue<String> call(TableColumn.CellDataFeatures<Departement, String> param) {
	                return new ReadOnlyObjectWrapper(param.getValue().getDepartmenthead());
	    }
	       });
}
	    
	 @FXML
	 	private void add1( ActionEvent event) throws IOException {
			
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				if (tablesite1.getSelectionModel().getSelectedItem() != null) {
		        
		                int id = tablesite1.getSelectionModel().getSelectedItem().getId();
		               System.out.println(id);
		               Departement d=new Departement(newdepartment.getText(),tablesite1.getSelectionModel().getSelectedItem(),dephead.getValue());
		               PlateformeProxy.adddepartment(d);
		             //  System.out.println(d);
		             
		               
		              rafrechirDep();
				} else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select a site for your department");
		            alert.show();
		        }
		} 
	 
	 @FXML
	 	private void drop1( ActionEvent event) throws IOException {
			
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				if (tablesite.getSelectionModel().getSelectedItem() != null) {
		        
		                int id = tablesite.getSelectionModel().getSelectedItem().getId();
		               System.out.println(id);
		                PlateformeProxy.deleteDepart(id);
		           
		                rafrechirSitee();
		                rafrechirDep();
		        } else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select a site");
		            alert.show();
		        }
		}  
	
	//*******************************OPTION***********************************************************************/////////////
	
	 public void rafrechirDepartement()
	    {
		 proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
			
			Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	       
	        /* add column to the tableview and set its items */
		 ObservableList<Departement> listestudents = FXCollections.observableArrayList(PlateformeProxy.findDep(pp.getId_plateforme()));
	       
		 tabledep4.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
	       dep11.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Departement, String>, ObservableValue<String>>() {
	           
	                @Override
	                public ObservableValue<String> call(TableColumn.CellDataFeatures<Departement, String> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getDepartment());
            }
    });
}
	 public void rafrechirOption()
	    {proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	       
	        /* add column to the tableview and set its items */
		 ObservableList<Optionne> listestudents = FXCollections.observableArrayList(PlateformeProxy.findOption(pp.getId_plateforme()));
	       
		 tabledep11.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
		 depp1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Optionne, String>, ObservableValue<String>>() {
	           
	                @Override
	                public ObservableValue<String> call(TableColumn.CellDataFeatures<Optionne, String> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getDep().getDepartment());
         }
 });
	       Option1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Optionne, String>, ObservableValue<String>>() {
	           
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Optionne, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getOptionName());
    }
});
}
	    
	 @FXML
	 	private void add3( ActionEvent event) throws IOException {
			
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				if (tabledep4.getSelectionModel().getSelectedItem() != null) {
		        
		                int id = tabledep4.getSelectionModel().getSelectedItem().getId();
		               System.out.println(id);
		               Optionne d=new Optionne(newoption1.getText(),tabledep4.getSelectionModel().getSelectedItem());
		               PlateformeProxy.addOption(d);
		               rafrechirOption();
				} else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select a site for your department");
		            alert.show();
		        }
		} 
	 
	 @FXML
	 	private void drop3( ActionEvent event) throws IOException {
			
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				if (tabledep11.getSelectionModel().getSelectedItem() != null) {
		        
		                int id = tabledep11.getSelectionModel().getSelectedItem().getIdOption();
		               System.out.println(id);
		                PlateformeProxy.deleteOption(id);
		           
		                rafrechirOption();
		               
		        } else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select a site");
		            alert.show();
		        }
		}  
	
	//*******************************CLASS***********************************************************************/////////////
	 @FXML
		private void editclass( ActionEvent event){
		  if(tabledep1.getSelectionModel().getSelectedItem()==null){
	            Config2.dialog(Alert.AlertType.INFORMATION, "Please select a task to update ..");
	        } else {
	        	
	    		paneClass1.toFront();
	           new FadeInUpTransition(paneClass1).play();
	           paneClass.setVisible(false);
	           paneDepart.setVisible(false);
	           panesite.setVisible(false);
	           paneOption.setVisible(false);
	           rafrechirOptionforClassupd();
	           newoption2.setText(String.valueOf(tabledep1.getSelectionModel().getSelectedItem().getClassNumber()));
	           
	        }
} 
	 public void rafrechirOptionforClass()
	    {proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	        /* add column to the tableview and set its items */
		 ObservableList<Optionne> listestudents = FXCollections.observableArrayList(PlateformeProxy.findOption(pp.getId_plateforme()));
	       
		 tabledep.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
	       dep1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Optionne, String>, ObservableValue<String>>() {
	           
	                @Override
	                public ObservableValue<String> call(TableColumn.CellDataFeatures<Optionne, String> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getOptionName());
            }
    });
}
	 public void rafrechirOptionforClassupd()
	    {proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	        /* add column to the tableview and set its items */
		 ObservableList<Optionne> listestudents = FXCollections.observableArrayList(PlateformeProxy.findOption(pp.getId_plateforme()));
	       
		 tabledepupd.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
	       dep1upd.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Optionne, String>, ObservableValue<String>>() {
	           
	                @Override
	                public ObservableValue<String> call(TableColumn.CellDataFeatures<Optionne, String> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getOptionName());
         }
 });
}	 
	 public void rafrechirClass()
	    {proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	       
	        /* add column to the tableview and set its items */
		 ObservableList<ClasseStudent> listestudents = FXCollections.observableArrayList(PlateformeProxy.findClasse(pp.getId_plateforme()));
	       
		 tabledep1.setItems(listestudents);
	        
	        
	       // namestudent.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("id"));
	      
		 classs.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ClasseStudent, Integer>, ObservableValue<Integer>>() {
	           
	                @Override
	                public ObservableValue<Integer> call(TableColumn.CellDataFeatures<ClasseStudent, Integer> param) {
	                    return new ReadOnlyObjectWrapper(param.getValue().getClassNumber());
         }
 });
	       Option.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ClasseStudent, String>, ObservableValue<String>>() {
	           
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ClasseStudent, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getOptionne().getOptionName());
    }
});
grade.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Integer, Integer>, ObservableValue<Integer>>() {
 Integer g=5;
 @Override
 public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Integer, Integer> param) {
     return new ReadOnlyObjectWrapper(param.getValue().valueOf(g));
}
});
}
	    
	 @FXML
	 	private void add( ActionEvent event) throws IOException {
			
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				if (tabledep.getSelectionModel().getSelectedItem() != null) {
		        
		                int id = tabledep.getSelectionModel().getSelectedItem().getIdOption();
		               System.out.println(id);
		               ClasseStudent d=new ClasseStudent(Integer.parseInt(newoption.getText()),tabledep.getSelectionModel().getSelectedItem());
		               PlateformeProxy.addClasse(d);
		               rafrechirClass();
				} else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select an option for your class");
		            alert.show();
		        }
		} 
	 @FXML
	 	private void addupd( ActionEvent event) throws IOException {
		// rafrechirOptionforClassupd();
		 System.out.println("ffffffffff");
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				if (tabledepupd.getSelectionModel().getSelectedItem() != null) {
					PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
					ClasseStudent project =new ClasseStudent();
		        System.out.println("ffffffffff");
		              //  int id = tabledepupd.getSelectionModel().getSelectedItem().getIdOption();
		             //  System.out.println(id);
		               System.out.println("ffffffffff");
		               project.setClassNumber(Integer.parseInt(newoption2.getText()));
				    	project.setOptionne(tabledepupd.getSelectionModel().getSelectedItem());
		               System.out.println("ffffffffff");
		               PlateformeProxy.updateClasse(project);
		               System.out.println("ffffffffff");
		               rafrechirClass();
		              
				} else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select an option for your class");
		            alert.show();
		        }
				
				
				
		} 
	 
	 @FXML
	 	private void drop( ActionEvent event) throws IOException {
			
				PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				
				if (tabledep1.getSelectionModel().getSelectedItem() != null) {
		        
		                int id = tabledep1.getSelectionModel().getSelectedItem().getId();
		               System.out.println(id);
		                PlateformeProxy.deleteClasse(id);
		           
		                rafrechirOptionforClass();
		                rafrechirClass();
		        } else {
		            Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("information Dialog");
		            alert.setHeaderText(null);
		            alert.setContentText("Please select a site");
		            alert.show();
		        }
		}  
	 
	 
	/************************************************INITIALIZE******************************************//////////////////
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rafrechirSite();
		rafrechirSitee();
		rafrechirDep();
		rafrechirDepartement();
		rafrechirOption();
		rafrechirOptionforClass();
		rafrechirClass();
		paneClass1.setOpacity(0);
		paneClass.setOpacity(0);
		paneDepart.setOpacity(0);
		panesite.setOpacity(0);
		paneOption.setOpacity(0);
		//universitymanagement.setOpacity(1);
        new FadeInUpTransition(universitymanagement).play();
        
	}
	 @FXML
	 	private void msite( ActionEvent event) throws IOException{proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	    	paneClass1.setOpacity(0);
	    	universitymanagement.setOpacity(0);
		 paneClass.setOpacity(0);
		 paneDepart.setOpacity(0);
		 paneOption.setOpacity(0);
		
		 panesite.setOpacity(1);
	       
	        new FadeInUpTransition(panesite).play();
	        List<Employe>  la= PlateformeProxy.finddirecteurstage(pp.getUniversity(), "Internship director");
			for(Employe i : la){
				director.getItems().addAll(i.getUserNameEmploye());
			}
			
	 }
	 @FXML
	 	private void mdepartment( ActionEvent event) throws IOException{proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		Employe e=proxyAbsencee.selectemployeconnected(proxyAbsencee.userconnected().getIdrole());
		 PlateformeProxy = (PlateformeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
	    	Plateforme pp= PlateformeProxy.Plateformeuser(e.getIdEmploye());
	    	paneClass1.setOpacity(0);
	    	universitymanagement.setOpacity(0);
		 paneClass.setOpacity(0);
		
		 paneOption.setOpacity(0);
		
		 panesite.setOpacity(0);
		 paneDepart.setOpacity(1);
	        new FadeInUpTransition(paneDepart).play();
	      
	        List<Employe>  la= PlateformeProxy.findchefdep(pp.getUniversity(), "department head");
			for(Employe i : la){
				dephead.getItems().addAll(i.getUserNameEmploye());
			}
			
	 }
	 @FXML
	 	private void moption( ActionEvent event) throws IOException{
		 paneClass1.setOpacity(0);
		 universitymanagement.setOpacity(0);
		 paneClass.setOpacity(0);
		 paneDepart.setOpacity(0);
		
		
		 panesite.setOpacity(0);
		 paneOption.setOpacity(1);
	        new FadeInUpTransition(paneOption).play();
			
	 }
	 
	 @FXML
	 	private void mclass( ActionEvent event) throws IOException{
		 paneClass1.setOpacity(0);
		 universitymanagement.setOpacity(0);
		 paneDepart.setOpacity(0);
		 paneOption.setOpacity(0);
		 paneClass1.setOpacity(0);
		 panesite.setOpacity(0);
		 paneClass.setOpacity(1);
	        new FadeInUpTransition(paneClass).play();
	       // rafrechirOptionforClassupd();
	 }
	 @FXML
	 	private void backclass( ActionEvent event) throws IOException{
		 paneClass1.setOpacity(0);
		 paneClass.setOpacity(0);
		 paneDepart.setOpacity(0);
		 paneOption.setOpacity(0);
		
		 panesite.setOpacity(0);
		 universitymanagement.setOpacity(1);
	        new FadeInUpTransition(universitymanagement).play();
			
	 }
	 @FXML
	 	private void backclass1( ActionEvent event) throws IOException{
		 paneClass1.setOpacity(0);
		 paneClass.setOpacity(0);
		 paneDepart.setOpacity(0);
		 paneOption.setOpacity(0);
		
		 panesite.setOpacity(0);
		 universitymanagement.setOpacity(1);
	        new FadeInUpTransition(universitymanagement).play();
			
	 }
	 @FXML
	 	private void backdep( ActionEvent event) throws IOException{
		 paneClass1.setOpacity(0);
		 paneClass.setOpacity(0);
		 paneDepart.setOpacity(0);
		 paneOption.setOpacity(0);
		
		 panesite.setOpacity(0);
		 universitymanagement.setOpacity(1);
	        new FadeInUpTransition(universitymanagement).play();
			
	 }
	 @FXML
	 	private void backsite( ActionEvent event) throws IOException{
		 paneClass1.setOpacity(0);
		 paneClass.setOpacity(0);
		 paneDepart.setOpacity(0);
		 paneOption.setOpacity(0);
		
		 panesite.setOpacity(0);
		 universitymanagement.setOpacity(1);
	        new FadeInUpTransition(universitymanagement).play();
			
	 }
	 @FXML
	 	private void backoption( ActionEvent event) throws IOException{
		 paneClass1.setOpacity(0);
		 paneClass.setOpacity(0);
		 paneDepart.setOpacity(0);
		 paneOption.setOpacity(0);
		
		 panesite.setOpacity(0);
		 universitymanagement.setOpacity(1);
	        new FadeInUpTransition(universitymanagement).play();
			
	 }
	 
	
}
