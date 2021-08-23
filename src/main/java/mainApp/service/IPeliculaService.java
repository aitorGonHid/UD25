package mainApp.service;

import java.util.List;

import mainApp.dto.Pelicula;

public interface IPeliculaService {
	
	//CRUD BASICO
	public List<Pelicula> listarPeliculas(); //
	
	public Pelicula guardarPelicula(Pelicula pelicula);
	
	public Pelicula peliculaXId(Long id);
	
	public Pelicula actualizarPelicula(Pelicula pelicula);
	
	public void eliminarPelicula(Long id);
	
	//Metodos por campos secundarios
	public List<Pelicula> listarPeliculaXNombre(String nombre);
	
	public List<Pelicula> listarPeliculaXCalificacionEdad(int calificacionEdad);

}
