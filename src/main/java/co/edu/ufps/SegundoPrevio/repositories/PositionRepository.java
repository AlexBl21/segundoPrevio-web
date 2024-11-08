package co.edu.ufps.SegundoPrevio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.SegundoPrevio.entities.Department;
import co.edu.ufps.SegundoPrevio.entities.Position;

public interface PositionRepository extends JpaRepository<Position,Integer>{

}
