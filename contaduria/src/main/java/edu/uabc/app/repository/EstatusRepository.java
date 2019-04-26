package edu.uabc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uabc.app.model.Estatus;

@Repository
public interface EstatusRepository extends JpaRepository<Estatus, Integer> {

}
