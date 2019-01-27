package Stack;


public class NodeStack<T> {

	private NodeStack<T> last;
	private NodeStack<T> next; 
	private T value; 
	
	public NodeStack(T value) {
		super();
		this.last = null;
		this.next = null;
		this.value = value; 
		
	}

	public NodeStack<T> getLast() {
		return last;
	}

	public void setLast(NodeStack<T> last) {
		this.last = last;
	}
	
	public NodeStack<T> getNext() {
		return next;
	}

	public void setNext(NodeStack<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	
	
	
	
	
}
