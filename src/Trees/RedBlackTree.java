package Trees;

public class RedBlackTree<T extends Comparable<T>> extends BalancedTree<T>  {

	
	@SuppressWarnings("unused")
	private NodeRedBlack<T> root; 
	
	public RedBlackTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RedBlackTree(NodeRedBlack<T> root) {
		super(root);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add (T value) {
		try { 
			super.add(value);
			addCase1((NodeRedBlack<T>) this.search(value));
		}catch (NodeNotFoundException e) {
			System.out.println("nooooooo");
		}
	}
	
	
	private void addCase1(NodeRedBlack<T> newBR) {
		
		
		if (newBR.getFather() == null) { 
			newBR.setColor(NodeRedBlack.BLACK);
		}
		else {
			addCase2(newBR);
		}
		
	}
	
	private void addCase2(NodeRedBlack<T> newBR) {
		
		if ( ( ((NodeRedBlack<T>) newBR.getFather()).getColor() == NodeRedBlack.RED ) && 
				( newBR.getUncle().getColor() == NodeRedBlack.RED ) ) {
			
			((NodeRedBlack<T>) newBR.getFather()).repaint();
			newBR.getUncle().repaint();
			newBR.getGrandFather().repaint();
			addCase1(newBR);
		}
		else {
			addCase3(newBR);
		}
	}
	
	private void addCase3(NodeRedBlack<T> newBR) {
		
		if ( newBR.isRigthSon() && newBR.getFather().isLeftSon() ) {
			leftRotete((NodeRedBlack<T>)newBR.getFather());
			
		}
		else if (newBR.isLeftSon() && newBR.getFather().isRigthSon()) {
			rigthRotete((NodeRedBlack<T>)newBR.getFather());
			
		}
		else {
			addCase4(newBR);
		}
	}

	private void addCase4(NodeRedBlack<T> newBR) {
		((NodeRedBlack<T>)newBR.getFather()).setColor(NodeRedBlack.BLACK);
		if(newBR.getGrandFather() != null) {
			newBR.getGrandFather().setColor(NodeRedBlack.RED);
		}
		
		
		if(newBR.isLeftSon() && newBR.getFather().isLeftSon()) {
			rigthRotete(newBR.getGrandFather());
		}else if (newBR.getGrandFather() != null) {
			leftRotete(newBR.getGrandFather());
		}
		
	}
	
	
	
	
	
	
}
