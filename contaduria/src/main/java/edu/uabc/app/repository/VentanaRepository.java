package edu.uabc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uabc.app.model.Ventana;

@Repository
public interface VentanaRepository extends JpaRepository<Ventana, Integer> {

	// select * from ventana where id_nivel and orden
	List<Ventana> findByIdNivelOrderByOrden(int idNivel);
}
