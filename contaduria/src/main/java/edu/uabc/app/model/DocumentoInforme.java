package edu.uabc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="documento_informe")
public class DocumentoInforme {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_informe")
	private int idInforme;
	private String categoria;
	private String mes;
	private String anio;
	
	public DocumentoInforme() {
		
	}

	public int getIdInforme() {
		return idInforme;
	}

	public void setIdInforme(int idInforme) {
		this.idInforme = idInforme;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "DocumentoInforme [idInforme=" + idInforme + ", categoria=" + categoria + ", mes=" + mes + ", anio="
				+ anio + "]";
	}
}
