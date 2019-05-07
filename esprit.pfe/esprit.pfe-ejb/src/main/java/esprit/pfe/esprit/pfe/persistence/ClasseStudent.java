package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class ClasseStudent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     private Integer id ; 
     private int classNumber;
    private Optionne optionne;
   
     
     @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@ManyToOne
	public Optionne getOptionne() {
		return optionne;
	}
	public void setOptionne(Optionne optionne) {
		this.optionne = optionne;
	}
	
	public ClasseStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClasseStudent(int classNumber, Optionne optionne) {
		super();
		this.classNumber = classNumber;
		this.optionne = optionne;
	}
	
	
	
	
	
     
	
}
