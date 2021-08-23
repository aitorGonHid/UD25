package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.ISalaDao;
import mainApp.dto.Sala;

@Service
public class SalaServiceImpl implements ISalaService {
	
	@Autowired
	ISalaDao iSalaDao;

	@Override
	public List<Sala> listarSalas() {
		
		return iSalaDao.findAll();
	}

	@Override
	public Sala guardarSala(Sala sala) {
		
		return iSalaDao.save(sala);
	}

	@Override
	public Sala salaXId(Long id) {
		
		return iSalaDao.findById(id).get();
	}

	@Override
	public Sala actualizarSala(Sala sala) {
		
		return iSalaDao.save(sala);
	}

	@Override
	public void eliminarSala(Long id) {
		
		iSalaDao.deleteById(id);
	}

	@Override
	public List<Sala> listarSalaXNombre(String nombre) {
		
		return iSalaDao.findByNombre(nombre);
	}
	
}
