package co.edu.ufps.SegundoPrevio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
