package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IPeliculaDao;
import mainApp.dto.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

	@Autowired
	IPeliculaDao iPeliculaDao;
	
	@Override
	public List<Pelicula> listarPeliculas() {
		
		return iPeliculaDao.findAll();
	}

	@Override
	public Pelicula guardarPelicula(Pelicula pelicula) {
		
		return iPeliculaDao.save(pelicula);
	}

	@Override
	public Pelicula peliculaXId(Long id) {
		
		return iPeliculaDao.findById(id).get();
	}

	@Override
	public Pelicula actualizarPelicula(Pelicula pelicula) {
		
		return iPeliculaDao.save(pelicula);
	}

	@Override
	public void eliminarPelicula(Long id) {
		
		iPeliculaDao.deleteById(id);
	}

	@Override
	public List<Pelicula> listarPeliculaXNombre(String nombre) {
		
		return iPeliculaDao.findByNombre(nombre);
	}

	@Override
	public List<Pelicula> listarPeliculaXCalificacionEdad(int calificacionEdad) {
		
		return iPeliculaDao.findByCalificacionEdad(calificacionEdad);
	}
	

}
