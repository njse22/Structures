package Stack;

public interface IStack<T  > {
	
	
	public void push(T newElement); 
	
	public void pop(); 
	
	public boolean isEmpty();
	
	public NodeStack<T> topElement(); 
	
	public int getSize(); 

}
