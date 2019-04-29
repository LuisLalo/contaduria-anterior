package edu.uabc.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uabc.app.model.Ventana;
import edu.uabc.app.repository.VentanaRepository;

@Service
public class VentanaServiceJPA implements IVentanaService {

	@Autowired
	private VentanaRepository ventanaRepo;
	
	@Override
	public void insertar(Ventana ventana) {
		ventanaRepo.save(ventana);		
	}

	@Override
	public List<Ventana> buscarTodas() {
		List<Ventana> lista = ventanaRepo.findAll();
		return lista;
	}

	@Override
	public Ventana buscarPorId(int idVentana) {
		Optional<Ventana> optional = ventanaRepo.findById(idVentana);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int idVentana) {
		ventanaRepo.deleteById(idVentana);
	}

	@Override
	public List<Ventana> buscarPorIdNivelOrdenPorOrden(int idNivel) {
		List<Ventana> lista = ventanaRepo.findByIdNivelOrderByOrden(idNivel);
		return lista;
	}
}
