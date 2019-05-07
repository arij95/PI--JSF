package Controllers;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.services.SuperAdminRemote;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GererAdminController implements Initializable{

    @FXML
    private TableView<Employe> listeadmin;

    @FXML
    private TableColumn<Employe, String> ecoleemp;

    @FXML
    private TableColumn<Employe, String> emailemp;

    @FXML
    private TableColumn<Employe, String> nomemp;

    @FXML
    private TableColumn<Employe, String> prenomemp;

    @FXML
    private TableColumn<Employe, String> useremp;

    @FXML
    private JFXButton modifier;
    @FXML
    private Button backt;
    @FXML
    private JFXButton ajouter;
    @FXML
    private JFXButton export;
    
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton searchbut;
    @FXML
    private JFXTextField search;
    
    public static Employe he;
    
    SuperAdminRemote proxysuper;
	
	String jndiAbsence = "esprit.pfe-ear/esprit.pfe-ejb/SuperAdmin!esprit.pfe.esprit.pfe.services.SuperAdminRemote";
	 
	 @Override
		public void initialize(URL location, ResourceBundle resources) {
		
        	     
        	
        	 
		 rafrechir();
		 supprimer.setOnAction(new EventHandler<ActionEvent>() {
	    	 @Override
	         public void handle(ActionEvent event) {
	    	
	    		 Alert alert = new Alert(Alert.AlertType.ERROR);
	             alert.setTitle("information Dialog");
	             alert.setHeaderText(null);
	             alert.setContentText("Are you sure to delete this employe?");
	             alert.showAndWait();
	             if(alert.getResult() == ButtonType.OK){
	            	  if (listeadmin.getSelectionModel().getSelectedItem() != null) {
	         	         int id = listeadmin.getSelectionModel().getSelectedItem().getIdEmploye();
	         			 proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
	         			 proxysuper.supprimeradmin(id);
	         	         rafrechir();
	         	     } else {
	         	         Alert alert1 = new Alert(Alert.AlertType.ERROR);
	         	         alert1.setTitle("information Dialog");
	         	         alert1.setHeaderText(null);
	         	         alert1.setContentText("You must select an employe");
	         	         alert1.show();
	         	     }
	            		
	             }
	    		 
	           
	}});
		 
		 
		 modifier.setOnAction(new EventHandler<ActionEvent>() {
	            
	            @Override
	            public void handle(ActionEvent event) {
	         if (listeadmin.getSelectionModel().getSelectedItem() != null) {

	            
	               try {
	          Employe a = listeadmin.getSelectionModel().getSelectedItem();
	        he = a;
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/ModifEmploye.fxml"));
	        Parent root = loader.load();
	         
	        
	        
	        
	        
	        EditEmployeController hc = loader.getController();
	        hc.setAdmin(a,a.getIdEmploye());
	        
	        Stage stage= new Stage();
	        Scene scene=new Scene(root);
	        stage.setScene(scene);
	        stage.showAndWait();
	        
	        rafrechir();
	        } catch (IOException ex) {
	            Logger.getLogger(GererAdminController.class.getName()).log(Level.SEVERE, null, ex);
	            
	        }
	                   } else {
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setTitle("information Dialog");
	            alert.setHeaderText(null);
	            alert.setContentText("You must select an employe!");
	            alert.show();
	        }
	    }
	            
	});
		 
		}
	 @FXML
	    void backt(ActionEvent event) throws IOException {
	    	
	    	Stage dashboardStage = new Stage();
			dashboardStage.setTitle("");
			Parent root = FXMLLoader.load(getClass().getResource("/interfaces/login2.fxml"));
			Scene scene = new Scene(root);
			dashboardStage.setScene(scene);
			dashboardStage.show();
			 Stage stage = (Stage) backt.getScene().getWindow();
			    // do what you have to do
			    stage.close();
	    }

   @FXML
    void ajouter(ActionEvent event) throws IOException {
    	
    	Stage dashboardStage = new Stage();
		dashboardStage.setTitle("");
		Parent root = FXMLLoader.load(getClass().getResource("/interfaces/AddEmployee.fxml"));
		Scene scene = new Scene(root);
		dashboardStage.setScene(scene);
		dashboardStage.show();
		 Stage stage = (Stage) ajouter.getScene().getWindow();
		    // do what you have to do
		    stage.close();
    }

    @FXML
    void supprimer(ActionEvent event) {
    	

    }
    @FXML
    void export(ActionEvent event) throws IOException, ParseException {
    	 String[] columns = { "Ecole", "Email", "Nom",
    	    "Prenom","Username" };
    	  List<Employe> empl = new ArrayList<Employe>();

    	  DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

  	    Date today = new Date();

  	    Date todayWithZeroTime = formatter.parse(formatter.format(today));
    	   

    	    Workbook workbook = new XSSFWorkbook();
    	    Sheet sheet = (Sheet) workbook.createSheet("Admin"+"_"+todayWithZeroTime.toString().substring(4,10)+".xlsx");

    	    Font headerFont = workbook.createFont();
    	    headerFont.setBold(true);
    	    headerFont.setFontHeightInPoints((short) 14);
    	    headerFont.setColor(IndexedColors.RED.getIndex());

    	    CellStyle headerCellStyle = workbook.createCellStyle();
    	    headerCellStyle.setFont(headerFont);

    	    // Create a Row
    	    Row headerRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);

    	    for (int i = 0; i < columns.length; i++) {
    	      Cell cell = headerRow.createCell(i);
    	      cell.setCellValue(columns[i]);
    	      cell.setCellStyle(headerCellStyle);
    	    }

    	    // Create Other rows and cells with contacts data
    	    int rowNum = 1;
    	    proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
   		 
   		 List<Employe> a=proxysuper.afficheadmin();

    	    for (Employe contact : a) {
    	      Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(rowNum++);
    	      row.createCell(0).setCellValue(contact.getEcoleEmploye());
    	      row.createCell(1).setCellValue(contact.getEmailEmploye());
    	      row.createCell(2).setCellValue(contact.getNomEmploye());
    	      row.createCell(3).setCellValue(contact.getPrenomEmploye());
    	      row.createCell(4).setCellValue(contact.getUserNameEmploye());
    	    }

    	    // Resize all columns to fit the content size
    	    for (int i = 0; i < columns.length; i++) {
    	      ((org.apache.poi.ss.usermodel.Sheet) sheet).autoSizeColumn(i);
    	    }

    	    // Write the output to a file
    	    
    	    
    	    FileOutputStream fileOut = new FileOutputStream("Admin"+"_"+todayWithZeroTime.toString().substring(4,10)+".xlsx");
    	    workbook.write(fileOut);
    	    fileOut.close();
    	System.out.println("ok");
    	

}
    @FXML
    void searchbut(ActionEvent event) {
    	rafrechir1();
    	
    	

    }
    @FXML
    void tout(ActionEvent event) {
    	
    	rafrechir();
    	
    	

    }
    public void rafrechir()
    {
    	proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
		 
		 
       
        
      
        	ObservableList<Employe> listeVols = FXCollections.observableArrayList(proxysuper.afficheadmin());
        	listeadmin.setItems(listeVols);
        	
        	 ecoleemp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getEcoleEmploye());
                 }
     });
        	
        	 emailemp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getEmailEmploye());
                 }
     });
        	 
        	
        	 
        	 nomemp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getNomEmploye());
                 }
     });
        	 
        	 prenomemp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getPrenomEmploye());
                 }
     });
       
        	 useremp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getUserNameEmploye());
                 }
     });
       
      
        
      
         
        
        
}
    
    
    public void rafrechir1()
    {String ecole = search.getText();
    	proxysuper = (SuperAdminRemote) EJBLookUpUtil.doLookup(jndiAbsence);
		 
		 List<Employe> a=proxysuper.search(ecole);
       
        
      
        	ObservableList<Employe> listeVols = FXCollections.observableArrayList(proxysuper.search(ecole));
        	listeadmin.setItems(listeVols);
        	
        	 ecoleemp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getEcoleEmploye());
                 }
     });
        	
        	 emailemp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getEmailEmploye());
                 }
     });
        	 
        	
        	 
        	 nomemp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getNomEmploye());
                 }
     });
        	 
        	 prenomemp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getPrenomEmploye());
                 }
     });
       
        	 useremp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Employe, String>, ObservableValue<String>>() {
                 @Override
                 public ObservableValue<String> call(TableColumn.CellDataFeatures<Employe, String> param) {
                     return new ReadOnlyObjectWrapper(param.getValue().getUserNameEmploye());
                 }
     });
       
      
        
      
         
        
        
}
}
