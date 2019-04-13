package balancedTrees;


public interface BalancedTree <T extends Comparable<T>>{
	
	public void add(NodeABB<T> newElement) ; 
	
	public NodeABB<T> getRoot(); 
	
	public int getSize(); 
	
	public NodeABB<T> maximum( NodeABB<T> reference ); 
	
	public NodeABB<T> minimum( NodeABB<T> reference );
	
	public void remove(NodeABB<T> reference); 

	public NodeABB<T> search(T value) throws NodeNotFoundException; 
	
	public NodeABB<T> getSuccerssor(NodeABB<T> actual); 
	
	public void leftRotate(NodeABB<T> reference);
	
	public void rigthRotate(NodeABB<T> reference);

	public boolean exist(T value);

	
	
	
}
