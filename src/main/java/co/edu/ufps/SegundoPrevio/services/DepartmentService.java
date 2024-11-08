package co.edu.ufps.SegundoPrevio.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.ufps.SegundoPrevio.entities.Department;
import co.edu.ufps.SegundoPrevio.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	private DepartmentRepository departmentRepository;
	
	public Department get(Integer id) {
		
		
		Optional<Department> DepartmentOpt = departmentRepository.findById(id);
		if (DepartmentOpt.isPresent()) {
			return DepartmentOpt.get();
		}
		return null;
	}
}
