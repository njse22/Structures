package Hash;

public class Hash<K ,V> implements IHash<K, V> {

public static final int INITIAL_SIZE = 18;
	
	private int size;
	
	private HashNode<K, V>[] list;
	
	@SuppressWarnings("unchecked")
	public Hash() {
		this.size = 0;
		list = new HashNode[INITIAL_SIZE];
		
	}
		
	@Override
	public void put(K key, V value) {
		
		int index = h(key);
		HashNode<K, V> nodeAdd = new HashNode<K, V>(key, value);

		if(list[index]!= null) {
			list[index].add(nodeAdd);
			size++;
		}else {
			list[index] = nodeAdd;
			size++;
		}
		
		
	}

	@Override
	public void remove(K key) throws HashIsEmptyException, NonexistentKeyException {
			
	}

	@Override
	public V get(K key) {
		for (HashNode<K, V> hashNode : list) {
			if (hashNode.getKey() == key) {
				return hashNode.getValue(); 
			}
			
		}
		
		return null;
		
	}

	public HashNode<K, V > getObject(K key){
		for (HashNode<K, V> hashNode : list) {
			if (hashNode.getKey() == key) {
				return hashNode; 
			}
			
		}
		
		return null;
		 
	}
	
	@Override
	public int getSize() {
		return size;
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
		
	}

	private HashNode<K, V> validar(HashNode<K, V> hash) {
		HashNode<K, V> temp = null; 
		for (HashNode<K, V> hashNode : list) {
			if(hashNode.getKey().equals(hash.getKey())) {
				temp = hashNode;  
				break;  
			}
		}
		
		return temp;  
	}
	
	public int h(K key) {
		int index = key.hashCode();

		if(index >  INITIAL_SIZE) {
			index = key.hashCode()%INITIAL_SIZE;
		}else if (index < 1 ) {
			index = key.hashCode()*INITIAL_SIZE;
		}
		
		return index + 1;
	}
	
	
}
