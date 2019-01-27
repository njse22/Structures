package Trees;

public class NodeRedBlack <T extends Comparable<T>> extends NodeABB<T>{
	
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
	
	/**
	 * represent the "uncle" of the Node
	 * this is only black and red trees 
	 * */
	private NodeRedBlack<T> uncle; 
	
	/**
	 * represent the "grandFather" of the Node
	 * this is only black and red trees 
	 * */
	private NodeRedBlack<T> grandFather;

	
	
	public NodeRedBlack() {
		super(null, null, null, null);
		this.color = -1;
		this.uncle = null;
		this.grandFather = null;
		
	}



	public NodeRedBlack(T value, NodeABB<T> rigth, NodeABB<T> left, NodeABB<T> father, 
						int color, NodeRedBlack<T> uncle,NodeRedBlack<T> grandFather) {
		
		super(value, rigth, left, father);
		this.color = color;
		this.uncle = uncle;
		this.grandFather = grandFather;
		
	}

	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public NodeRedBlack<T> getUncle() {
		NodeABB<T> uncleO = null; 
		if(this.getFather().isLeftSon()) {
			uncleO = this.getGrandFather().getRight(); 
		}
		else {
			uncleO = this.getGrandFather().getLeft();
		}
		this.uncle = (NodeRedBlack<T>)uncleO;
		return uncle;
	}

	public void setUncle(NodeRedBlack<T> uncle) {
		this.uncle = uncle;
	}

	public NodeRedBlack<T> getGrandFather() {
		this.grandFather = (NodeRedBlack<T>) this.getFather().getFather();
		return grandFather; 
	}

	public void setGrandFather(NodeRedBlack<T> grandFather) {
		this.grandFather = grandFather;
	}

	/**
	 * repaint() : this method chance the color of the actual Node 
	 * */
	public void repaint() {
		if (this.getColor() == 0) 
			this.setColor(RED);
		
		else
			this.setColor(BLACK);
		
	}


	
	
	
	
	

}
