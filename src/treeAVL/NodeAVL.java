package treeAVL;

public class NodeAVL <K extends Comparable<K> , T > {
	
	private K key;
	
	private T value;
	
	private int balanceFactor;
	
	private NodeAVL<K, T> father;
	private NodeAVL<K, T> lefth;
	private NodeAVL<K, T> right;
	
	public NodeAVL(K key, T value, int balanceFactor) {
		this.key =  key;
		this.value = value;
		this.balanceFactor = balanceFactor;
		
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}

	public NodeAVL<K, T> getFather() {
		return father;
	}

	public void setFather(NodeAVL<K, T> father) {
		this.father = father;
	}

	public NodeAVL<K, T> getLefth() {
		return lefth;
	}

	public void setLefth(NodeAVL<K, T> lefth) {
		this.lefth = lefth;
	}

	public NodeAVL<K, T> getRight() {
		return right;
	}

	public void setRight(NodeAVL<K, T> right) {
		this.right = right;
	}
	
	public boolean isLeaf() {
		return (right == null && lefth == null)? true:false;
	}
	
	public boolean isLeftSon() {
		return father != null && father.getLefth() == this;
	}
	
	public boolean isRightSon() {
		return father != null && father.getRight() == this;
	}
	
	
	public int height() {
		if(isLeaf()) {
			return 1;
		}else {
			if(lefth == null) {
				return 1 + right.height();
			}else if(right == null) {
				return 1 + lefth.height();
			}else {
				return Math.max(1 + lefth.height() ,1 +  right.height());
			}
		}
	}
	
	public int balanceFactor() {
		if(isLeaf()) {
			return 0;
		}else if(lefth == null) {
			return right.height();
		}else if( right == null){
			return lefth.height()*(-1);
		}else {
			return right.height() - lefth.height();
		}
	}
	
	public int calculateBalanceFactor() {
		return balanceFactor = balanceFactor();
	}
	
	public void add ( NodeAVL<K, T> newNode) {
		if(newNode.getKey().compareTo(key) > 0) {
			if( right == null) {
				right = newNode;
				right.setFather(this);
			}else {
				right.add(newNode);
			}
		}else {
			if(lefth == null) {
				lefth = newNode;
				lefth.setFather(this);
			}else {
				lefth.add(newNode);
			}
		}
	}
	
	public NodeAVL<K, T> search(K searchKey) throws ElementNoFoundException{
		if(searchKey.compareTo(key) == 0) {
			return this;
		}else if(searchKey.compareTo(key) > 0) {
			if(right == null) {
				throw new ElementNoFoundException("the item was not found");
			}else {
				return right.search(searchKey);
			}
		}else {
			if(lefth == null) {
				throw new ElementNoFoundException("the item was not found");
			}else {
				return lefth.search(searchKey);
			}
		}
	}
	
	public void printTree() {
		if(isLeaf()) {
			System.out.println(key);
		}else {
			if(lefth != null) {
				System.out.println(lefth.getKey());
				lefth.printTree();				
			}
			if(right != null) {
				System.out.println(right.getKey());
				right.printTree();				
			}
		}
	}

}
