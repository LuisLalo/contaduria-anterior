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
	
	// Método que se utiliza para actualizar el consecutivo en el orden de los documentos
	@Override
	public void actualizarOrdenNuevo(int orden, List<Documento> listaDocumento) {
		
		//se recorre la lista visualizando cada documento
		for(Documento doc : listaDocumento) {
			
			System.out.println("documento " + doc.getOrden() + " orden " + orden);
			if(doc.getOrden() == orden) {
				
				int nuevoOrden = doc.getOrden();
				nuevoOrden++;
						
				int idDocumento = doc.getIdDocumento();
				Documento documento = buscarPorId(idDocumento);
				System.out.println("documento que se va actualizar " + documento);
				documento.setOrden(nuevoOrden);
				
				System.out.println("documento con nuevo orden en modelo " + documento);
				documentoRepo.save(documento);
				
				orden++;
				}
		}
	}
}