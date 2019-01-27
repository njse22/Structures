package Queue;


public class NodeQueue<T>{

	private NodeQueue<T> last;
	private NodeQueue<T> next; 
	private T value; 
	
	public NodeQueue(T value) {
		super();
		this.last = null;
		this.next = null;
		this.value = value; 
		
	}

	public NodeQueue<T> getLast() {
		return last;
	}

	public void setLast(NodeQueue<T> last) {
		this.last = last;
	}
	
	public NodeQueue<T> getNext() {
		return next;
	}

	public void setNext(NodeQueue<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	
	
	
	
	
}
