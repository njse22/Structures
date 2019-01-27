package Trees;

public interface ITree <T extends Comparable<T>> {

	public NodeABB<?> search(T value) throws NodeNotFoundException;
	
	public NodeABB<T> maximum(NodeABB<T> reference);
	
	public NodeABB<T> successor(NodeABB<T> reference);
	
	public boolean exist(T value);

	public void add(T Value);

	public void remove(NodeABB<T> delete);

	public NodeABB<T> minimum(NodeABB<T> reference);
	
 	
	
	
}
