package servicios;

import java.util.ArrayList;
import controladores.Inicio;
import dtos.ClienteDto;

public class EmpleadoImplementacion implements EmpleadoInterfaz {

	ArrayList<ClienteDto> listaClientes = new ArrayList<>();

	@Override
	public void validarCliente() {
		System.out.println("Clientes no validados");

		for (ClienteDto cliente : Inicio.lista) {
			if (!cliente.isEsValidado()) {
				System.out.println("DNI: " + cliente.getDni());
				System.out.println("NOMBRE: " + cliente.getNombre());
				System.out.println("APELLIDOS: " + cliente.getApellido1() + cliente.getApellido2());
				System.out.println("ESTADO VALIDACIÓN: No");
			}
		}
		System.out.println("Ingrese el DNI del cliente que quiere validar");
		String dniIngresado = Inicio.sc.nextLine().trim();

		boolean encontrado = false;

		for (ClienteDto cliente : Inicio.lista) {

			if (cliente.getDni().equalsIgnoreCase(dniIngresado)) {
				cliente.setEsValidado(true);
				encontrado = true;
				System.out.println("Cliente Validado correctamente");
				break;
			}
		}
		if (!encontrado) {
			System.out.println("DNI no encontrado");
		}
	}

}
