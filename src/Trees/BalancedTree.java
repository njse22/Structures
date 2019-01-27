package Trees;

abstract class BalancedTree<T extends Comparable<T>> extends TreeABB<T> implements IBalancedTree<T>{

	
	public BalancedTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BalancedTree(NodeABB<T> root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	/**
	 * leftRotete : -this method help to balance the trees AVL and Black and Red trees
	 * 				-this method change two Nodes to stabilize the tree in such a way
	 * 				 that the tree remain a ABB 
	 *  
	 * @param actual : Node - the Node that needs rotate 
	 * @return void 
	 * */
	@Override
	public void leftRotete(NodeABB<T> actual) {
		
		if (actual.getFather() != null) {

			NodeABB<T> x = actual.getFather(); 
				
			 if (actual.getLeft() != null) {
				 NodeABB<T> b = actual.getLeft();
				 x.setRight(b); 
			 }
			 actual.setFather(x.getFather());
			
			 if(x.getFather() == null) 
				 root = (NodeAVL<T>) actual ; 
			 
			 else if (x.isLeftSon()) 
				 x.getFather().setLeft(actual); 
			 
			 else 
				 x.getFather().setRight(actual);
			 
			actual.setLeft(x);
			actual.setFather(x.getFather()); 
		}
	}
	
	/**
	 * rigthRotete : -this method help to balance the trees AVL and Black and Red trees
	 * 				 -this method change two Nodes to stabilize the tree in such a way
	 * 				  that the tree remain a ABB 
	 *  
	 * @param actual : Node - the Node that needs rotate 
	 * @return void 
	 * */
	@Override
	public void rigthRotete(NodeABB<T> actual) {
		
		if (actual.getFather() != null) {

			NodeABB<T> y = actual.getFather(); 
				
			 if (actual.getRight() != null) {
				 NodeABB<T> b = actual.getRight();
				 y.setLeft(b); 
			 }
			 actual.setFather(y.getFather());
			
			 if(y.getFather() == null) 
				 root = (NodeAVL<T>) actual; 
			 
			 else if (y.isLeftSon()) 
				 y.getFather().setLeft(actual); 
			 
			 else 
				 y.getFather().setRight(actual);
			 
			actual.setRight(y);
			actual.setFather(y.getFather()); 	
		}	 
	}

	
	
	
}
