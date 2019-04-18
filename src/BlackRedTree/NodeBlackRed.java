package BlackRedTree;

public class NodeBlackRed< T, K extends Comparable<K> > implements Comparable<NodeBlackRed<T, K>> {

	private T value; 
	private K key; 
	
	private NodeBlackRed< T , K > right; 
	private NodeBlackRed< T , K > left;
	private NodeBlackRed< T , K > father;
	
	/**
	 * this constant represent the color black 
	 * this is only black and red trees
	 * */
	public final static int BLACK = 0; 
	
	/**
	 * this constant represent the color black 
	 * this is only black and red trees
	 * */
	public final static int RED = 1; 
	
	/**
	 * represent the color of Node 
	 * this is only black and red trees
	 * */
	private int color; 
	
	public NodeBlackRed(T value, K key, NodeBlackRed<T, K> right, NodeBlackRed<T, K> left, NodeBlackRed<T, K> father,
			int color) {
		super();
		this.value = value;
		this.key = key;
		this.right = right;
		this.left = left;
		this.father = father;
		this.color = color;
	}

	public NodeBlackRed() {
		this.value = null;
		this.key = null;
		this.right = null;
		this.left = null;
		this.father = null;
		this.color = -1;
	}
	
	public NodeBlackRed(T value, K key) {
		this.value = value;
		this.key = key;
		this.right = null;
		this.left = null;
		this.father = null;
		this.color = -1;
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

	public NodeBlackRed<T, K> getRight() {
		return right;
	}

	public void setRight(NodeBlackRed<T, K> right) {
		this.right = right;
	}

	public NodeBlackRed<T, K> getLeft() {
		return left;
	}

	public void setLeft(NodeBlackRed<T, K> left) {
		this.left = left;
	}

	public NodeBlackRed<T, K> getFather() {
		return father;
	}

	public void setFather(NodeBlackRed<T, K> father) {
		this.father = father;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public NodeBlackRed<T,K> maximum() {
		if(right == null)
			return this;
		else
			return right.maximum();
		
	}
	
	public NodeBlackRed<T,K> minimun() {
		if(left == null)
			return this;
		else 
			return left.minimun();
	}

	public boolean add(NodeBlackRed<T,K> newElement) {
		if(this.key.compareTo(newElement.key) > 0) {
			if(left == null) {
				left = newElement;
				left.color = NodeBlackRed.RED; 
				left.father = this;
				return true;
			}
				
			else {
				left.add(newElement);
				return false;
			}
				
		}
		else
			if(right == null) {
				right = newElement;
				right.color = NodeBlackRed.RED; 
				right.father = this; 
				return true;
			} 
				
			else {
				right.add(newElement);
				return false ;
			}
				 
		}
	
	public NodeBlackRed<T,K> buscar(K key) throws NodeNotFoundException  {
//		System.out.println(value + "buscado");
//		System.out.println(this.getValue() + "actual");
		if( key.compareTo(this.key) == 0)  {
			return this;
		}
		else if (key.compareTo(this.getKey()) < 0 ) {
			if(left == null)
				throw new NodeNotFoundException("this node hasn't been found");
			else
				return left.buscar(key);
		}
		else {
			if(right == null)
				throw new NodeNotFoundException("this node hasn't been found");
			else
				return right.buscar(key);
		}
		
	}	

	public NodeBlackRed<T, K> remove(K key) {
		
		if( (this.getKey().compareTo(key) == 0 )  ) {
		
			if(this.isSon()) {
				this.setFather(null);
				return null;
			}
			else {

				if(this.haveRightSon() && this.haveLeftSon()) {
					NodeBlackRed<T,K> successor = this.left.maximum();
					successor.setRight(this.getRight());
					successor.setLeft(this.getLeft());
					successor.setFather(this.getFather());
					
					this.setLeft(null);
					this.setRight(null);
					this.setFather(null);
					
					return successor; 
				}
				
				if(this.haveLeftSon()) {
					this.getLeft().setFather(this.getFather());
					this.setFather(null);
					this.setLeft(null);
				}
				if(this.haveRightSon()) {
					this.getRight().setFather(this.getFather());
					this.setFather(null);
					this.setRight(null);
				}
			}
		}	
		
		else if(this.getKey().compareTo(key) > 0)
			return left.remove(key);
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
	
	public NodeBlackRed<T,K> getUncle() {
		if(this.getFather().isLeftSon())
			return  this.getGrandFather().getRight(); 
		else 
			return this.getGrandFather().getLeft(); 
	}

	public NodeBlackRed<T,K> getGrandFather() {
		return this.getFather().getFather();
	}


	public void rePaint() {
		if( this.color == RED)
			this.color = BLACK; 
		else 
			this.color = RED; 
	}

	
	
	@Override
	public int compareTo(NodeBlackRed<T, K> comparable) {
		
		
		return 0;
	}

}
