package servicios;

import controladores.Inicio;

public class SubMenuCliente implements MenuInterfaz {

	@Override
	public int mostrarMenuYseleccionar() {
		System.out.println("1-registro cliente");
		System.out.println("2-acceso cliente");
		System.out.println("3-volver al menu inicial");
		int OpcionUsuario = Inicio.sc.nextInt();
		return OpcionUsuario;
	}

	public void subMenuCliente() {
		boolean esCerrado = false;
		int OpcionUsuario = 0;

		do {

			OpcionUsuario = mostrarMenuYseleccionar();

			switch (OpcionUsuario) {
			case 1: {
				ClienteInterfaz clienteImplementacion = new ClienteImplementacion();
				clienteImplementacion.nuevoCliente();
				break;
			}
			case 2: {
				ClienteInterfaz clienteImplementacion = new ClienteImplementacion();
				clienteImplementacion.accederCliente();
				System.out.println("accediendo a los clientes... ");

				break;
			}
			case 3: {

				System.out.println("-----se ha vuelto  al menu inicial-----");
				esCerrado = true;
				break;
			}
			default:
				System.out.println("la opcion seleccionada no existe");
				break;
			}
		} while (!esCerrado);
	}
}
