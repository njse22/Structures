package AVLTree;

public interface IAVLTree <T, K extends Comparable<K>> {
	
	public void add(NodeAVL<T,K> newElement) ; 
	
	public NodeAVL<T,K> getRoot(); 
	
	public int getSize(); 
	
	public NodeAVL<T,K> maximum( NodeAVL<T,K> reference ); 
	
	public NodeAVL<T,K> minimum( NodeAVL<T,K> reference );
	
	public void remove(K key); 

	public NodeAVL<T,K> search(K key) throws NodeNotFoundException; 
	
	public NodeAVL<T,K> getSuccerssor(NodeAVL<T,K> actual); 
	
	public void leftRotate(NodeAVL<T,K> reference);
	
	public void rigthRotate(NodeAVL<T,K> reference);

	public boolean exist(K key);

	

}
