package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.CitaDto;
import dtos.ClienteDto;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperativaDeFicheros;
import servicios.SubMenuEmpleado;
import servicios.SubMenuCliente;

/**
 * Clase controladora de la aplicación 190525
 * 
 * @author mguando
 */
public class Inicio {
	/**
	 * Puerta de entrada a la aplicacion 190525
	 * 
	 * @param args parámetro de configuración
	 */

	public static final String RUTA = "citas.txt";
	public static final String RUTA_LOG = "logs.txt";
	public static ArrayList<CitaDto> citas = new ArrayList<CitaDto>();
	public static long ultimoId = 1;
	public static List<ClienteDto> lista = new ArrayList<ClienteDto>();
	public static Scanner sc = new Scanner(System.in);
	public static MenuInterfaz menuInterfaz = new MenuImplementacion();
	public static SubMenuEmpleado subMenu1 = new SubMenuEmpleado();
	public static SubMenuCliente subMenu2 = new SubMenuCliente();

	public static void main(String[] args) {

		boolean esCerrado = false;

		int OpcionUsuario;

		do {
			OpcionUsuario = menuInterfaz.mostrarMenuYseleccionar();

			switch (OpcionUsuario) {
			case 1: {
				System.out.println(" 1-Version empleado");
				subMenu1.subMenuEstructura();
				break;
			}
			case 2: {

				System.out.println("2-version cliente");
				subMenu2.subMenuCliente();

				break;
			}
			case 3: {

				System.out.println("3-cerrar aplicacion");
				esCerrado = true;
				break;
			}

			default:
				System.out.println("la opcion seleccionada no existe");
				break;
			}
		} while (!esCerrado);

	}

	public void pruebaFicheros() {
		OperativaDeFicheros ficheros = new OperativaDeFicheros();

		try {
			ficheros.cargaInicial();
		} catch (Exception e) {
			System.out.println("Error: ".concat(e.getMessage()));
		}
		try {
			ficheros.altaCita();
		} catch (Exception e) {
			System.out.println("Error en el alta: ".concat(e.getMessage()));
		}
		for (CitaDto cita : citas) {
			System.out.println(cita.toString(true));
		}

	}

}
