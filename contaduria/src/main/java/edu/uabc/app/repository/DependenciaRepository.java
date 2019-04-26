package edu.uabc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uabc.app.model.Dependencia;

@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

}
