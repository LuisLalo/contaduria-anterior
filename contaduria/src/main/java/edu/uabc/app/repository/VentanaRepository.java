package edu.uabc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uabc.app.model.Ventana;

@Repository
public interface VentanaRepository extends JpaRepository<Ventana, Integer> {

}
