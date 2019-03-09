package Hash;

import Trees.NodeNotFoundException;

public class HashNode<K,V extends Comparable<V>> {

	private K key; 
	private V value; 
	
	private HashNode<K,V> next;
	private HashNode<K,V> previus; 
	private int size; 
	
	public HashNode(K key, V value) {
		
		this.key = key;
		this.value = value;
		next = null; 
		previus = null; 
		size = 1; 
		
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

	public int getSize() {
		return size;
	}


	public void incrementSize() {
		size++;
	}
	
	public void add(HashNode<K, V> agregate) {
		if(next == null) {
			next = agregate;
		}else {
			next.add(agregate);
		}
	}
	
	public void  romoveLast() {
		if(next.getNext() == null) {
			next = null;
		}else {
			next.romoveLast();
		}
	}
	
	public void incrementSize(int size) {
		this.size += size;

	}
	
	public HashNode<K, V> getObjet(V value) throws NonexistentKeyException{
		if(next != null) {
			if(next.value.compareTo(value)== 0) {
				return next;
			}else {
				return next.getObjet(value);
			}
		}else {
			throw new NonexistentKeyException("");
		}
	}
	
	

	
	
}
