package co.edu.ufps.SegundoPrevio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.SegundoPrevio.entities.Department;
import co.edu.ufps.SegundoPrevio.entities.Project_assignment;

public interface Project_assignmentRepository extends JpaRepository<Project_assignment,Integer>{
	 List<Project_assignment> findByProjectId(Integer projectId);
}
