package AVLTree;

public class NodeAVL< T,K extends Comparable<K> > implements Comparable<NodeAVL<T,K>> {

	private T value; 
	private K key; 
	private int balanceFactor; 
	
	private NodeAVL< T,K > right; 
	private NodeAVL< T,K > lefth;
	private NodeAVL< T,K > father;

	public NodeAVL(T value, K key, int balanceFactor, NodeAVL<T, K> right, NodeAVL<T, K> left, NodeAVL<T, K> father) {
		super();
		this.value = value;
		this.key = key;
		this.balanceFactor = balanceFactor;
		this.right = right;
		this.lefth = left;
		this.father = father;
	}

	public NodeAVL() {
		super();
		this.value = null;
		this.key = null;
		this.balanceFactor = -1;
		this.right = null;
		this.lefth = null;
		this.father = null;
	}
	
	public NodeAVL(T value, K key) {
		super();
		this.value = value;
		this.key = key;
		this.balanceFactor = -1;
		this.right = null;
		this.lefth = null;
		this.father = null;
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}

	public NodeAVL<T, K> getRight() {
		return right;
	}

	public void setRight(NodeAVL<T, K> right) {
		this.right = right;
	}

	public NodeAVL<T, K> getLeft() {
		return lefth;
	}

	public void setLeft(NodeAVL<T, K> left) {
		this.lefth = left;
	}

	public NodeAVL<T, K> getFather() {
		return father;
	}

	public void setFather(NodeAVL<T, K> father) {
		this.father = father;
	}


	public NodeAVL<T,K> maximum() {
		if(right == null)
			return this;
		else
			return right.maximum();
		
	}
	
	public NodeAVL<T,K> minimun() {
		if(lefth == null)
			return this;
		else 
			return lefth.minimun();
	}

	public boolean add(NodeAVL<T,K> newElement) {
		if(this.getKey().compareTo(newElement.getKey()) > 0) {
			if(lefth == null) {
				lefth = newElement;
				lefth.balanceFactor = lefth.balanceFactor(); 
				lefth.father = this;
				return true;
			}
				
			else {
				lefth.add(newElement);
				return false;
			}
				
		}
		else
			if(right == null) {
				right = newElement;
				right.balanceFactor = right.balanceFactor(); 
				right.father = this; 
				return true;
			} 
				
			else {
				right.add(newElement);
				return false ;
			}
				 
		}
	
	public NodeAVL<T,K> buscar(K key) throws NodeNotFoundException  {
//		System.out.println(value + "buscado");
//		System.out.println(this.getValue() + "actual");
		if( key.compareTo(this.getKey()) == 0)  {
			return this;
		}
		else if (key.compareTo(this.getKey()) < 0 ) {
			if(lefth == null)
				throw new NodeNotFoundException("this node hasn't been found");
			else
				return lefth.buscar(key);
		}
		else {
			if(right == null)
				throw new NodeNotFoundException("this node hasn't been found");
			else
				return right.buscar(key);
		}
		
	}	

	public NodeAVL<T,K> remove(K key) {
		if( (this.getKey().compareTo(key) == 0 )  ) {
			
			if(this.isSon()) {
				NodeAVL<T,K> y = this.getFather(); 
				this.setFather(null);
				if(this.isLeftSon())
					y.setLeft(null);
				else 
					y.setRight(null);
				
				return null;
			}
			else {

				if(this.haveRightSon() && this.haveLeftSon()) {
					NodeAVL<T,K> successor = this.lefth.maximum();
					NodeAVL<T, K> x = successor.getFather();  
					successor.setRight(this.getRight());
					successor.setLeft(this.getLeft());
					successor.setFather(this.getFather());
					
					this.setLeft(null);
					this.setRight(null);
					this.setFather(null);
					
					return x; 
				}
				
				if(this.haveLeftSon()) {
					NodeAVL<T, K> x = this.getLeft(); 
					this.getLeft().setFather(this.getFather());
					this.setFather(null);
					this.setLeft(null);
					return x; 
				}
				if(this.haveRightSon()) {
					NodeAVL<T, K> x = this.getRight();
					this.getRight().setFather(this.getFather());
					this.setFather(null);
					this.setRight(null);
					return x; 
				}
			}
		}	
		
		else if(this.getKey().compareTo(key) > 0)
			return lefth.remove(key);
		else 
			return right.remove(key);
		
		return null; 

	}

	/**
	 * haveLeftSon() : evaluate if the actual Node have a left son 
	 * @return true  : if the Node have a left son 
	 * 		   false : if the Node don't have a left son
	 * */
	public boolean haveLeftSon() {
		return this.getLeft() != null; 
	}
	
	/**
	 * haveRighSon() : evaluate if the actual Node have a right son 
	 * @return true  : if the Node have a right son 
	 * 		   false : if the Node don't have a right son
	 * */
	public boolean haveRightSon() {
		return this.getRight() != null; 
	}
	
	/**
	 * isRighSon()   : evaluate if the actual Node is a right son 
	 * @return true  : if the Node is a right son 
	 * 		   false : if the Node is not a right son
	 * */
	public boolean isLeftSon() {
		return this.getFather() != null && this.getFather().getLeft() == this; 
	}
	
	/**
	 * isLeftSon()   : evaluate if the actual Node is a left son 
	 * @return true  : if the Node is a left son 
	 * 		   false : if the Node is not a left son
	 * */
	public boolean isRigthSon() {
		return this.getFather() != null && this.getFather().getRight() == this; 
	}
	
	/**
	 * isRoot()      : evaluate if the actual Node is a root of the tree
	 * @return true  : if the Node is the root 
	 * 		   false : if the Node is not the root
	 * */
	public boolean isRoot() {
		return this.getFather() == null; 
	}
	
	/**
	 * isSon()       : evaluate if the actual Node is a son 
	 * @return true  : if the Node is a son 
	 * 		   false : if the Node is not a son
	 * */
	public boolean isSon() {
		return this.getLeft() == null && this.getRight() == null; 
	}

	public NodeAVL<T,K> getUncle() {
		if(this.getFather().isLeftSon())
			return  this.getGrandFather().getRight(); 
		else 
			return this.getGrandFather().getLeft(); 
	}

	public NodeAVL<T,K> getGrandFather() {
		return this.getFather().getFather();
	}
	
	public boolean isLeaf() {
		return (right == null && lefth == null)? true:false;
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
	
	
	
	
	@Override
	public int compareTo(NodeAVL<T, K> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
