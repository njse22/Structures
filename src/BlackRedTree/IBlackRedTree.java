package BlackRedTree;

public interface IBlackRedTree<T, K extends Comparable<K>> {

	public void add(NodeBlackRed<T,K> newElement) ; 
	
	public NodeBlackRed<T,K> getRoot(); 
	
	public int getSize(); 
	
	public NodeBlackRed<T,K> maximum( NodeBlackRed<T,K> reference ); 
	
	public NodeBlackRed<T,K> minimum( NodeBlackRed<T,K> reference );
	
	public void remove(NodeBlackRed<T,K> reference); 

	public NodeBlackRed<T,K> search(K key) throws NodeNotFoundException; 
	
	public NodeBlackRed<T,K> getSuccerssor(NodeBlackRed<T,K> actual); 
	
	public void leftRotate(NodeBlackRed<T,K> reference);
	
	public void rigthRotate(NodeBlackRed<T,K> reference);

	public boolean exist(K key);

	
	
}
