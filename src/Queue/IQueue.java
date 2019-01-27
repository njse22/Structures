package Queue;

public interface IQueue<T> {

	public void enQueue(T newElement);
	
	public void deQueue(); 
	
	public NodeQueue<T> getFront(); 
	
	public int getSize(); 
	
	public boolean isEmpty(); 
	
}
