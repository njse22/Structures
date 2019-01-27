package Trees;

public class TreeABB <T extends Comparable<T>>  implements ITree<T>{

	protected NodeABB<T> root; 
	
	private int size;

	public TreeABB(NodeABB<T> root) {
		
		this.root = root;
		this.size = 1;
		
	}

	public TreeABB() {
		
		this.root = null;
		this.size = 0;
		
	}

	public NodeABB<T> getRoot() {
		return root;
	}

	public void setRoot(NodeABB<T> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	@Override
	public void remove(NodeABB<T> delete) {
		root.remove(delete); 
		
	}

	@Override
	public NodeABB<T> minimum(NodeABB<T> reference) {
		if (root == null)
			return null;
		else 
			return root.minimun();
	}

	@Override
	public NodeABB<T> maximum(NodeABB<T> reference) {
		if(root == null)
			return null;
		else 
			return root.maximum();
	}

	@Override
	public NodeABB<T> successor(NodeABB<T> reference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exist(T value) {
		boolean existe = false ;
		
		try {
			if (search(value) != null) {
				existe = true;
			}
		}catch (NodeNotFoundException e) {
			e.getMessage();
		}

		return existe;
		
	}

	@Override
	public NodeABB<T> search(T value) throws NodeNotFoundException {
		if(root == null)
			throw new NodeNotFoundException("this node not found");
		else
			return root.buscar(value);
		
	}
	
	@Override
	public void add(T value) {
		NodeABB<T> newElement = new NodeABB<>(value);
		if (root == null) {
			root = newElement;
			size++;
		}
		else {
			if(root.add(newElement)) {
				size++; 
			}
			
		}
	
	}

	public void printTree() {
		if(root == null) {
			System.out.println("this tree is empty");
		}
		else {
			System.out.println(root.getValue()+ "\n");
			System.out.println("left");
			printTree(root.getLeft());
			System.out.println("right");
			printTree(root.getRight());
		}
		
		
	}
	
	private void printTree(NodeABB<T> node) {
		
		if(node == null) {
			return;  
		}
		else {
				
			System.out.println(node.getValue() +"\n");
			
			if (node.haveLeftSon()) {
				System.out.println("left");
				printTree(node.getLeft());
			}
			if(node.haveRightSon()) {
				System.out.println("right");
				printTree(node.getRight());
			}
		}
		
	}

	
	
	
	
	
	
}

