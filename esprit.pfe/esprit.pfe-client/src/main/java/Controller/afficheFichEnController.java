package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import org.dom4j.DocumentException;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import esprit.pfe.esprit.pfe.persistence.Categorie;
import esprit.pfe.esprit.pfe.persistence.FichePfe;
import esprit.pfe.esprit.pfe.services.CatServiceRemote;
import esprit.pfe.esprit.pfe.services.FicheServiceRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import javafx.scene.control.TableColumn;

public class afficheFichEnController implements Initializable{
	@FXML
	private TableView<FichePfe> tb;
	@FXML
	private TableColumn<FichePfe,String> tit;
	@FXML
	private TableColumn<FichePfe,String>  desc;
	@FXML
	private TableColumn<FichePfe,String>  fonc;
	@FXML
	private TableColumn<FichePfe,String>  prob;
	@FXML
	private JFXRadioButton pre;
	@FXML
	private JFXRadioButton sup;
	@FXML
	private JFXRadioButton rep;
	  @FXML
	    private ToggleGroup group;
	  @FXML
	    private JFXTextField titre;

	    @FXML
	    private JFXTextField de;

	    @FXML
	    private JFXTextField prob1;

	    @FXML
	    private JFXTextField ent;

	    @FXML
	    private JFXTextField fonc1;

	    @FXML
	    private JFXTextField pays;

	    @FXML
	    private JFXTextField ecole;

	    @FXML
	    private JFXComboBox<String> cat;

	    @FXML
	    private JFXTextField etat;

	    @FXML
	    private JFXDatePicker ann;

	    @FXML
	    private JFXTextField mot;

	    @FXML
	    private JFXTextField mark;

	    @FXML
	    private JFXButton sub;
	    @FXML
	    private static JFXTextField reamr;

