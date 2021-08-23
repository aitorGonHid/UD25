package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.service.PeliculaServiceImpl;
import mainApp.dto.Pelicula;

@RestController
@RequestMapping("/api")
public class PeliculaController {
	
	@Autowired
	PeliculaServiceImpl peliculaServiceImpl;
	
	@GetMapping("/peliculas")
	public List<Pelicula> listarPeliculas() {
		
		return peliculaServiceImpl.listarPeliculas();
	}

	@PostMapping("/peliculas")
	public Pelicula guardarPelicula(Pelicula pelicula) {
		
		return peliculaServiceImpl.guardarPelicula(pelicula);
	}

	@GetMapping("/peliculas/{id}")
	public Pelicula peliculaXId(@PathVariable(name="id") Long id) {
		
		Pelicula pelicula_x_id = new Pelicula();
		
		pelicula_x_id = peliculaServiceImpl.peliculaXId(id);
		
		System.out.println("Pelicula id: "+id+"\n"+pelicula_x_id.toString());
		
		return pelicula_x_id;
	}

	@PutMapping("/peliculas/{id}")
	public Pelicula actualizarPelicula(@PathVariable(name="id") Long id, @RequestBody Pelicula pelicula) {
		
		Pelicula pelicula_select = new Pelicula();
		Pelicula pelicula_updated = new Pelicula();
		
		pelicula_select = peliculaServiceImpl.peliculaXId(id);
		
		pelicula_select.setNombre(pelicula.getNombre());
		pelicula_select.setCalificacionEdad(pelicula.getCalificacionEdad());
		
		pelicula_updated = peliculaServiceImpl.actualizarPelicula(pelicula_select);
		System.out.println("Pelicula actualizada: "+pelicula_updated.toString());
		
		return pelicula_updated;
		
	}

	@DeleteMapping("/peliculas/{id}")
	public void eliminarPelicula(@PathVariable(name="id") Long id) {
		
		peliculaServiceImpl.eliminarPelicula(id);
	}
	
	@GetMapping("/peliculas/nombre/{nombre}")
	public List <Pelicula> listarPeliculaXNombre(@PathVariable(name="nombre")String nombre) {
		return peliculaServiceImpl.listarPeliculaXNombre(nombre);
	}
	
	@GetMapping("/peliculas/calificacionEdad/{calificacionEdad}")
	public List <Pelicula> listarPeliculaXCalificacionEdad(@PathVariable(name="calificacionEdad")int calificacionEdad) {
		return peliculaServiceImpl.listarPeliculaXCalificacionEdad(calificacionEdad);
	}
}
