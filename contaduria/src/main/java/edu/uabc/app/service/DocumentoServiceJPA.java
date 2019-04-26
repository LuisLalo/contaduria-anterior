package edu.uabc.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uabc.app.model.Documento;
import edu.uabc.app.repository.DocumentoRepository;

@Service
public class DocumentoServiceJPA implements IDocumentoService{

	@Autowired
	private DocumentoRepository documentoRepo;
	
	@Override
	public void insertar(Documento documento) {
		documentoRepo.save(documento);
	}

	@Override
	public List<Documento> buscarTodas() {
		List<Documento> lista = documentoRepo.findAll();
		return lista;
	}

	@Override
	public Documento buscarPorId(int idDocumento) {
		Optional<Documento> optional = documentoRepo.findById(idDocumento);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int idDocumento) {
		documentoRepo.deleteById(idDocumento);
	}

	@Override
	public List<Documento> buscarPorIdVentanaOrdenPorOrden(int idVentana) {
		List<Documento> lista = documentoRepo.findByIdVentanaOrderByOrden(idVentana);
		return lista;
	}

}
