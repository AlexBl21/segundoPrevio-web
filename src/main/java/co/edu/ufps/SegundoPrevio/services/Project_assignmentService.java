package co.edu.ufps.SegundoPrevio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.SegundoPrevio.entities.Employee;
import co.edu.ufps.SegundoPrevio.entities.Project;
import co.edu.ufps.SegundoPrevio.entities.Project_assignment;
import co.edu.ufps.SegundoPrevio.entities.Role;
import co.edu.ufps.SegundoPrevio.repositories.EmployeeeRepository;
import co.edu.ufps.SegundoPrevio.repositories.ProjectRepository;
import co.edu.ufps.SegundoPrevio.repositories.Project_assignmentRepository;
import co.edu.ufps.SegundoPrevio.repositories.RolRepository;

@Service
public class Project_assignmentService {

	@Autowired
    private Project_assignmentRepository projectAssignmentRepository;

    @Autowired
    private EmployeeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RolRepository roleRepository;
    
    public Project_assignment addEmployeeToProject(Integer employeeId, Integer projectId, Integer roleId) {
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        Optional<Role> roleOpt = roleRepository.findById(roleId);

        if (employeeOpt.isPresent() && projectOpt.isPresent() && roleOpt.isPresent()) {
            Project_assignment assignment = new Project_assignment();
            assignment.setEmployee(employeeOpt.get());
            assignment.setProject(projectOpt.get());
            assignment.setRole(roleOpt.get());
            return projectAssignmentRepository.save(assignment);
        }
        return null;
    }
}
