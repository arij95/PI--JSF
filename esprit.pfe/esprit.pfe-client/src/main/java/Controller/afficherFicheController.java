package Controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javax.security.auth.Refreshable;

import org.dom4j.DocumentException;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.glass.events.MouseEvent;

import esprit.pfe.esprit.pfe.persistence.Archive;
import esprit.pfe.esprit.pfe.persistence.Categorie;
import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Etudiant;
import esprit.pfe.esprit.pfe.persistence.FichePfe;
import esprit.pfe.esprit.pfe.services.ArchiveServiceRemote;
import esprit.pfe.esprit.pfe.services.CatServiceRemote;
import esprit.pfe.esprit.pfe.services.EmployeServiceRemote;
import esprit.pfe.esprit.pfe.services.EtudiantServiceRemote;
import esprit.pfe.esprit.pfe.services.ExistEmailRemote;
import esprit.pfe.esprit.pfe.services.FicheServiceRemote;
import esprit.pfe.esprit.pfe.services.VerifRemote;
import esprit.pfe.esprit.pfe.util.EJBLookUpUtil;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;

import tray.notification.NotificationType;
import tray.notification.TrayNotification;




public class afficherFicheController implements Initializable{

	@FXML
    private Label nomSup;

    @FXML
    private Label nomPro;

    @FXML
    private Label mailSup;

    @FXML
    private Label mailPro;

    @FXML
    private JFXTextField titre;

    @FXML
    private JFXTextField desc;

    @FXML
    private JFXTextField prob;

    @FXML
    private JFXTextField fonc;

    @FXML
    private JFXComboBox<String> cat;

    @FXML
    private JFXTextField key;

    @FXML
    private JFXTextField ent;

    @FXML
    private JFXTextField pays;

    @FXML
    private JFXTextField ecole;

    @FXML
    private JFXTextField etat;

    @FXML
    private JFXDatePicker ann;
    @FXML
    private JFXButton modif;
    @FXML
    private JFXButton pdf;
    FicheServiceRemote FicheProxy;
    EtudiantServiceRemote EtudiantProxy;
    EmployeServiceRemote EmployeProxy;
    CatServiceRemote CatProxy;
    ArchiveServiceRemote ArProxy;
    VerifRemote proxyAbsencee;

    String jndiLogin = "esprit.pfe-ear/esprit.pfe-ejb/FicheService!esprit.pfe.esprit.pfe.services.FicheServiceRemote";
    String jndiLogin1 = "esprit.pfe-ear/esprit.pfe-ejb/EtudiantService!esprit.pfe.esprit.pfe.services.EtudiantServiceRemote";
    String jndiLogin2 = "esprit.pfe-ear/esprit.pfe-ejb/EmployeService!esprit.pfe.esprit.pfe.services.EmployeServiceRemote";
    String jndiLogin3 = "esprit.pfe-ear/esprit.pfe-ejb/CatService!esprit.pfe.esprit.pfe.services.CatServiceRemote";
    String jndiLogin4 = "esprit.pfe-ear/esprit.pfe-ejb/ArchiveService!esprit.pfe.esprit.pfe.services.ArchiveServiceRemote";
    String jndiAbsence1="esprit.pfe-ear/esprit.pfe-ejb/Verif!esprit.pfe.esprit.pfe.services.VerifRemote";
    
    private static String FILE = "C:/Users/LENOVO/workspace/client/src/main/pfe.PDF";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    
    @FXML
	private void modifier( ActionEvent e) {
    	
		 	
	    }

   public static FichePfe f= new FichePfe();
   
