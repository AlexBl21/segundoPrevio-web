package co.edu.ufps.SegundoPrevio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.SegundoPrevio.entities.Project_assignment;
import co.edu.ufps.SegundoPrevio.services.Project_assignmentService;

@RestController
@RequestMapping("/project-assignments")
public class Project_assignmentController {

    @Autowired
    private Project_assignmentService projectAssignmentService;

    @PostMapping("/add")
    public Project_assignment addEmployeeToProject(@RequestParam Integer employeeId, 
                                                  @RequestParam Integer projectId, 
                                                  @RequestParam Integer roleId) {
        return projectAssignmentService.addEmployeeToProject(employeeId, projectId, roleId);
    }
}