package balancedTrees;


public class AVLTree<T extends Comparable<T>> implements BalancedTree<T> {

	private NodeAVL<T> root; 
	private int size; 
	
	public AVLTree() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(NodeABB<T> newElement) {
		if(root == null) {
			root = (NodeAVL<T>)newElement; 
			size++; 
		}
		else {
			if(root.add(newElement)) {
				size++; 
			}
		}
		
	}

	@Override
	public NodeABB<T> getRoot() {
		return root;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public NodeABB<T> maximum(NodeABB<T> reference) {
		if(root == null) 
			return null;
		else 
			return root.maximum(); 
		
	}

	@Override
	public NodeABB<T> minimum(NodeABB<T> reference) {
		if(root == null)
			return null; 
		else 
			return root.minimun(); 
	}

	@Override
	public void remove(NodeABB<T> reference) {
		root.remove(reference); 
		
	}

	@Override
	public NodeABB<T> search(T value) throws NodeNotFoundException {
		if(root == null) 
			throw new NodeNotFoundException("this node not found"); 
		else 
			return root.buscar(value); 
	
	
	}

	@Override
	public NodeABB<T> getSuccerssor(NodeABB<T> reference) {
		return root.getLeft().maximum(); 
		
	}

	@Override
	public void leftRotate(NodeABB<T> reference) {
		if(reference.getFather() != null) {
			NodeABB<T> x = reference.getFather(); 
			if(reference.getLeft() != null) {
				NodeABB<T> b = reference.getLeft(); 
				x.setRight(b);
			}
			
			reference.setFather(x.getFather());
			
			if(x.getFather() == null) {
				root = (NodeAVL<T>)reference; 
			}
			else if(x.isLeftSon()) {
				x.getFather().setLeft(reference);
			}
			else {
				x.getFather().setRight(reference);
			}
			
			reference.setLeft(x);
			reference.setFather(x.getFather());
			
		}
		
	}

	@Override
	public void rigthRotate(NodeABB<T> reference) {
		if(reference.getFather() != null) {
			NodeABB<T> y = reference.getRight();
			
			if(reference.getRight() != null) {
				NodeABB<T> b = reference.getRight(); 
				y.setLeft(b);
			}
			reference.setFather(y.getFather());
			
			if(y.getFather() == null) {
				root = (NodeAVL<T>)reference; 
			}
			else if(y.isLeftSon()) {
				y.getFather().setLeft(reference);
			}
			else {
				y.getFather().setRight(reference);
			}
			
			reference.setRight(y);
			reference.setFather(y.getFather());
			
		}
		
	}

	@Override
	public boolean exist(T value) {
		boolean exist = false ; 
		try{
			if(search(value) != null) {
				exist = true; 
			}
			
		}catch (NodeNotFoundException e) {
			e.printStackTrace();
		}
		
		return exist;
	}
	
	public int calculateBalanceFactor() {
		if ( root == null )
			return 0;
		else
			return root.calculateBalanceFactor();

	}


	/**
	 * balancedTree : this method balanced the tree 
	 * @param NodeAVL newAVL    : the node has been added to tree
	 * 		  NodeAVL fatherAVL : the node that is father of newAVL 
	 * */
	public void balancedTree(NodeAVL<T> newAVL, NodeAVL<T> fatherAVL) {
		boolean balanced = false; 
		
		do {
			 // balance_factor(P) has not yet been updated!
			 if (newAVL.isLeftSon()) { 
				 // the left subtree increases
				 if (fatherAVL.calculateBalanceFactor() == 1) { // The left column in the picture
					 // ==> the temporary balance_factor(P) == 2 ==> rebalancing is required.
					 if (newAVL.calculateBalanceFactor() == -1) { // Left Right Case
						 leftRotate(newAVL); // Reduce to Left Left Case
					 }
					 // Left Left Case
					 rigthRotate(fatherAVL);
					 balanced = true; // Leave the loop
				 }
				 else if (fatherAVL.calculateBalanceFactor() == -1) {
					  fatherAVL.setBalancedFactor(0);  // N’s height increase is absorbed at P.
					 balanced = true; // Leave the loop
			 }
			 fatherAVL.setBalancedFactor(1);  // Height increases at P
			 
			 } 
			 else { // N == right_child(P), the child whose height increases by 1.
				 if (fatherAVL.calculateBalanceFactor() == -1) { // The right column in the picture
					 // ==> the temporary balance_factor(P) == -2 ==> rebalancing is required.
					 if (newAVL.calculateBalanceFactor() == 1) { // Right Left Case
						rigthRotate(newAVL); // Reduce to Right Right Case
					 }
					 // Right Right Case
					 leftRotate(fatherAVL);
					 balanced = true; // Leave the loop
				 }
				 if (fatherAVL.calculateBalanceFactor() == 1) {
					 fatherAVL.setBalancedFactor(0);   // N’s height increase is absorbed at P.
					 balanced = true; // Leave the loop
				 }
				 fatherAVL.setBalancedFactor(-1);  // Height increases at P
			 }
			 newAVL = fatherAVL;
			 fatherAVL.setFather(newAVL);
			} while (fatherAVL != null && !balanced); // Possibly up to t
	}

	
	
}
