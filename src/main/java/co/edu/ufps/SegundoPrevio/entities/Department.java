package co.edu.ufps.SegundoPrevio.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name",length = 20)
	private String name;
	
	
	@OneToMany(mappedBy = "dep_id")
    private List<Employee> employees;
	
	@ManyToOne
	@JoinColumn(name = "chief_id") 
	private Employee chief_id;
	
	@ManyToMany(mappedBy = "departments")
    private List<Employee> employeesVisited;
}
