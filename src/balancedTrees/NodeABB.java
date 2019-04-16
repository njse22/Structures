package balancedTrees;

public class NodeABB<T extends Comparable<T> > implements Comparable<NodeABB<T>> {

	private T value; 
	
	private NodeABB< T > right; 
	private NodeABB< T > left;
	private NodeABB< T > father;

	public NodeABB(T value, NodeABB<T> rigth, NodeABB<T> left, NodeABB<T> father) {

		this.value = value;
		this.right = rigth;
		this.left = left;
		this.father = father;
		
	}

	public NodeABB() {
		
		this.value = null; 
		this.right = null;
		this.left = null;
		this.father = null;
		
	}

	public NodeABB(T value) {

		this.value = value; 
		this.right = null;
		this.left = null;
		this.father = null;
		
		
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public NodeABB<T> getRight() {
		return right;
	}

	public void setRight(NodeABB<T> rigth) {
		this.right = rigth;
	}

	public NodeABB<T> getLeft() {
		return left;
	}

	public void setLeft(NodeABB<T> left) {
		this.left = left;
	}

	public NodeABB<T> getFather() {
		return father;
	}

	public void setFather(NodeABB<T> father) {
		this.father = father;
	}

	public NodeABB<T> maximum() {
		if(right == null)
			return this;
		else
			return right.maximum();
		
	}
	
	public NodeABB<T> minimun() {
		if(left == null)
			return this;
		else 
			return left.minimun();
	}

	public boolean add(NodeABB<T> newElement) {
		if(this.getValue().compareTo(newElement.getValue()) > 0) {
			if(left == null) {
				left = newElement;
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
				right.father = this; 
				return true;
			} 
				
			else {
				right.add(newElement);
				return false ;
			}
				 
		}
	
	public NodeABB<T> buscar(T value) throws NodeNotFoundException  {
//		System.out.println(value + "buscado");
//		System.out.println(this.getValue() + "actual");
		if( value.compareTo(this.getValue()) == 0)  {
			return this;
		}
		else if (value.compareTo(this.getValue()) < 0 ) {
			if(left == null)
				throw new NodeNotFoundException("this node hasn't been found");
			else
				return left.buscar(value);
		}
		else {
			if(right == null)
				throw new NodeNotFoundException("this node hasn't been found");
			else
				return right.buscar(value);
		}
		
	}	

	public NodeABB<T> remove(NodeABB<T> delete) {
		if(left == null && right == null) {
			return null;
		}	
		if(this.getValue().compareTo(delete.getValue()) == 0) {
			if(left == null)
				return right;
			if(right == null)
				return left;
		
			NodeABB<T> successor = right.minimun();
			right.remove(successor);
			successor.left = left;
			successor.right = right;
			return successor;
			
		}
		else if(this.getValue().compareTo(delete.getValue()) > 0)
			left = left.remove(delete);
		else 
			right = right.remove(delete);
		return this;
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

//	@SuppressWarnings("unused")
//	public int calculateHeight() {
//	   int height = 0; 
//		if (this.isSon())
//	    	return height; 
//		
//	    else if (this != null) {
//	    	height++; 
//	    	if(this.left != null) {
//	    		height += this.left.calculateHeight(); 
//	    	}
//	    	if(this.right != null)
//	    		height += this.right.calculateHeight();
//	        //return this.left.calculateHeight() +  this.right.calculateHeight();        
//	    }
//	    return height; 
//	 }

	@Override
	public int compareTo(NodeABB<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
