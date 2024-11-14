package co.edu.ufps.SegundoPrevio.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.SegundoPrevio.entities.Employee;
import co.edu.ufps.SegundoPrevio.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	public ResponseEntity<Employee> create(@RequestBody Employee seleccion) {
		Employee nuevaSeleccion = employeeService.create(seleccion);
		return ResponseEntity.ok(nuevaSeleccion);
	}
	
	@GetMapping("/{id}/salary")
    public Map<String, Object> getEmployeeWithSalary(@PathVariable Integer id) {
        return employeeService.getEmployeeWithSalary(id);
    }
	
	@PutMapping("/{id}/remove-department")
    public Employee removeEmployeeFromDepartment(@PathVariable Integer id) {
        return employeeService.removeEmployeeFromDepartment(id);
    }
}
