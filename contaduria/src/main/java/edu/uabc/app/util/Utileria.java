package edu.uabc.app.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import edu.uabc.app.model.Ventana;

public class Utileria {

	public static String guardarDocumento(MultipartFile multiPart, HttpServletRequest request, String extension, String ventana) {
		
		// Se obtiene el nombre del archivo
		String nombreArchivo = multiPart.getOriginalFilename();
		
		// Se eliminan los espacios del nombre del archivo
		nombreArchivo = nombreArchivo.replaceAll(" ", "-");
		
		String liga = null;
		
		return "";
	}
	
	//Método para obtener el nombre de la ventana
	public static String obtenerVentana(int idVentana, List<Ventana> listaVentana) {
		int contador = 0;
		String liga = "";
		
		while(contador<listaVentana.size()) {
			Ventana ventana = listaVentana.get(contador);
			int id = ventana.getIdVentana();
			if(idVentana == id) {
				liga = ventana.getLiga();
			}
		}
		
		return liga;
	}
}
