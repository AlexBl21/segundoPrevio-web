package co.edu.ufps.SegundoPrevio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.SegundoPrevio.entities.Employee;
import co.edu.ufps.SegundoPrevio.repositories.EmployeeeRepository;


@Service
public class EmployeeService {
	@Autowired
	private EmployeeeRepository employeeRepository;
	
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}
}
