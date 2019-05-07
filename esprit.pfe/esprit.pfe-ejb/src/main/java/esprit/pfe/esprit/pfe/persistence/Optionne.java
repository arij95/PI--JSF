package esprit.pfe.esprit.pfe.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Option
 *
 */
@Entity

public class Optionne implements Serializable {

	   
	
	private int IdOption;
	private String optionName;
	private Departement dep;
	private List<ClasseStudent> classe;
	private static final long serialVersionUID = 1L;

	public Optionne() {
		super();
	}   
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdOption() {
		return this.IdOption;
	}

	public void setIdOption(int IdOption) {
		this.IdOption = IdOption;
	}   
	public String getOptionName() {
		return this.optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	@ManyToOne
	public Departement getDep() {
		return dep;
	}
	public void setDep(Departement departement) {
		this.dep = departement;
	}
	@OneToMany(mappedBy = "optionne", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<ClasseStudent> getClasse() {
		return classe;
	}
	public void setClasse(List<ClasseStudent> classe) {
		this.classe = classe;
	}
	public Optionne(int idOption, String optionName, Departement dep, List<ClasseStudent> classe) {
		super();
		IdOption = idOption;
		this.optionName = optionName;
		this.dep = dep;
		this.classe = classe;
	}
	public Optionne(String optionName, Departement dep) {
		super();
		this.optionName = optionName;
		this.dep = dep;
	}
	
	
	
	
}
