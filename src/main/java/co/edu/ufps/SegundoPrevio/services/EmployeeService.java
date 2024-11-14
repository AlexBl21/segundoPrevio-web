package co.edu.ufps.SegundoPrevio.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
	
	
	public Map<String, Object> getEmployeeWithSalary(Integer id) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);

        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            Map<String, Object> result = new HashMap<>();
            result.put("employee", employee);
            result.put("salary", employee.getPos_id().getSalary());
            return result;
        }
        return null; 
    }
	
	public Employee removeEmployeeFromDepartment(Integer employeeId) {
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);

        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setDep_id(null);;
            return employeeRepository.save(employee);
        }
        return null; 
    }
}
