package EjemploFila;

import Queue.IQueue;
import Queue.Queue;

public class FilaSisben {

	/*make a instance of interface IQueue*/
	private IQueue<Persona> personas;

	
	public FilaSisben() {
		/*create the object Queue<Persona>*/
		personas = new Queue<Persona>(); 
		
	} 
	
	public IQueue<Persona> getFila(){
		return personas; 
	}
	
	
	public static void main(String[] args) {
		/*use the methods of Queue<Persona> a journey of interface IQueue*/
		
		FilaSisben fila = new FilaSisben(); 
		
		System.out.println(fila.getFila().getSize());
		fila.getFila().enQueue(new Persona("mateo", "12345", 19, ""));
		System.out.println(fila.getFila().getSize());
		
		
	}
	
	
}
