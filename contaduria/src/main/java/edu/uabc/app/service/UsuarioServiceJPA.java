package edu.uabc.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uabc.app.model.Usuario;
import edu.uabc.app.repository.UsuarioRepository;

@Service
public class UsuarioServiceJPA implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public void insertar(Usuario usuario) {
		usuarioRepo.save(usuario);
	}

	@Override
	public List<Usuario> buscarTodas() {
		List<Usuario> lista = usuarioRepo.findAll();
		return lista;
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		Optional<Usuario>optional = usuarioRepo.findById(idUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int idUsuario) {
		usuarioRepo.deleteById(idUsuario);
	}

	@Override
	public Usuario buscarPorCorreo(String correo) {
		Optional<Usuario> optional = usuarioRepo.findByCorreo(correo);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
