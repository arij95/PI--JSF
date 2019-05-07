package esprit.pfe.esprit.pfe.persistence;


import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

@Entity
public class RapportValidation implements Serializable {
private static final long serialVersionUID = 1L;

	
	
	private int id_rapport;
	private Employe employerapport;
	private String remarque;
	
	private String signature;
	private int valide;
	private Etudiant etud;
	private String rapportdepot;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getId_rapport() {
		return id_rapport;
	}
	public void setId_rapport(int id_rapport) {
		this.id_rapport = id_rapport;
	}
	
	@ManyToOne
	public Employe getEmployerapport() {
		return employerapport;
	}
	public void setEmployerapport(Employe employerapport) {
		this.employerapport = employerapport;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public int getValide() {
		return valide;
	}
	public void setValide(int valide) {
		this.valide = valide;
	}
	@OneToOne
	public Etudiant getEtud() {
		return etud;
	}
	public void setEtud(Etudiant etud) {
		this.etud = etud;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public RapportValidation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRapportdepot() {
		return rapportdepot;
	}
	public void setRapportdepot(String rapportdepot) {
		this.rapportdepot = rapportdepot;
	}
	public RapportValidation(Employe employerapport, String remarque, String signature, int valide,
			Etudiant etud, String rapportdepot,int id_rapport) {
		super();
		this.id_rapport = id_rapport;
		this.employerapport = employerapport;
		this.remarque = remarque;
		this.signature = signature;
		this.valide = valide;
		this.etud = etud;
		this.rapportdepot = rapportdepot;
	}
	public RapportValidation(Employe employerapport, Etudiant etud, String rapportdepot) {
		super();
		this.employerapport = employerapport;
		this.etud = etud;
		this.rapportdepot = rapportdepot;
	}
	public RapportValidation(int id_rapport, String remarque, String signature) {
		super();
		this.id_rapport = id_rapport;
		this.remarque = remarque;
		this.signature = signature;
	}

	public RapportValidation(Employe employerapport, String remarque, String signature, int valide,
			Etudiant etud, String rapportdepot) {
		super();
		
		this.employerapport = employerapport;
		this.remarque = remarque;
		this.signature = signature;
		this.valide = valide;
		this.etud = etud;
		this.rapportdepot = rapportdepot;
	}
	public RapportValidation( String remarque, String signature, int valide,int id_rapport) {
		super();
		
		this.remarque = remarque;
		this.signature = signature;
		this.valide = valide;
		this.id_rapport = id_rapport;
	}
	
	
}
	