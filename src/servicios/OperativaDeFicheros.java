package servicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import controladores.Inicio;
import dtos.CitaDto;

public class OperativaDeFicheros {

	public void altaCita() throws Exception {
		registroLog("[INFO] - Método alta nueva cita.");
		CitaDto nuevaCita = new CitaDto();
		System.out.println("DNI: ");
		nuevaCita.setDni(Inicio.sc.next());
		System.out.println("Nombre completo: ");
		Inicio.sc.nextLine();
		nuevaCita.setNombreCompleto(Inicio.sc.nextLine());

		System.out.println(nuevaCita.toString());
		Inicio.citas.add(nuevaCita);
		registroLog("[INFO] - " + nuevaCita.toString(true));
	}

	public void registroLog(String mensaje) {
		Path ruta = Paths.get(Inicio.RUTA_LOG);
		int numeroLineas = 0;
		try {
			numeroLineas = Files.readAllLines(ruta).size();
			if (numeroLineas > 0) {
				Files.write(ruta, mensaje.getBytes(), StandardOpenOption.APPEND);
			} else {
				Files.write(ruta, mensaje.getBytes());
			}
		} catch (IOException e) {

		}
	}

	public boolean cargaInicial() {
		boolean estaLeido = false;
		Path ruta = Paths.get(Inicio.RUTA);
		byte n = 0;
		try {
			registroLog("[INFO] - Método de carga inicial.");
			List<String> lineas = Files.readAllLines(ruta);
			for (String linea : lineas) {
				if (n == 0) {
					n = 1;
					continue;
				}
				String[] datos = linea.split(";");
				String dni = datos[0];
				String nombre = datos[1];
				String apellidos = datos[2];

				boolean asistenciaCita = Boolean.parseBoolean(datos[3]);

				CitaDto cita = new CitaDto(dni, nombre, apellidos, asistenciaCita);
				Inicio.citas.add(cita);
				estaLeido = true;

			}
		} catch (IOException e) {
			registroLog("[ERROR - cargaInicial] Ha ocurrido un error en la carga inicial: " + e);
			estaLeido = false;
		}

		if (estaLeido) {
			System.out.println("Carga inicial correcta");
		}

		return estaLeido;
	}

}
