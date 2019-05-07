package esprit.pfe.esprit.pfe.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import esprit.pfe.esprit.pfe.persistence.Employe;
import esprit.pfe.esprit.pfe.persistence.Plateforme;
import esprit.pfe.esprit.pfe.persistence.SiteUniversity;
import esprit.pfe.esprit.pfe.persistence.Todo;
import esprit.pfe.esprit.pfe.services.EmployeeService;
import esprit.pfe.esprit.pfe.services.PlateformeService;
import esprit.pfe.esprit.pfe.services.TodoServiceLocal;

@ManagedBean
@SessionScoped
public class TodoBean {

	@EJB
	private TodoServiceLocal todoServiceLocal;

	private List<Todo> todos;
	private Todo todo;

	public TodoBean() {
	}

	@PostConstruct
	public void init() {
		todos = todoServiceLocal.findAll();
		todo = new Todo();
	}

	public String doCreateTodo() {
		String navigateTo = "/todos?faces-redirect=true";
		todoServiceLocal.create(todo);
		return navigateTo;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}

	 private  Plateforme plateforme;
	    private int id_plateforme;
		private Employe employe;
		private String university;
		
		private String year;
		private String image;
		private List<SiteUniversity> site = new ArrayList<>();
	  Employe e = new Employe(1,"arij", "arij","arij@arij.com",
			  "arij", "Admin","esprit");
	    @EJB
	    PlateformeService plateformeService;
	    
	    public void addPlateforme(){
	    	plateforme = new Plateforme(1, e,e.getEcoleEmploye(), "aaar", "String image");
	    	
	    	
	    	plateformeService.addinterview(plateforme);
	    }
	   
		public Plateforme getPlateforme() {
			return plateforme;
		}
		public void setPlateforme(Plateforme plateforme) {
			this.plateforme = plateforme;
		}
		public Employe getEmploye() {
			return employe;
		}
		public void setEmploye(Employe employe) {
			this.employe = employe;
		}
		public int getId_plateforme() {
			return id_plateforme;
		}
		public void setId_plateforme(int id_plateforme) {
			this.id_plateforme = id_plateforme;
		}
		public String getUniversity() {
			return university;
		}
		public void setUniversity(String university) {
			this.university = university;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public List<SiteUniversity> getSite() {
			return site;
		}
		public void setSite(List<SiteUniversity> site) {
			this.site = site;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		
		
		
}

