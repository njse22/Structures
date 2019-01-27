package Queue;

public class Interfaz {
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<Integer>(); 
		
		System.out.println("¿está vacia? " + queue.isEmpty());
		System.out.println("tamaño de la cola " + queue.getSize());
		
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(7);
		System.out.println("tamaño de la cola "+ queue.getSize());
		
		System.out.println("en frente de la cola " +queue.getFront().getValue());
		
		queue.deQueue();
		
		System.out.println("ahora en fente de la cola " + queue.getFront().getValue());
		
		System.out.println("¿está vacia? " + queue.isEmpty());
		System.out.println("tamaño de la cola " + queue.getSize());
		
	}

}