	    @FXML
	    private JFXButton pd;
	    private static String FILE = "C:/Users/LENOVO/workspace/client/src/main/patts.PDF";
	    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
	            Font.BOLD);
	    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.NORMAL, BaseColor.RED);
	    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
	            Font.BOLD);
	    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD);
	    static FichePfe f= new FichePfe();
	ArrayList<FichePfe> fiches=new ArrayList<FichePfe>();
	FicheServiceRemote FicheProxy;
	 CatServiceRemote CatProxy;
	String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/FicheService!esprit.pfe.esprit.pfe.services.FicheServiceRemote";
	String jndiLogin3 = "esprit.pfe-ear/esprit.pfe-ejb/CatService!esprit.pfe.esprit.pfe.services.CatServiceRemote";
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		FicheProxy = (FicheServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		CatProxy = (CatServiceRemote)EJBLookUpUtil.doLookup(jndiLogin3);
		ArrayList<Categorie> la= CatProxy.reupCat();
		for(Categorie i : la){
			cat.getItems().addAll(i.getNom());
		}
		
		sup.setOnAction(click->{
			fiches=FicheProxy.afficherEnc(4);
			ObservableList obs1=FXCollections.observableArrayList(fiches);
		     tb.setItems(obs1);
		     tit.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("titreFiche"));
		     desc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("descriptionFiche"));
		     fonc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("fctFiche"));
		     prob.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("probleFiche"));
		     sub.setText("Submit as Supervisor");
		     tb.setOnMouseClicked(cli->{
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
		 		if(f.getNoteEnc()<0){
		     		mark.setText("?");
		     	}
		     	else{
		     		mark.setText(Float.toString(f.getNoteEnc()));
		     	}
		 		sub.setOnAction(c->{
		 			if(mark.getText().equals("?")|mark.getText().equals("")){
		 				TrayNotification tray =new TrayNotification();
			            tray.setTitle("Error");
			        tray.setMessage("You have to put a mark");
			        tray.setNotificationType(NotificationType.ERROR);
			        tray.showAndWait();
		 			}else{
		 				FicheProxy.noteEnca(f.getIdFiche(), Float.parseFloat(mark.getText()));
		 			}
				 		
		 		});
		 		pd.setOnAction(t->{
		 			if(f.getNoteEnc()<0){
		    			TrayNotification tray =new TrayNotification();
			            tray.setTitle("Error");
			        tray.setMessage("the pfe don't have a supervisor mark");
			        tray.setNotificationType(NotificationType.ERROR);
			        tray.showAndWait();
		    		}else if(f.getNoteRap()<0){
		    			TrayNotification tray =new TrayNotification();
			            tray.setTitle("Error");
			        tray.setMessage("the pfe plug don't have a protractor mark");
			        tray.setNotificationType(NotificationType.ERROR);
			        tray.showAndWait();
		    		}
		    		else{
		 			 Document document = new Document();
		 	        
		 	         try {
		 	        	 PdfWriter.getInstance(document, new FileOutputStream(FILE));
		 	        	 
		 	             document.open();
		 	             addMetaData(document);
		 				addTitlePage(document);
		 				//addContent(document);
		 			} catch (DocumentException e1) {
		 				// TODO Auto-generated catch block
		 				e1.printStackTrace();
		 			} catch (com.itextpdf.text.DocumentException e1) {
		 				// TODO Auto-generated catch block
		 				e1.printStackTrace();
		 			} catch (FileNotFoundException e1) {
		 				// TODO Auto-generated catch block
		 				e1.printStackTrace();
		 			} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 	        
		 	         document.close();}
		 		});
		 		});
		});
		rep.setOnAction(click->{
			fiches=FicheProxy.afficherRap(4);
			ObservableList obs1=FXCollections.observableArrayList(fiches);
		     tb.setItems(obs1);
		     tit.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("titreFiche"));
		     desc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("descriptionFiche"));
		     fonc.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("fctFiche"));
		     prob.setCellValueFactory(new PropertyValueFactory<FichePfe,String>("probleFiche"));
		     sub.setText("Submit as Protractor");
		     tb.setOnMouseClicked(cli->{
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
		 			if(f.getNoteRap()<0){
			     		mark.setText("?");
			     	}
			     	else{
			     		mark.setText(Float.toString(f.getNoteRap()));
			     	}
			     	sub.setOnAction(c->{
			 			if(mark.getText().equals("?")|mark.getText().equals("")){
			 				TrayNotification tray =new TrayNotification();
				            tray.setTitle("Error");
				        tray.setMessage("You have to put a mark");
				        tray.setNotificationType(NotificationType.ERROR);
				        tray.showAndWait();
			 			}else{
			 				FicheProxy.noteRapp(f.getIdFiche(), Float.parseFloat(mark.getText()));
			 			}
					 		
			 		});
			    	pd.setOnAction(t->{
			    		if(f.getNoteEnc()<0){
			    			TrayNotification tray =new TrayNotification();
				            tray.setTitle("Error");
				        tray.setMessage("the pfe don't have a supervisor mark");
				        tray.setNotificationType(NotificationType.ERROR);
				        tray.showAndWait();
			    		}else if(f.getNoteRap()<0){
			    			TrayNotification tray =new TrayNotification();
				            tray.setTitle("Error");
				        tray.setMessage("the pfe plug don't have a protractor mark");
				        tray.setNotificationType(NotificationType.ERROR);
				        tray.showAndWait();
			    		}
			    		else{
			 			 Document document = new Document();
			 	        
			 	         try {
			 	        	 PdfWriter.getInstance(document, new FileOutputStream(FILE));
			 	        	 
			 	             document.open();
			 	             addMetaData(document);
			 				addTitlePage(document);
			 				//addContent(document);
			 			} catch (DocumentException e1) {
			 				// TODO Auto-generated catch block
			 				e1.printStackTrace();
			 			} catch (com.itextpdf.text.DocumentException e1) {
			 				// TODO Auto-generated catch block
			 				e1.printStackTrace();
			 			} catch (FileNotFoundException e1) {
			 				// TODO Auto-generated catch block
			 				e1.printStackTrace();
			 			} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			 	        
			 	         document.close();}
			 		});
		 		}});
		     	
		});
		
		
	    
	}
	 private static void addMetaData(Document document) {
	        document.addTitle("                              Certificate of achievement");
	        //document.addSubject(f.getTitreFiche());
	       // document.addKeywords(f.getMotCleFiche());
	       // document.addAuthor(f.getEtudiant().getNomEtudiant()+" "+f.getEtudiant().getPrenomEtudiant());
	       
	    }
	 private static void addTitlePage(Document document)
	            throws DocumentException, com.itextpdf.text.DocumentException, MalformedURLException, IOException {
		 
		 Image image2 = Image.getInstance("C:/Users/LENOVO/workspace/client/src/main/sin.jpg");
         //Fixed Positioning
		 
         image2.setAbsolutePosition(410f, 350f);
         //Scale to new height and new width of image
         image2.scaleAbsolute(150, 100);
         //Add to document
         document.add(image2);
		 Image image1 = Image.getInstance("C:/Users/LENOVO/workspace/client/src/main/esprit.jpg");
         //Fixed Positioning
         image1.setAbsolutePosition(410f, 730f);
         //Scale to new height and new width of image
         image1.scaleAbsolute(150, 100);
         //Add to document
         document.add(image1);
	        Paragraph preface = new Paragraph();
	        // We add one empty line
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	       preface.add(new Paragraph("                                  Certificate of achievement",catFont));
	       addEmptyLine(preface, 3);
	        // Will create: Report generated by: _name, _date
	        preface.add(new Paragraph("In "+new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	                smallBold));
	        addEmptyLine(preface, 3);
	        preface.add(new Paragraph("I emphasize below that the student "+f.getEtudiant().getNomEtudiant()+" "+f.getEtudiant().getPrenomEtudiant()+" has validate his project of end study with a mark below "+(f.getNoteEnc()+f.getNoteRap())/2,smallBold));
	        addEmptyLine(preface, 3);
	        addEmptyLine(preface, 3);
	        addEmptyLine(preface, 3);
	        try{
	        if(!reamr.getText().equals(""))
	        {preface.add(new Paragraph("Remaks: "+reamr.getText(),smallBold));}}
	        catch (Exception e) {
				// TODO: handle exception
			}
	        preface.add(new Paragraph("                                                                                                                     Professor Signature ",smallBold));
	        
	        

	        document.add(preface);
	        // Start a new page
	        document.newPage();
	    }
	 private static void addEmptyLine(Paragraph paragraph, int number) {
	        for (int i = 0; i < number; i++) {
	            paragraph.add(new Paragraph(" "));
	        }
	    }
	 private static void addContent(Document document) throws DocumentException, com.itextpdf.text.DocumentException {
	        Anchor anchor = new Anchor("Description: "+f.getDescriptionFiche(), catFont);
	        anchor.setName("Description");

	        // Second parameter is the number of the chapter
	        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

	        // now add all this to the document
	        document.add(catPart);

	        // Next section
	        anchor = new Anchor("University: "+f.getEcoleFiche(), catFont);
	        anchor.setName("University");

	        // Second parameter is the number of the chapter
	        catPart = new Chapter(new Paragraph(anchor), 1);

	        // now add all this to the document
	        document.add(catPart);
	        // Next section
	        anchor = new Anchor("Company: "+f.getEntrepFiche(), catFont);
	        anchor.setName("Company");

	        // Second parameter is the number of the chapter
	        catPart = new Chapter(new Paragraph(anchor), 1);

	        // now add all this to the document
	        document.add(catPart);
	        // Next section
	        anchor = new Anchor("Functionality: "+f.getFctFiche(), catFont);
	        anchor.setName("Functionality");

	        // Second parameter is the number of the chapter
	        catPart = new Chapter(new Paragraph(anchor), 1);

	        // now add all this to the document
	        document.add(catPart);
	        // Next section
	        anchor = new Anchor("Problematic: "+f.getProbleFiche(), catFont);
	        anchor.setName("Problematic");

	        // Second parameter is the number of the chapter
	        catPart = new Chapter(new Paragraph(anchor), 1);

	        // now add all this to the document
	        document.add(catPart);
	     // Next section
	        anchor = new Anchor("Category: "+f.getCategFiche(), catFont);
	        anchor.setName("Category");

	        // Second parameter is the number of the chapter
	        catPart = new Chapter(new Paragraph(anchor), 1);

	        // now add all this to the document
	        document.add(catPart);
	     // Next section
	        anchor = new Anchor("School year: "+f.getAnneeFiche(), catFont);
	        anchor.setName("School year");

	        // Second parameter is the number of the chapter
	        catPart = new Chapter(new Paragraph(anchor), 1);

	        // now add all this to the document
	        document.add(catPart);
	     // Next section
	        anchor = new Anchor("Status: "+f.getEtatFiche(), catFont);
	        anchor.setName("Status");

	        // Second parameter is the number of the chapter
	        catPart = new Chapter(new Paragraph(anchor), 1);

	        // now add all this to the document
	        document.add(catPart);

	    }
}
