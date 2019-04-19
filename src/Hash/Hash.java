package Hash;

public class Hash<K ,V extends Comparable<V>> implements IHash<K, V> {

public static final int INITIAL_SIZE = 15;

	private HashNode<K, V>[] list;
 
	private int size; 
 
	
	@SuppressWarnings("unchecked")
	public Hash() {
		this.size = 0;
		list = new HashNode[INITIAL_SIZE];
		
	}
		
	@Override
	public void put(K key, V value) {
		
		int index = hashFuntion(key);
		HashNode<K, V> nodeAdd = new HashNode<K, V>(key, value);

		if(list[index]!= null) {
			list[index].add(nodeAdd);
			
		}else {
			list[index] = nodeAdd;
			size++;
		}
		
		
	}

	@Override
	public void remove(K key) throws HashIsEmptyException, NonexistentKeyException {
		
		int index = hashFuntion(key);
		
		if(isEmpty() == true) {
			throw new HashIsEmptyException("");
		}else {
			if(list[index] == null) {
				throw new NonexistentKeyException("");
			}else {
				if(list[index].getNext() == null) {
					list[index] = null;
					size--; 
				}else {
					list[index].romoveLast(); 
				}
			}
		}
			
	}
	
	public HashNode<K, V> getObjet(K key, V value) throws NonexistentKeyException{
		
		int index = hashFuntion(key);
		
		if(list[index]== null) {
			throw new NonexistentKeyException("the object whit the key: "+ key + " non Exist" );
		}else if(list[index].getNext() == null && list[index].getValue().compareTo(value) == 0) {
			return list[index];
		}else if(list[index].getNext() != null && list[index].getValue().compareTo(value) == 0) {
			return list[index];
		}
		else {
			return list[index].getObjet(value);
		}
		
	}

	@Override
	public V get(K key) {
		int index = hashFuntion(key); 
		return list[index].getValue(); 

	}
	
	@Override
	public int getSize() {
		return size;
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
		
	}

	public int hashFuntion(K key) {
		int index = key.hashCode();

		if(index >  INITIAL_SIZE) {
			index = key.hashCode()%INITIAL_SIZE;
		}else if (index < 1 ) {
			index = key.hashCode()*INITIAL_SIZE;
		}
		
		return index + 1;
	}
	
	
	
	
}
