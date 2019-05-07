package esprit.pfe.esprit.pfe.services;

import java.util.List;

import javax.ejb.Local;

import esprit.pfe.esprit.pfe.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
