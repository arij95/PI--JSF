package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Convention implements Serializable{

	private int id;
	private Date dateDebut;
	private Date dateFin;
	private String Entreprise;
	private String SiteWeb;
	private String adresse;
	private String pays;
	private String nomRe;
	private String preRe;
	private String mailRe;
	private String mailEnca;
	private int tel;
	private Etudiant etudiant;
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "ID")  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getEntreprise() {
		return Entreprise;
	}
	public void setEntreprise(String entreprise) {
		Entreprise = entreprise;
	}
	public String getSiteWeb() {
		return SiteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		SiteWeb = siteWeb;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getNomRe() {
		return nomRe;
	}
	public void setNomRe(String nomRe) {
		this.nomRe = nomRe;
	}
	public String getPreRe() {
		return preRe;
	}
	public void setPreRe(String preRe) {
		this.preRe = preRe;
	}
	public String getMailRe() {
		return mailRe;
	}
	public void setMailRe(String mailRe) {
		this.mailRe = mailRe;
	}
	public String getMailEnca() {
		return mailEnca;
	}
	public void setMailEnca(String mailEnca) {
		this.mailEnca = mailEnca;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	@OneToOne
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Convention(Date dateDebut, Date dateFin, String entreprise, String siteWeb, String adresse, String pays,
			String nomRe, String preRe, String mailRe, String mailEnca, int tel, Etudiant etudiant) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		Entreprise = entreprise;
		SiteWeb = siteWeb;
		this.adresse = adresse;
		this.pays = pays;
		this.nomRe = nomRe;
		this.preRe = preRe;
		this.mailRe = mailRe;
		this.mailEnca = mailEnca;
		this.tel = tel;
		this.etudiant = etudiant;
	}
	public Convention() {
		super();
	}
	
	
	
}
