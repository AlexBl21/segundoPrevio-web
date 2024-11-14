package co.edu.ufps.SegundoPrevio.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import co.edu.ufps.SegundoPrevio.entities.Project;
import co.edu.ufps.SegundoPrevio.entities.Project_assignment;
import co.edu.ufps.SegundoPrevio.repositories.ProjectRepository;
import co.edu.ufps.SegundoPrevio.repositories.Project_assignmentRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
    private Project_assignmentRepository projectAssignmentRepository;
	
	public List<Project> list (){
		return projectRepository.findAll();
	}
	
	@PostMapping
	public Project update(Integer id, Project projectDetails) {
		Optional<Project> ProjectOpt = projectRepository.findById(id);

		if (!ProjectOpt.isPresent()) {
			return null;
		}

		Project project = ProjectOpt.get();
		project.setName(projectDetails.getName());
		project.setDescripcion(projectDetails.getDescripcion());
		project.setStart_date(projectDetails.getStart_date());
		project.setEnd_date(projectDetails.getEnd_date());

		return projectRepository.save(project);
	}
	
	public List<Map<String, Object>> listEmployeesWithRoles(Integer projectId) {
        List<Project_assignment> assignments = projectAssignmentRepository.findByProjectId(projectId);
        List<Map<String, Object>> result = new ArrayList<>();

        for (Project_assignment assignment : assignments) {
            Map<String, Object> employeeRole = new HashMap<>();
            employeeRole.put("employee", assignment.getEmployee());
            employeeRole.put("role", assignment.getRole());
            result.add(employeeRole);
        }
        return result;
    }
}
