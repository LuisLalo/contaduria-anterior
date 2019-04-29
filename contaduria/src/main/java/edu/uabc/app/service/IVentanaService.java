package edu.uabc.app.service;

import java.util.List;

import edu.uabc.app.model.Ventana;

public interface IVentanaService {

	void insertar(Ventana ventana);
	List<Ventana> buscarTodas();
	Ventana buscarPorId(int idVentana);
	void eliminar(int idVentana);
	List<Ventana> buscarPorIdNivelOrdenPorOrden(int idNivel);
}
