package servicios;

import controladores.Inicio;
import dtos.ClienteDto;

public class ClienteImplementacion implements ClienteInterfaz {
	public static String[] letras = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S",
			"Q", "V", "H", "L", "C", "K", "E" };

	@Override
	public void nuevoCliente() {
		ClienteDto nuevoCliente = new ClienteDto();

		System.out.println("Dame su DNI");
		nuevoCliente.setDni(Inicio.sc.next());

		if (!validarDni(nuevoCliente)) {
			System.out.println("El DNI es inválido. No se ha registrado el cliente.");
			return;
		}

		// Nombre y apellidos del cliente
		System.out.println("Dime tu nombre completo");
		Inicio.sc.nextLine();
		String nombreCompleto = Inicio.sc.nextLine();
		String[] partesDelNombre = nombreCompleto.split(" ");
		nuevoCliente.setNombre(partesDelNombre[0]);
		nuevoCliente.setApellido1(partesDelNombre[1]);
		if (partesDelNombre.length == 3) {
			nuevoCliente.setApellido2(partesDelNombre[2]);
		}

		// Id del cliente
		nuevoCliente.setId(calcularId());
		nuevoCliente.setEsValidado(false);

		Inicio.lista.add(nuevoCliente);
		System.out.println("Cliente registrado correctamente.");
	}

	private long calcularId() {
		return Inicio.ultimoId++;
	}

	private boolean validarDni(ClienteDto cliente) {
		try {
			String dni = cliente.getDni().trim(); // Asegurarse de que no haya espacios
			if (dni.length() != 9) { // Validar que el DNI tenga el formato correcto
				return false;
			}

			String dniSinLetra = dni.substring(0, 8);
			int numDni = Integer.parseInt(dniSinLetra);
			String letraComprobada = letras[numDni % 23];

			if (letraComprobada.equalsIgnoreCase(dni.substring(8))) { // Comparar correctamente con equalsIgnoreCase
				System.out.println("El DNI es válido");
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException | StringIndexOutOfBoundsException e) {
			return false; // Devuelve falso si ocurre un error con el formato del DNI
		}
	}

	public void accederCliente() {
		boolean condicion = false;

		ClienteDto clienteDto = new ClienteDto();
		System.out.println("Dime su email");
		clienteDto.setEmail(Inicio.sc.next());
		System.out.println("Dime su contraseña");
		clienteDto.setContrasenia(Inicio.sc.next());

		if (!condicion) {
			clienteDto.getEmail();
			clienteDto.getContrasenia();
			System.out.println("enhorabuena esta correcto");

		} else {
			clienteDto.getEmail();
			clienteDto.getContrasenia();
			System.out.println("esta incorrecto prueba de nuevo");
		}

	}

	public static ClienteDto[] lista() {
		// TODO Auto-generated method stub
		return null;
	}

}
