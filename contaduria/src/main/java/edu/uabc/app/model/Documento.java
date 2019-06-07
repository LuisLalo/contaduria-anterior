package edu.uabc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="documento")
public class Documento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_documento")
	private int idDocumento;
	private String nombre;
	private String liga;
	@Column(name="id_ventana")
	private int idVentana;
	private int orden;
	@Column(name="id_tipo_documento")
	private int idTipoDocumento;
	
	public Documento() {
		
	}

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLiga() {
		return liga;
	}

	public void setLiga(String liga) {
		this.liga = liga;
	}

	public int getIdVentana() {
		return idVentana;
	}

	public void setIdVentana(int idVentana) {
		this.idVentana = idVentana;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	@Override
	public String toString() {
		return "Documento [idDocumento=" + idDocumento + ", nombre=" + nombre + ", liga=" + liga + ", idVentana="
				+ idVentana + ", orden=" + orden + ", idTipoDocumento=" + idTipoDocumento + "]";
	}
}
