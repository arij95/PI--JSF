package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PptValidation implements Serializable {
private static final long serialVersionUID = 1L;

	
	
	private int id_ppt;
	private Employe employeppt;
	private String remarque;
	
	private String signature;
	private int valide;
	private Etudiant stud;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getId_ppt() {
		return id_ppt;
	}
	public void setId_ppt(int id_ppt) {
		this.id_ppt = id_ppt;
	}
	
	@ManyToOne
	public Employe getEmployeppt() {
		return employeppt;
	}
	public void setEmployeppt(Employe employeppt) {
		this.employeppt = employeppt;
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
	public Etudiant getStud() {
		return stud;
	}
	public void setEtud(Etudiant etud) {
		this.stud = etud;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PptValidation() {
		super();
		
	}
	public void setStud(Etudiant stud) {
		this.stud = stud;
	}

	
	
}
	