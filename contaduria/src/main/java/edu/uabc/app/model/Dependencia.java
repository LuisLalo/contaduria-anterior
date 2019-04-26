package edu.uabc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dependencia")
public class Dependencia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dependencia")
	private int idDependencia;
	private String campus;
	private String dependencia;
	
	public Dependencia() {
		
	}

	public int getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(int idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	@Override
	public String toString() {
		return "Dependencia [idDependencia=" + idDependencia + ", campus=" + campus + ", dependencia=" + dependencia
				+ "]";
	}
}
