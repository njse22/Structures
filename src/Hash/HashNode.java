package Hash;

public class HashNode<K,V> {

	private K key; 
	private V value; 
	
	private HashNode<K,V> next;
	private HashNode<K,V> previus; 
	
	public HashNode(K key, V value) {
		
		this.key = key;
		this.value = value;
		next = null; 
		previus = null; 
		
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public HashNode<K, V> getNext() {
		return next;
	}

	public void setNext(HashNode<K, V> next) {
		this.next = next;
	}
	

	public HashNode<K, V> getPrevius() {
		return previus;
	}

	public void setPrevius(HashNode<K, V> previus) {
		this.previus = previus;
	}

		
	
	
}
