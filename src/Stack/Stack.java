package Stack;

public class Stack<T> implements IStack<T>{

	private NodeStack<T> top;
	private int size;
	
	public Stack() {
		super();
		this.top  = null;
		this.size = 0;
		
	}

	
	public void setTop(NodeStack<T> top) {
		this.top = top;
	}

	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public void push(T newElement) {
		NodeStack<T> n = new NodeStack<T>(newElement); 
		
		if(size == 0) {
			top = n; 
			size++; 
		}
		else {
			top.setNext(n);
			top.getNext().setLast(top);
			this.top = n; 
			size++; 
		}
		
		
	}
	
	@Override
	public void pop() {
		if(size == 0) {
			new StackIsEmptyException("Stcak is Empty");
		}
		else if(size == 1) {
			top = null; 
			size--; 
		}
		else {
			NodeStack<T> temp = top; 
			this.top = temp.getLast();
			temp.setLast(null);
			this.top.setNext(null);
			size--; 
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else 
			return false; 
	}

	@Override
	public NodeStack<T> topElement() {
		return this.top;
		
	}


	
	
	
	
}
