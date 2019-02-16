package EjemploFila;

public class Persona {
	
	private String nombre; 
	private String cedula; 
	private int edad; 
	private String historialMedico;
	

	public Persona() {
		super();
		this.nombre = "";
		this.cedula = "";
		this.edad = 0;
		this.historialMedico = "";
	} 
	
	
	public Persona(String nombre, String cedula, int edad, String historialMedico) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.edad = edad;
		this.historialMedico = historialMedico;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getHistorialMedico() {
		return historialMedico;
	}


	public void setHistorialMedico(String historialMedico) {
		this.historialMedico = historialMedico;
	} 
	
	
	
	

}
