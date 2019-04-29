package edu.uabc.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uabc.app.model.TipoDocumento;
import edu.uabc.app.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoServiceJPA implements ITipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepo;

	@Override
	public void insertar(TipoDocumento tipoDocumento) {
		tipoDocumentoRepo.save(tipoDocumento);
	}

	@Override
	public List<TipoDocumento> buscarTodas() {
		List<TipoDocumento> lista = tipoDocumentoRepo.findAll();
		return lista;
	}
	
	@Override
	public TipoDocumento buscarPorId(int idTipoDocumento) {
		Optional<TipoDocumento> optional = tipoDocumentoRepo.findById(idTipoDocumento);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int idTipoDocumento) {
		tipoDocumentoRepo.deleteById(idTipoDocumento);
	}

}
