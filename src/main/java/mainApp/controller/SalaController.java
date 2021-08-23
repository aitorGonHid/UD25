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

import mainApp.service.SalaServiceImpl;
import mainApp.dto.Sala;

@RestController
@RequestMapping("/api")
public class SalaController {
	
	@Autowired
	SalaServiceImpl salaServiceImpl;
	
	@GetMapping("/salas")
	public List<Sala> listarSalas() {
		
		return salaServiceImpl.listarSalas();
	}

	@PostMapping("/salas")
	public Sala guardarSala(Sala sala) {
		
		return salaServiceImpl.guardarSala(sala);
	}

	@GetMapping("/salas/{id}")
	public Sala salaXId(@PathVariable(name="id") Long id) {
		
		Sala sala_x_id = new Sala();
		
		sala_x_id = salaServiceImpl.salaXId(id);
		
		System.out.println("Sala id: "+id+"\n"+sala_x_id.toString());
		
		return sala_x_id;
	}

	@PutMapping("/salas/{id}")
	public Sala actualizarSala(@PathVariable(name="id") Long id, @RequestBody Sala sala) {
		
		Sala sala_select = new Sala();
		Sala sala_updated = new Sala();
		
		sala_select = salaServiceImpl.salaXId(id);
		
		sala_select.setNombre(sala.getNombre());
		sala_select.setPelicula(sala.getPelicula());
		
		sala_updated = salaServiceImpl.actualizarSala(sala_select);
		System.out.println("Sala actualizada: "+sala_updated.toString());
		
		return sala_updated;
		
	}

	@DeleteMapping("/salas/{id}")
	public void eliminarSala(@PathVariable(name="id") Long id) {
		
		salaServiceImpl.eliminarSala(id);
	}
	
	@GetMapping("/salas/nombre/{nombre}")
	public List <Sala> listarPeliculaXNombre(@PathVariable(name="nombre")String nombre) {
		return salaServiceImpl.listarSalaXNombre(nombre);
	}
}
