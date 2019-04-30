package edu.uabc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uabc.app.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

	// select * from documento where idVentana ordey by orden
	List<Documento> findByIdVentanaOrderByOrden(int idVentana);
	
	// select * from documento where nombre
	List<Documento> findByNombre(String nombre);
}
