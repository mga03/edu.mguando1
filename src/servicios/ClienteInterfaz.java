package servicios;

/**
 * Clase que se encarga de gestinar la operativa y funcionalidad interna de mi
 * aplicación
 * 
 * @author mguando 19-05-2025
 */
public interface ClienteInterfaz {
	
	 /**
     * Método que se encarga de realizar todo el proceso de guardar al cliente nuevo 
     * mguando - 19-05-2025
     */
	
	public void nuevoCliente();

	 /**
     * Método que se encarga de poder acceder a los datos añadidos del cliente a través de email y contraseña
     * mguando - 19-05-2025
     */
	
	public void accederCliente();
}
