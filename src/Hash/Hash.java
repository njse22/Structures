package Hash;

import java.util.ArrayList;

public class Hash<K ,V> implements IHash<K, V> {

	private ArrayList<HashNode<K, V>> list ; 
	private int initialSize; 
	private int size; 
	
	public Hash() {
		this.initialSize = 10; 
		this.list = new ArrayList<>(initialSize);
		this.size = 0; 
	}
		
	@Override
	public void put(K key, V value) {
		
		HashNode<K, V> hash = new HashNode<K,V>(key, value); 
		HashNode<K, V> actual = validar(hash);
		if(  actual != null  /*existColition(key)*/) {
			
			actual.setNext(hash);
			hash.setPrevius(actual);
			
		}else {
			list.add( hash ) ; 
			size++; 
			
		}
		
	}

	@Override
	public void remove(K key) throws HashIsEmptyException, NonexistentKeyException {
		if(size == 0) {
			throw new HashIsEmptyException("the hash is empty, you can't remove elements");
		}else {
			int control = size; 
			
			for (int i = 0; i < list.size(); i++) {
				HashNode<K, V> temp = list.get(i);
				
				if(list.get(i).getKey() == key) {
					if(validar(temp) != null) {
						list.remove(temp);

						list.add(i, temp.getNext());

						temp.getNext().setPrevius(null);
						list.remove(temp); 
						
					}else {
						list.remove(temp);
					}
					
					size--;
				}
			}
			
			if(control == size) {
				throw new NonexistentKeyException("nonexistent this key, you can't remove this element ");
			}
				
		}

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
		int index = 0;
		
		if(key.hashCode() >  list.size()) {
			index = key.hashCode()%list.size();
		}else if (key.hashCode() < 1 ) {
			index = key.hashCode()* list.size();
		}else {
			index = key.hashCode();
		}
		
		return index;
	}
	
	
	
//	private boolean existColition(K key) {
//		
//		boolean existColition = false; 
//		for (int i = 0; i < 1; i++) {
//
//			if(list.get(i).getKey().equals(key)) {
//				existColition = true;
//				
//			} 
//		}
//		
//		return existColition; 
//	}
	
	
}
