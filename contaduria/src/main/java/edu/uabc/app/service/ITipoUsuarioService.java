package edu.uabc.app.service;

import java.util.List;

import edu.uabc.app.model.TipoUsuario;

public interface ITipoUsuarioService {

	void insertar(TipoUsuario tipoUsuario);
	List<TipoUsuario> buscarTodas();
	TipoUsuario buscarPorId(int idTipoUsuario);
	void eliminar(int idTipoUsuario);
}
