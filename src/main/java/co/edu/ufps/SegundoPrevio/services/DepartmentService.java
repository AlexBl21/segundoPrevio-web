package co.edu.ufps.SegundoPrevio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.SegundoPrevio.entities.Department;
import co.edu.ufps.SegundoPrevio.entities.Employee;
import co.edu.ufps.SegundoPrevio.repositories.DepartmentRepository;
import co.edu.ufps.SegundoPrevio.repositories.EmployeeeRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
    private EmployeeeRepository employeeRepository;
	
	public Department get(Integer id) {
		
		Optional<Department> DepartmentOpt = departmentRepository.findById(id);
		if (DepartmentOpt.isPresent()) {
			return DepartmentOpt.get();
		}
		return null;
	}
	
	public Department addEmployeesToDepartment(Integer departmentId, List<Integer> employeeIds) {
        Optional<Department> departmentOpt = departmentRepository.findById(departmentId);

        if (departmentOpt.isPresent()) {
            Department department = departmentOpt.get();
            List<Employee> employees = employeeRepository.findAllById(employeeIds);

            for (Employee employee : employees) {
                employee.setDep_id(department);;
                employeeRepository.save(employee);
            }
            return department;
        }
        return null; 
    }
}
