package co.edu.ufps.SegundoPrevio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/{id}/add-employees")
    public Department addEmployeesToDepartment(@PathVariable Integer id, @RequestBody List<Integer> employeeIds) {
        return departmentService.addEmployeesToDepartment(id, employeeIds);
    }

}
