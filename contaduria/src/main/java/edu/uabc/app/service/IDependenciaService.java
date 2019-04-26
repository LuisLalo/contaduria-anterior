package edu.uabc.app.service;

import java.util.List;

import edu.uabc.app.model.Dependencia;

public interface IDependenciaService {

	void insertar(Dependencia dependencia);
	List<Dependencia> buscarTodas();
	Dependencia buscarPorId(int idDependencia);
	void eliminar(int idDependencia);
}
