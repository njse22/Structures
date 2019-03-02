package Hash;

public interface IHash<K, V> {

	public void put(K key, V value); 
	
	public void remove(K key) throws HashIsEmptyException, NonexistentKeyException;
	
	public V get(K key); 
	
	public int getSize();
	
	public boolean isEmpty(); 
	
//	public void hashFuntion(); 
}
