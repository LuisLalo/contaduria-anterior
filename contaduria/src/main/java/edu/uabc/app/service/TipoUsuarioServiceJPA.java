package edu.uabc.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uabc.app.model.TipoUsuario;
import edu.uabc.app.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioServiceJPA implements ITipoUsuarioService {

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepo;

	@Override
	public void insertar(TipoUsuario tipoUsuario) {
		tipoUsuarioRepo.save(tipoUsuario);
	}

	@Override
	public List<TipoUsuario> buscarTodas() {
		List<TipoUsuario> lista = tipoUsuarioRepo.findAll();
		return lista;
	}
	
	@Override
	public TipoUsuario buscarPorId(int idTipoUsuario) {
		Optional<TipoUsuario> optional = tipoUsuarioRepo.findById(idTipoUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int idTipoUsuario) {
		tipoUsuarioRepo.deleteById(idTipoUsuario);
	}

}
