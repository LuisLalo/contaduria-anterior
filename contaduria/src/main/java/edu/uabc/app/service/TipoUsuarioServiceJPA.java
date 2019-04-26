package edu.uabc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uabc.app.model.TipoUsuario;
import edu.uabc.app.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioServiceJPA implements ITipoUsuarioService {

	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepo;
	
	@Override
	public List<TipoUsuario> buscarTodas() {
		List<TipoUsuario> lista = tipoUsuarioRepo.findAll();
		return lista;
	}

}
