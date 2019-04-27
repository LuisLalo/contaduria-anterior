package edu.uabc.app.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import edu.uabc.app.model.TipoDocumento;
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
	
	// Método para generar una cadena de longitud N de caracteres aleatorios
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}
		
	// Método para generar la fecha actual
	public static Date generarFecha() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		Calendar calendar = Calendar.getInstance();
		Date current = Calendar.getInstance().getTime();
		System.out.println("Prueba uno: " + dateFormat.format(calendar.getTime()));
		System.out.println("Prueba dos: " + current);
		return current;
	}
		
	// Método para obtener el nombre de la ventana
	public static String obtenerVentana(int idVentana, List<Ventana> listaVentana) {
		int contador = 0;
		String liga = "";
		
		while(contador<listaVentana.size()) {
			Ventana ventana = listaVentana.get(contador);
			int id = ventana.getIdVentana();
			if(idVentana == id) {
				liga = ventana.getLiga();
			}
			contador++;
		}
		return liga;
	}
	
	// Método para identificar y agregar las extensiones al nombre de los archivos
	public static String agregarExtensionArchivos(MultipartFile multiPart) {
		
		// Se obtiene el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();		
		nombreOriginal = nombreOriginal.replace(" ", "-");
		System.out.println(nombreOriginal);
		String extension = "";
		
		int contador = nombreOriginal.lastIndexOf(".");
		if(contador > 0) {
			int largoExtension = nombreOriginal.length();
			extension = nombreOriginal.substring(contador, largoExtension);
			extension.toLowerCase();
		}
		return extension;
	}
	
	// Método para identificar y eliminar las extensiones al nombre de los archivos
	public static String eliminarExtensionArchivos(MultipartFile multiPart) {
		// Se obtiene el nombre del archivo que aparece en ruta
		String ruta = "";
		return ruta;
	}
	
	// Método para identificar el tipo de archivo que se guardará en la base de datos
	public static int identificarExtensionArchivos(String extension, List<TipoDocumento> listaTipoDocumento) {
		int id_tipo_documento = 0;
		int contador = 0;
		extension = extension.toLowerCase();
		
		while(contador < listaTipoDocumento.size()) {
			TipoDocumento tipoDocumento = listaTipoDocumento.get(contador);
			String ruta = tipoDocumento.getDocumento();
			System.out.println("Ruta: " + ruta);
			System.out.println("Extension: " + extension);
			
			if(ruta.equals(extension)) {
				id_tipo_documento = tipoDocumento.getIdTipoDocumento();
				System.out.println("id_tipo_archivo: " + id_tipo_documento);
			}
			
			contador++;
		}
		
		System.out.println("id_tipo_archivo: " + id_tipo_documento);
		
		return id_tipo_documento;
	}
}