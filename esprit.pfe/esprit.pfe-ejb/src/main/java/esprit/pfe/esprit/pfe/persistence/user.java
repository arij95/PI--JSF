package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class user implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
	private String mdp;
	private int connected;
	private int role;
	private String nom;
	private String prenom;
	private String ecoleEmploye;
	private int idrole;
	
	
	
	public user(String username, String mdp, int connected, int role, String nom, String prenom, String ecoleEmploye,
			int idrole) {
		super();
		this.username = username;
		this.mdp = mdp;
		this.connected = connected;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.ecoleEmploye = ecoleEmploye;
		this.idrole = idrole;
	}
	public user(Integer id, String username, String mdp, int connected, int role, String nom, String prenom,
			String ecoleEmploye, int idrole) {
		super();
		this.id = id;
		this.username = username;
		this.mdp = mdp;
		this.connected = connected;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.ecoleEmploye = ecoleEmploye;
		this.idrole = idrole;
	}
	public int getIdrole() {
		return idrole;
	}
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	public user(String username, String mdp, int connected, int role, String nom, String prenom, String ecoleEmploye) {
		super();
		this.username = username;
		this.mdp = mdp;
		this.connected = connected;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.ecoleEmploye = ecoleEmploye;
	}
	public user(Integer id, String username, String mdp, int connected, int role, String nom, String prenom,
			String ecoleEmploye) {
		super();
		this.id = id;
		this.username = username;
		this.mdp = mdp;
		this.connected = connected;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.ecoleEmploye = ecoleEmploye;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEcoleEmploye() {
		return ecoleEmploye;
	}
	public void setEcoleEmploye(String ecoleEmploye) {
		this.ecoleEmploye = ecoleEmploye;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getConnected() {
		return connected;
	}
	public void setConnected(int connected) {
		this.connected = connected;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(Integer id, String username, String mdp, int connected, int role) {
		super();
		this.id = id;
		this.username = username;
		this.mdp = mdp;
		this.connected = connected;
		this.role = role;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", mdp=" + mdp + ", connected=" + connected + ", role="
				+ role + "]";
	}
	
	
	
	
}
