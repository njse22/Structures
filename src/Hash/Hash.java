package Hash;

import java.util.ArrayList;

public class Hash<K ,V> implements IHash<K, V> {

public static final int INITIAL_SIZE = 18;
	
	private ArrayList<HashNode<K, V>> list ; 
	private int size; 
	
	public Hash() {
		this.list = new ArrayList<>();
		initLis();
		this.size = 0;
	}
		
	@Override
	public void put(K key, V value) {
		
		int index = h(key);
		HashNode<K, V> nodeAdd = new HashNode<K, V>(key, value);
//		System.out.println(index);
		if(list.get(index) != null) {
			list.get(index).add(nodeAdd);
			size++;
		}else {
			list.add(index,nodeAdd);
			size++;
		}
		
		
//		
//		
//		HashNode<K, V> hash = new HashNode<K,V>(key, value); 
//		HashNode<K, V> actual = validar(hash);
//		if(  actual != null  /*existColition(key)*/) {
//			
//			actual.setNext(hash);
//			hash.setPrevius(actual);
//			
//		}else {
//			list.add( hash ) ; 
//			size++; 
//			
//		}
		
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
		int index = key.hashCode();
//		System.out.println(index);
		if(index >  INITIAL_SIZE) {
			index = key.hashCode()%list.size();
		}else if (index < 1 ) {
			index = key.hashCode()* list.size();
		}
		
		return index + 1;
	}
	
	public void initLis() {
		for (int i = 0; i < INITIAL_SIZE; i++) {
			list.add(null);
		}
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
