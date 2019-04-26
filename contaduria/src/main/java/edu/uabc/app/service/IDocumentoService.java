package edu.uabc.app.service;

import java.util.List;

import edu.uabc.app.model.Documento;

public interface IDocumentoService {

	void insertar(Documento documento);
	List<Documento> buscarTodas();
	Documento buscarPorId(int idDocumento);
	void eliminar(int idDocumento);
	List<Documento> buscarPorIdVentanaOrdenPorOrden(int idVentana);
}
