package co.edu.ufps.SegundoPrevio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.ufps.SegundoPrevio.entities.Project;
import co.edu.ufps.SegundoPrevio.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> list (){
		return projectRepository.findAll();
	}
	
	public Project create(Project seleccion) {
		return projectRepository.save(seleccion);
	}
}
