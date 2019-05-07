package esprit.pfe.esprit.pfe.persistence;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Etudiant implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    private int idEtudiant;
    
    
    private String nomEtudiant;
    
   
    private String prenomEtudiant;
    
    
    private String ecoleEtudiant;
    
    
    private String emailEtudiant;
    
    
    private String passwordEtudiant;
    
    
    private String userNameEtudiant;
    private PptValidation pptt;
   
    private int classenum;
    private RapportValidation rapp;
    
    public int getClassenum() {
		return classenum;
	}
	public void setClassenum(int classenum) {
		this.classenum = classenum;
	}
	public String getOptionstudent() {
		return optionstudent;
	}
	public void setOptionstudent(String optionstudent) {
		this.optionstudent = optionstudent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String optionstudent;
    
    
    private boolean creditPedagogiqueEtudiant;
    
    
    private boolean creditFinaciereEtudiant;
    
    
    private int autorisationEtudiant;
    private int enregistrement;
    private int encadrant;
    
    public int getEnregistrement() {
		return enregistrement;
	}
	public void setEnregistrement(int enregistrement) {
		this.enregistrement = enregistrement;
	}
	private int annulation;
    private String msg;
    
    

	
	   //fiche,encadr,rapporteur fk !!!!!!!!!!!!!!!!!!!!!!
    
	//*********************************************************


//**********************
private FichePfe fiche;
@OneToOne(mappedBy = "etudiant", cascade = CascadeType.REMOVE)
public FichePfe getFiche() {
	return fiche;
}
public void setFiche(FichePfe fiche) {
	this.fiche = fiche;
}
//****************
private Convention con;
@OneToOne(mappedBy = "etudiant", cascade = CascadeType.REMOVE)
public Convention getCon() {
	return con;
}
public void setCon(Convention con) {
	this.con =con;
}
//********************

public void setIdEtudiant(int idEtudiant) {
	this.idEtudiant = idEtudiant;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID")
public int getIdEtudiant() {
	return idEtudiant;
}

	public String getNomEtudiant() {
		return nomEtudiant;
	}

	@OneToOne(mappedBy = "stud", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public PptValidation getPptt() {
		return pptt;
	}
	public void setPptt(PptValidation pptt) {
		this.pptt = pptt;
	}
	public void setNomEtudiant(String nomEtudiant) {
		this.nomEtudiant = nomEtudiant;
	}

	public String getPrenomEtudiant() {
		return prenomEtudiant;
	}

	public void setPrenomEtudiant(String prenomEtudiant) {
		this.prenomEtudiant = prenomEtudiant;
	}

	public String getEcoleEtudiant() {
		return ecoleEtudiant;
	}

	public void setEcoleEtudiant(String ecoleEtudiant) {
		this.ecoleEtudiant = ecoleEtudiant;
	}

	public String getEmailEtudiant() {
		return emailEtudiant;
	}

	public void setEmailEtudiant(String emailEtudiant) {
		this.emailEtudiant = emailEtudiant;
	}

	public String getPasswordEtudiant() {
		return passwordEtudiant;
	}

	public void setPasswordEtudiant(String passwordEtudiant) {
		this.passwordEtudiant = passwordEtudiant;
	}

	public String getUserNameEtudiant() {
		return userNameEtudiant;
	}

	public void setUserNameEtudiant(String userNameEtudiant) {
		this.userNameEtudiant = userNameEtudiant;
	}

	

	public boolean isCreditPedagogiqueEtudiant() {
		return creditPedagogiqueEtudiant;
	}

	public void setCreditPedagogiqueEtudiant(boolean creditPedagogiqueEtudiant) {
		this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
	}

	public boolean isCreditFinaciereEtudiant() {
		return creditFinaciereEtudiant;
	}

	public void setCreditFinaciereEtudiant(boolean creditFinaciereEtudiant) {
		this.creditFinaciereEtudiant = creditFinaciereEtudiant;
	}
	

	public int getAutorisationEtudiant() {
		return autorisationEtudiant;
	}

	public void setAutorisationEtudiant(int autorisationEtudiant) {
		this.autorisationEtudiant = autorisationEtudiant;
	}

	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String ecoleEtudiant,
			String emailEtudiant, String passwordEtudiant, String userNameEtudiant, int classenum,
			String optionstudent, boolean creditPedagogiqueEtudiant, boolean creditFinaciereEtudiant) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.ecoleEtudiant = ecoleEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.passwordEtudiant = passwordEtudiant;
		this.userNameEtudiant = userNameEtudiant;
		this.classenum = classenum;
		this.optionstudent = optionstudent;
		this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
		this.creditFinaciereEtudiant = creditFinaciereEtudiant;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant="
				+ prenomEtudiant + ", ecoleEtudiant=" + ecoleEtudiant + ", emailEtudiant=" + emailEtudiant
				+ ", passwordEtudiant=" + passwordEtudiant + ", userNameEtudiant=" + userNameEtudiant
				+ ", classeEtudiant=" + classenum + ", optionEtudiant=" + optionstudent
				+ ", creditPedagogiqueEtudiant=" + creditPedagogiqueEtudiant + ", creditFinaciereEtudiant="
				+ creditFinaciereEtudiant + "]";
	}
	public Etudiant() {
		super();
	}
	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String ecoleEtudiant,
			String emailEtudiant, String passwordEtudiant, String userNameEtudiant, int classenum,
			String optionstudent, boolean creditPedagogiqueEtudiant, boolean creditFinaciereEtudiant,
			int autorisationEtudiant, Employe employesEnc, Employe employesRappor) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.ecoleEtudiant = ecoleEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.passwordEtudiant = passwordEtudiant;
		this.userNameEtudiant = userNameEtudiant;
		this.classenum = classenum;
		this.optionstudent = optionstudent;
		this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
		this.creditFinaciereEtudiant = creditFinaciereEtudiant;
		this.autorisationEtudiant = autorisationEtudiant;
		
		
	}
	public Etudiant(String nomEtudiant, String prenomEtudiant, String emailEtudiant, String userNameEtudiant,
			boolean creditPedagogiqueEtudiant, boolean creditFinaciereEtudiant, int autorisationEtudiant) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.userNameEtudiant = userNameEtudiant;
		this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
		this.creditFinaciereEtudiant = creditFinaciereEtudiant;
		this.autorisationEtudiant = autorisationEtudiant;
	}
	public Etudiant(String nomEtudiant, String prenomEtudiant, String ecoleEtudiant, String emailEtudiant,
			String userNameEtudiant, boolean creditPedagogiqueEtudiant, boolean creditFinaciereEtudiant,int autorisationEtudiant,
			String optionstudent, int classenum) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.ecoleEtudiant = ecoleEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.userNameEtudiant = userNameEtudiant;
		this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
		this.creditFinaciereEtudiant = creditFinaciereEtudiant;
		this.autorisationEtudiant = autorisationEtudiant;
		this.optionstudent = optionstudent;
		this.classenum = classenum;
	}
	
	public Etudiant(String nomEtudiant, String prenomEtudiant, String ecoleEtudiant, String emailEtudiant,
			String userNameEtudiant, boolean creditPedagogiqueEtudiant, boolean creditFinaciereEtudiant,
			String optionstudent, int classenum) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.ecoleEtudiant = ecoleEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.userNameEtudiant = userNameEtudiant;
		this.creditPedagogiqueEtudiant = creditPedagogiqueEtudiant;
		this.creditFinaciereEtudiant = creditFinaciereEtudiant;
		//this.autorisationEtudiant = autorisationEtudiant;
		this.optionstudent = optionstudent;
		this.classenum = classenum;
	}
	public int getAnnulation() {
		return annulation;
	}
	public void setAnnulation(int annulation) {
		this.annulation = annulation;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@OneToOne(mappedBy = "etud", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	public RapportValidation getRapp() {
		return rapp;
	}
	public void setRapp(RapportValidation rapp) {
		this.rapp = rapp;
	}
	public Etudiant(int idEtudiant, String nomEtudiant, String prenomEtudiant, String ecoleEtudiant,
			String emailEtudiant, String userNameEtudiant, int enregistrement) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.ecoleEtudiant = ecoleEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.userNameEtudiant = userNameEtudiant;
		this.enregistrement = enregistrement;
	}
	public Etudiant(int idEtudiant, int encadrant, String nomEtudiant, String prenomEtudiant, String ecoleEtudiant,
			String emailEtudiant, String userNameEtudiant) {
		super();
		this.idEtudiant = idEtudiant;
		this.encadrant = encadrant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.ecoleEtudiant = ecoleEtudiant;
		this.emailEtudiant = emailEtudiant;
		this.userNameEtudiant = userNameEtudiant;
		
	}
	public int getEncadrant() {
		return encadrant;
	}
	public void setEncadrant(int encadrant) {
		this.encadrant = encadrant;
	}

	

	



    
    
	

}
