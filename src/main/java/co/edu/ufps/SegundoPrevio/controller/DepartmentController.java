package co.edu.ufps.SegundoPrevio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.SegundoPrevio.entities.Department;
import co.edu.ufps.SegundoPrevio.services.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> get(@PathVariable Integer id) {
		return ResponseEntity.ok(departmentService.get(id));
	}

}
