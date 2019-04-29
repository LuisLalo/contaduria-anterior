package edu.uabc.app.service;

import java.util.List;

import edu.uabc.app.model.Usuario;

public interface IUsuarioService {

	void insertar(Usuario usuario);
	List<Usuario> buscarTodas();
	Usuario buscarPorId(int idUsuario);
	void eliminar(int idUsuario);
	Usuario buscarPorCorreo(String correo);
}
