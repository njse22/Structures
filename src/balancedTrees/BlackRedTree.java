package balancedTrees;

public class BlackRedTree<T extends Comparable<T>> implements BalancedTree<T> {

	private NodeBlackRed<T> root; 
	private int size; 
	
	
	@Override
	public void add(NodeABB<T> newElement) {
		if(root == null) {
			root = (NodeBlackRed<T>)newElement; 
			root.setColor(NodeBlackRed.BLACK);
			size++; 
		}
		else {
			if(root.add(newElement)) {
				size++; 
			}
		}
		
		balancedTree((NodeBlackRed<T>)newElement);
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
				root = (NodeBlackRed<T>)reference; 
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
				root = (NodeBlackRed<T>)reference; 
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
	
	private void balancedTree(NodeBlackRed<T> newElement) {
		
		while( ((NodeBlackRed<T>) newElement.getFather()).getColor() == NodeBlackRed.RED ) {
			if( newElement.getFather().isLeftSon() ) {
				NodeBlackRed<T> y = (NodeBlackRed<T>) newElement.getGrandFather().getRight();
				if(y.getColor() == NodeBlackRed.RED) {
					((NodeBlackRed<T>) newElement.getFather()).setColor(NodeBlackRed.BLACK);
					y.setColor(NodeBlackRed.BLACK);
					newElement.getGrandFather().setColor(NodeBlackRed.RED);
					newElement = newElement.getGrandFather(); 

				}
				else {
					if(newElement.isRigthSon()) {
						newElement = (NodeBlackRed<T>) newElement.getFather(); 
						leftRotate(newElement);
					}
					((NodeBlackRed<T>) newElement.getFather()).setColor(NodeBlackRed.BLACK); 
					newElement.getGrandFather().setColor(NodeBlackRed.RED);
					rigthRotate(newElement.getGrandFather());
				}
			
			}else {
				if( newElement.getFather().isRigthSon() ) {
					NodeBlackRed<T> y = (NodeBlackRed<T>) newElement.getGrandFather().getLeft();
					if(y.getColor() == NodeBlackRed.RED) {
						((NodeBlackRed<T>) newElement.getFather()).setColor(NodeBlackRed.BLACK);
						y.setColor(NodeBlackRed.BLACK);
						newElement.getGrandFather().setColor(NodeBlackRed.RED);
						newElement = newElement.getGrandFather(); 

					}
					else {
						if(newElement.isLeftSon()) {
							newElement = (NodeBlackRed<T>) newElement.getFather(); 
							rigthRotate(newElement);
						}
						((NodeBlackRed<T>) newElement.getFather()).setColor(NodeBlackRed.BLACK); 
						newElement.getGrandFather().setColor(NodeBlackRed.RED);
						leftRotate(newElement.getGrandFather());
					}

				}		
			}
		}
	}
	
	
	
	
	
	
	
	
}