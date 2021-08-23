package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Sala;

public interface ISalaDao extends JpaRepository<Sala, Long> {
	
	public List<Sala> findByNombre(String nombre);

}
