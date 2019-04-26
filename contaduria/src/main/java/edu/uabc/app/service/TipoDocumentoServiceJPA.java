package edu.uabc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uabc.app.model.TipoDocumento;
import edu.uabc.app.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoServiceJPA implements ITipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepo;
	
	@Override
	public List<TipoDocumento> buscarTodas() {
		List<TipoDocumento> lista = tipoDocumentoRepo.findAll();
		return lista;
	}

}
