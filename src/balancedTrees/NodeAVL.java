package balancedTrees;



public class NodeAVL <T extends Comparable<T>> extends NodeABB<T> {
	
	private int balancedFactor;

	public NodeAVL(T value, NodeABB<T> rigth, NodeABB<T> left, NodeABB<T> father, int balancedFactor) {
		super(value, rigth, left, father);
		this.balancedFactor = balancedFactor;
	}

	public NodeAVL() {
		super(null, null, null, null);
		this.balancedFactor = 0;
	}

	public int getBalancedFactor() {
		return balancedFactor;
	}

	public void setBalancedFactor(int balancedFactor) {
		this.balancedFactor = balancedFactor;
	} 
	
	public int calculateBalanceFactor() {
		int p1 , p2 ;
		if ( this.getLeft() == null )
			p1 = 0 ;
		else
			p1 = ((NodeAVL<T>) this.getLeft()).calculateBalanceFactor() ;
		if ( this.getRight() == null )
			p2 = 0 ;
		else
			p2 = ((NodeAVL<T>) this.getRight()).calculateBalanceFactor() ;
		return p1 - p2 ;
			
		 
	}


	
	
	

}
