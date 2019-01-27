package Queue;

public class Queue <T> implements IQueue<T> {

	private NodeQueue<T> front;
	private NodeQueue<T> apunter; 

	private int size;
	
	public Queue() {	
		this.front = null;
		this.size = 0;
		
	}

	@Override
	public void enQueue(T newElement) {
		NodeQueue<T> n = new NodeQueue<T>(newElement); 
		if(size == 0) {
			front = n;
			apunter = front;
			size++;
		}
		else {
			apunter.setLast(n);
			apunter = apunter.getLast(); 
			size++; 
			
		}
		
	}

	@Override
	public void deQueue() {
		if(size == 0) {
			new QueueIsEmptyException("Queue is Empty");
		}
		else if(size == 1) {
			front = null; 
			size--;
		}
		else {
			NodeQueue<T> temp = front.getLast();
			temp.setNext(null);
			front.setLast(null);
			front = temp; 
			size--;
			
		}
		
	}

	@Override
	public NodeQueue<T> getFront() {
		return this.front;
		
	}

	@Override
	public int getSize() {
		return this.size;
		
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false; 
		
	} 
	
	
	
	
	
	
}
