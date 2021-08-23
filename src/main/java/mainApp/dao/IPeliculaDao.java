package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Pelicula;

public interface IPeliculaDao extends JpaRepository<Pelicula, Long> {
	
	public List<Pelicula> findByNombre(String nombre); // Listar peliculas por nombre
	
	public List<Pelicula> findByCalificacionEdad(Integer calificacionEdad); // Listar peliculas por calificacion edad

}
