package ExampleQueue;

import Queue.IQueue;
import Queue.Queue;

public class QueueSisben {

	/*make a instance of interface IQueue*/
	private IQueue<People> persons;

	
	public QueueSisben() {
		/*create the object Queue<Persona>*/
		persons = new Queue<People>(); 
		
	} 
	
	public IQueue<People> getFila(){
		return persons; 
	}
	
	
	public static void main(String[] args) {
		/*use the methods of Queue<Persona> a journey of interface IQueue*/
		
		QueueSisben queue = new QueueSisben(); 
		
		System.out.println(queue.getFila().getSize());
		queue.getFila().enQueue(new People("mateo", "12345", 19, ""));
		System.out.println(queue.getFila().getSize());
		
		
	}
	
	
}