	public void initialize(URL location, ResourceBundle resources) {
		FicheProxy = (FicheServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
		EtudiantProxy = (EtudiantServiceRemote)EJBLookUpUtil.doLookup(jndiLogin1);
		EmployeProxy = (EmployeServiceRemote)EJBLookUpUtil.doLookup(jndiLogin2);
		CatProxy = (CatServiceRemote)EJBLookUpUtil.doLookup(jndiLogin3);
		ArProxy = (ArchiveServiceRemote)EJBLookUpUtil.doLookup(jndiLogin4);

		
		ArrayList<Categorie> la= CatProxy.reupCat();
		for(Categorie i : la){
			cat.getItems().addAll(i.getNom());
		}
		
		
		Etudiant e= new Etudiant();
		Employe em= new Employe();
		Employe em1= new Employe();
		proxyAbsencee = (VerifRemote) EJBLookUpUtil.doLookup(jndiAbsence1);
		
		//1=id user
		f=FicheProxy.afficher(proxyAbsencee.userconnected().getId());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		String strDate = dateFormat.format(f.getAnneeFiche());  
		titre.setText(f.getTitreFiche());
		desc.setText(f.getDescriptionFiche());
		prob.setText(f.getProbleFiche());
		fonc.setText(f.getFctFiche());
		cat.setValue(f.getCategFiche());
		key.setText(f.getMotCleFiche());
		ent.setText(f.getEntrepFiche());
		ann.setPromptText(strDate);
		//(f.getAnneeFiche().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		pays.setText(f.getPaysFiche());
		ecole.setText(f.getEcoleFiche());
		if(f.getEtatFiche()==0){
			etat.setText("Non traitee");
		}
		else{
		etat.setText("traite");}
		e=EtudiantProxy.getDonneEtu(f.getEtudiant().getIdEtudiant());
		if(f.getEncadrant().getIdEmploye()!=0){
			em=EmployeProxy.getDonnEm(f.getEncadrant().getIdEmploye());
			nomSup.setText(em.getNomEmploye()+" "+em.getPrenomEmploye());
			mailSup.setText(em.getEmailEmploye());
		}
		else{
			nomSup.setText("");
			mailSup.setText("");
		}
		if(f.getRapporteur().getIdEmploye()!=0){
			em1=EmployeProxy.getDonnEm(f.getRapporteur().getIdEmploye());
			nomPro.setText(em.getNomEmploye()+" "+em.getPrenomEmploye());
			mailPro.setText(em.getEmailEmploye());
		}
		else
		{
			nomPro.setText("");
			mailPro.setText("");
		}
		
		
		modif.setOnAction(click -> {
			if(etat.getText().equals("Non traitee")){
				DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");  
				String strDate1 = dateFormat1.format(Date.from(ann.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));  
				if(!f.getFctFiche().equals(fonc.getText())|(!f.getProbleFiche().equals(prob.getText()))){
				 FichePfe f1=new FichePfe(titre.getText(),desc.getText(),prob.getText(),fonc.getText(),cat.getValue(),key.getText(),ent.getText(),pays.getText(),ecole.getText(),0,f.getVersion()+1);
				 FicheProxy = (FicheServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
				 FicheProxy.modifierMaj(f1,f.getIdFiche(),strDate1);
				 
				 FichePfe pf=FicheProxy.getDonneFich(f.getIdFiche());
				 Archive ar= new Archive(pf.getIdFiche(),pf.getTitreFiche(),pf.getDescriptionFiche(),pf.getProbleFiche(),pf.getFctFiche(),pf.getCategFiche(),pf.getMotCleFiche(),pf.getEntrepFiche(),pf.getEtatFiche(),pf.getAnneeFiche(),pf.getPaysFiche(),pf.getEcoleFiche(),pf.getNouvprobleFiche(),pf.getNouvfctFiche(),pf.getVersion(),pf.getEtudiant().getIdEtudiant());
				 ArProxy.creeArchive(ar);
				 
				 
				 }
				else{
					FichePfe f1=new FichePfe(titre.getText(),desc.getText(),prob.getText(),fonc.getText(),cat.getValue(),key.getText(),ent.getText(),pays.getText(),ecole.getText(),0,f.getVersion()+1);
					FicheProxy = (FicheServiceRemote)EJBLookUpUtil.doLookup(jndiLogin);
					 FicheProxy.modifierMin(f1,f.getIdFiche(),strDate1);
					 FichePfe pf1=FicheProxy.getDonneFich(f.getIdFiche());
				    Archive ar= new Archive(pf1.getIdFiche(),pf1.getTitreFiche(),pf1.getDescriptionFiche(),pf1.getProbleFiche(),pf1.getFctFiche(),pf1.getCategFiche(),pf1.getMotCleFiche(),pf1.getEntrepFiche(),pf1.getEtatFiche(),pf1.getAnneeFiche(),pf1.getPaysFiche(),pf1.getEcoleFiche(),pf1.getNouvprobleFiche(),pf1.getNouvfctFiche(),pf1.getVersion(),pf1.getEtudiant().getIdEtudiant());
					 ArProxy.creeArchive(ar);
				}
				 }
				 else{
					 TrayNotification tray =new TrayNotification();
			            tray.setTitle("Erreur");
			        tray.setMessage("Your pfe plug is treated");
			        tray.setNotificationType(NotificationType.ERROR);
			        tray.showAndWait();
				 }
		});
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
		}
        
         document.close();
		
	}
	 private static void addMetaData(Document document) {
	        document.addTitle("My PFE Plug");
	        //document.addSubject(f.getTitreFiche());
	        document.addKeywords(f.getMotCleFiche());
	        document.addAuthor(f.getEtudiant().getNomEtudiant()+" "+f.getEtudiant().getPrenomEtudiant());
	       
	    }
	 private static void addTitlePage(Document document)
	            throws DocumentException, com.itextpdf.text.DocumentException {
	        Paragraph preface = new Paragraph();
	        // We add one empty line
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	        preface.add(new Paragraph(f.getTitreFiche(), catFont));

	        addEmptyLine(preface, 1);
	        // Will create: Report generated by: _name, _date
	        preface.add(new Paragraph(
	        		f.getEtudiant().getNomEtudiant()+" "+f.getEtudiant().getPrenomEtudiant()+" "+ new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	                smallBold));
	        addEmptyLine(preface, 3);
	        preface.add(new Paragraph("Description: "+f.getDescriptionFiche(),smallBold));
	        addEmptyLine(preface, 3);
	        preface.add(new Paragraph("University: "+f.getEcoleFiche(),smallBold));
	        addEmptyLine(preface, 3);
	        preface.add(new Paragraph("Company: "+f.getEntrepFiche(),smallBold));
	        addEmptyLine(preface, 3);
	        preface.add(new Paragraph("Functionality: "+f.getFctFiche(),smallBold));
	        addEmptyLine(preface, 3);
	        preface.add(new Paragraph("Problematic: "+f.getProbleFiche(),smallBold));
	        addEmptyLine(preface, 3);
	        preface.add(new Paragraph("Category: "+f.getCategFiche(),smallBold));
	        addEmptyLine(preface, 3);
	        preface.add(new Paragraph("School year: "+f.getAnneeFiche(),smallBold));
	        addEmptyLine(preface, 3);
	        preface.add(new Paragraph("Status: "+f.getEtatFiche(),smallBold));
	        addEmptyLine(preface, 3);
	        

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
