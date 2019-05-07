package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Departement implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private int id;
private String department;
private String departmenthead;
private SiteUniversity sitee;
private List<Optionne> optionne;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

@ManyToOne
public SiteUniversity getSitee() {
	return sitee;
}
public void setSitee(SiteUniversity sitee) {
	this.sitee = sitee;
}

public Departement(String department) {
	super();
	this.setDepartment(department);
}
public Departement(String department, SiteUniversity sitee) {
	super();
	this.setDepartment(department);
	this.sitee = sitee;
}
public Departement() {
	super();
	// TODO Auto-generated constructor stub
}
@OneToMany(mappedBy = "dep", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
public List<Optionne> getOptionne() {
	return optionne;
}
public void setOptionne(List<Optionne> optionne) {
	this.optionne = optionne;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getDepartmenthead() {
	return departmenthead;
}
public void setDepartmenthead(String departmenthead) {
	this.departmenthead = departmenthead;
}
public Departement(String department, SiteUniversity sitee, String departmenthead) {
	super();
	this.department = department;
	
	this.sitee = sitee;
	this.departmenthead = departmenthead;
}







}
