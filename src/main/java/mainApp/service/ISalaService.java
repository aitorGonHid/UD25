package mainApp.service;

import java.util.List;

import mainApp.dto.Sala;

public interface ISalaService {
	
	//CRUD BASICO
	public List<Sala> listarSalas(); //Listar salas
	
	public Sala guardarSala(Sala sala); //guardar sala
	
	public Sala salaXId(Long id); //Buscar sala por su ID
	
	public Sala actualizarSala(Sala sala); //Actualizar sala
	
	public void eliminarSala(Long id); //Eliminar sala
	
	//Metodos por campos secundarios
	public List<Sala> listarSalaXNombre(String nombre);

}