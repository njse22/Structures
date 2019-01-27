package Hash;

import java.util.ArrayList;

public class Hash<K,V> implements IHash<K, V> {

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
		list.add(new HashNode<K,V>(key, value) ) ; 
		size++; 
		
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
					list.remove(temp); 
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

	@Override
	public int getSize() {
		return size;
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
		
	}

	
	
	
}
