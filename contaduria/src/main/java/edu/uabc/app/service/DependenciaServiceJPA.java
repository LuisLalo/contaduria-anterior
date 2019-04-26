package edu.uabc.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uabc.app.model.Dependencia;
import edu.uabc.app.repository.DependenciaRepository;

@Service
public class DependenciaServiceJPA implements IDependenciaService {

	@Autowired
	private DependenciaRepository dependenciaRepo;
	
	@Override
	public void insertar(Dependencia dependencia) {
		dependenciaRepo.save(dependencia);
	}

	@Override
	public List<Dependencia> buscarTodas() {
		List<Dependencia> lista = dependenciaRepo.findAll();
		return lista;
	}

	@Override
	public Dependencia buscarPorId(int idDependencia) {
		Optional<Dependencia> optional = dependenciaRepo.findById(idDependencia);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int idDependencia) {
		dependenciaRepo.deleteById(idDependencia);
		
	}

}
