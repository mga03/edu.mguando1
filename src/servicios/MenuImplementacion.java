package servicios;

import controladores.Inicio;

public class MenuImplementacion implements MenuInterfaz {

	public int mostrarMenuYseleccionar() {

		System.out.println("1-Version empleado");
		System.out.println("2-Version cliente");
		System.out.println("3-cerrar aplicacion");
		int OpcionUsuario = Inicio.sc.nextInt();
		return OpcionUsuario;

	}

}
