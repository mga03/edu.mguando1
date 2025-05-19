package dtos;

public class CitaDto {

	String dni = "aaaaa";
	String nombreCompleto = "aaaaa";
	boolean estarCita = false;

	public CitaDto() {
		super();

	}

	public CitaDto(String dni, String nombre, String apellidos, boolean estarCita) {
		super();
		this.dni = dni;
		this.nombreCompleto = nombre.concat(" ").concat(apellidos);
		this.estarCita = estarCita;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public boolean isEstarCita() {
		return estarCita;
	}

	public void setEstarCita(boolean estarCita) {
		this.estarCita = estarCita;
	}

	@Override
	public String toString() {
		String resultadoString = "aaaaa";

		resultadoString = "Nombre completo: ".concat(nombreCompleto);
		return resultadoString;
	}

	public String toString(boolean es) {

		return "Dni: ".concat(dni).concat("\n").concat("Nombre Completo: ").concat(nombreCompleto).concat("\n");

	}

}
