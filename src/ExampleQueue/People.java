package ExampleQueue;

public class People {
	
	private String name; 
	private String identification; 
	private int age; 
	private String medicalHistory;
	

	public People() {
		super();
		this.name = "";
		this.identification = "";
		this.age = 0;
		this.medicalHistory = "";
	} 
	
	
	public People(String nombre, String cedula, int edad, String historialMedico) {
		super();
		this.name = nombre;
		this.identification = cedula;
		this.age = edad;
		this.medicalHistory = historialMedico;
	}


	public String getNombre() {
		return name;
	}


	public void setNombre(String nombre) {
		this.name = nombre;
	}


	public String getCedula() {
		return identification;
	}


	public void setCedula(String cedula) {
		this.identification = cedula;
	}


	public int getEdad() {
		return age;
	}


	public void setEdad(int edad) {
		this.age = edad;
	}


	public String getHistorialMedico() {
		return medicalHistory;
	}


	public void setHistorialMedico(String historialMedico) {
		this.medicalHistory = historialMedico;
	} 
	
	
	
	

}
