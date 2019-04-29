package edu.uabc.app.service;

import java.util.List;

import edu.uabc.app.model.TipoDocumento;

public interface ITipoDocumentoService {

	void insertar(TipoDocumento tipoDocumento);
	List<TipoDocumento> buscarTodas();
	TipoDocumento buscarPorId(int idTipoDocumento);
	void eliminar(int idTipoDocumento);
}