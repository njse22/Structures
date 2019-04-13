package balancedTrees;


public class NodeBlackRed<T extends Comparable<T>> extends NodeABB<T> {

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
	
	
	public NodeBlackRed(T value, NodeABB<T> rigth, NodeABB<T> left, NodeABB<T> father, int color) {
		super(value, rigth, left, father);
		this.color = color;
		
	}

	public NodeBlackRed() {
		super(null, null, null, null);
		color = -1; 
		 
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public NodeBlackRed<T> getUncle() {
		if(this.getFather().isLeftSon())
			return (NodeBlackRed<T>) this.getGrandFather().getRight(); 
		else 
			return (NodeBlackRed<T>) this.getGrandFather().getLeft(); 
	}

	public NodeBlackRed<T> getGrandFather() {
		return (NodeBlackRed<T>) this.getFather().getFather();
	}


	public void rePaint() {
		if( this.color == RED)
			this.color = BLACK; 
		else 
			this.color = RED; 
	}
	
	
	
	
	
}
