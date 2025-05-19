package servicios;

import controladores.Inicio;

public class SubMenuEmpleado implements MenuInterfaz {
	@Override
	public int mostrarMenuYseleccionar() {
		System.out.println("1-Validar cliente");
		System.out.println("2-Borrar cliente");
		System.out.println("3-mostrar cliente");
		System.out.println("4-volver al menu inicial");
		int OpcionUsuario = Inicio.sc.nextInt();
		return OpcionUsuario;

	}

	public void subMenuEstructura() {
		boolean esCerrado = false;
		int OpcionUsuario = 0;

		do {

			OpcionUsuario = mostrarMenuYseleccionar();

			switch (OpcionUsuario) {
			case 1: {
				EmpleadoImplementacion empleadoImplementacion = new EmpleadoImplementacion();
				empleadoImplementacion.validarCliente();
				break;
			}
			case 2: {

				System.out.println("DNI del Cliente a borrar: ");

				break;
			}
			case 3: {

				System.out.println("todos los clientes: ");
				break;
			}
			case 4: {

				System.out.println("-----se ha vuelto al menu inicial-----");
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
