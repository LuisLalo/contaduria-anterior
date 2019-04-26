package edu.uabc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uabc.app.model.Estatus;
import edu.uabc.app.repository.EstatusRepository;

@Service
public class EstatusServiceJPA implements IEstatusService {

	@Autowired
	private EstatusRepository estatusRepo;
	
	@Override
	public List<Estatus> buscarTodas() {
		List<Estatus> lista = estatusRepo.findAll();
		return lista;
	}

}
