package co.edu.ufps.SegundoPrevio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.SegundoPrevio.entities.Project;
import co.edu.ufps.SegundoPrevio.services.ProjectService;

@RestController
@RequestMapping("/proyectos")
public class ProjectController {
	
	@Autowired 
	private ProjectService projectService;
	
	@GetMapping
	public ResponseEntity<List<Project>> list() {
		return ResponseEntity.ok(projectService.list());
	}
	
	@PostMapping()
	public ResponseEntity<Project> create(@PathVariable Integer id,@RequestBody Project seleccion) {
		Project nuevaSeleccion = projectService.update(id, seleccion);
		return ResponseEntity.ok(nuevaSeleccion);
	}
	
	@GetMapping("/{id}/employees-roles")
    public List<Map<String, Object>> listEmployeesWithRoles(@PathVariable Integer id) {
        return projectService.listEmployeesWithRoles(id);
    }
}
