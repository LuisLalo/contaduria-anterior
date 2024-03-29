package edu.uabc.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventana")
public class Ventana {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ventana")
	private int idVentana;
	private String nombre;
	private String liga;
	@Column(name="id_nivel")
	private int idNivel;
	private String estatus;
	@Column(name="orden")
	private int orden;
	@Column(name="id_referencia")
	private int idReferencia;
	private String descripcion;
	private String responsable;
	private String correo;
	private String extension;
	
	public Ventana() {
		
	}

	public int getIdVentana() {
		return idVentana;
	}

	public void setIdVentana(int idVentana) {
		this.idVentana = idVentana;
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

	public int getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getIdReferencia() {
		return idReferencia;
	}

	public void setIdReferencia(int idReferencia) {
		this.idReferencia = idReferencia;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "Ventana [idVentana=" + idVentana + ", nombre=" + nombre + ", liga=" + liga + ", idNivel=" + idNivel
				+ ", estatus=" + estatus + ", orden=" + orden + ", idReferencia=" + idReferencia + ", descripcion="
				+ descripcion + ", responsable=" + responsable + ", correo=" + correo + ", extension=" + extension
				+ "]";
	}
}
