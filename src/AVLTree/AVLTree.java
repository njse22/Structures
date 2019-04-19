package AVLTree;

public class AVLTree <T,K extends Comparable<K>> implements IAVLTree<T, K>{

	private NodeAVL<T, K> root; 
	private int size; 
	
	@Override
	public void add(NodeAVL<T, K> newElement) {
		if(root == null) {
			
			root = newElement; 
			root.setBalanceFactor(root.balanceFactor());
			size++; 
		}
		else {
			
			if(root.add(newElement)) {
				size++; 
			}
			if( newElement.getGrandFather() != null) {
				balancedTree(newElement);
			}
		}
		
	}

	@Override
	public NodeAVL<T, K> getRoot() {
		return root;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public NodeAVL<T, K> maximum(NodeAVL<T, K> reference) {
		if(root == null) 
			return null;
		else 
			return root.maximum(); 
	}

	@Override
	public NodeAVL<T, K> minimum(NodeAVL<T, K> reference) {
		if(root == null)
			return null; 
		else 
			return root.minimun();
	}

	@Override
	public void remove(K key) {
		try {
			NodeAVL<T, K> tenp = search(key);
			
			if (tenp.isRoot()) {
				NodeAVL<T, K> successor = root.getLeft().maximum();
				
				NodeAVL<T,K> x = successor.getFather(); 
				
				successor.setRight(root.getRight());
				successor.setLeft(root.getLeft());
				successor.setFather(tenp.getFather());
				
				root.setLeft(null);
				root.setRight(null);
				root.setFather(null);
				
				x.setRight(null);
				
				root = successor; 
				
				balancedTree(x);
				
			}else {
				balancedTree( root.remove(key) );
				
			}
			
			} catch (NodeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}

	@Override
	public NodeAVL<T, K> search(K key) throws NodeNotFoundException {
		if(root == null) 
			throw new NodeNotFoundException("this node not found"); 
		else 
			return root.buscar(key); 
	}

	@Override
	public NodeAVL<T, K> getSuccerssor(NodeAVL<T, K> actual) {
		return root.getLeft().maximum();
	}

	public void lefth(NodeAVL<T, K> reference) {
		NodeAVL<T,K> y = reference.getRight(); 
		y.setFather(reference.getFather());
		reference.setFather(y);
		y.setLeft(reference);
		
	}
	
	
	@Override
	public void leftRotate(NodeAVL<T, K> reference) {
		if(reference.getFather() != null) {
			NodeAVL<T,K> x = reference.getFather(); 
			if(reference.getLeft() != null) {
				NodeAVL<T,K> b = reference.getLeft(); 
				x.setRight(b);
			}
			
			reference.setFather(x.getFather());
			
			if(x.getFather() == null) {
				root = reference; 
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
	
	public void rigth(NodeAVL<T, K> reference) {
		NodeAVL<T,K> y = reference.getLeft(); 
		y.setFather(reference.getFather());
		reference.setFather(y);
		y.setRight(reference);
		
	}

	@Override
	public void rigthRotate(NodeAVL<T, K> reference) {

		if(reference.getFather() != null) {
			NodeAVL<T,K> y = reference.getFather();
			
			if(reference.getRight() != null) {
				NodeAVL<T,K> b = reference.getRight(); 
				y.setLeft(b);
			}
			reference.setFather(y.getFather());
			
			if(y.getFather() == null) {
				root = reference; 
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
	public boolean exist(K key) {
		boolean exist = false ; 
		try{
			if(search(key) != null) {
				exist = true; 
			}
			
		}catch (NodeNotFoundException e) {
			e.printStackTrace();
		}
		
		return exist;	
	}
	

	private void balancedTree(NodeAVL<T, K> newElement) {
		
		if(newElement.getGrandFather().balanceFactor() == 2) {
			if(newElement.isLeftSon()) {
				newElement = newElement.getFather(); 
				rigth(newElement);
			}
			if(newElement.isRigthSon()) {
				leftRotate(newElement.getFather());
			}
		}else if(newElement.getGrandFather().balanceFactor() == -2) {
			if(newElement.isRigthSon()) {
				newElement = newElement.getFather(); 
				lefth(newElement);
			}
			if(newElement.isLeftSon()) {
				rigthRotate(newElement.getFather());
			}
			
		}
		
	}
	

	
	
	
	
	
	
	

}
