package Trees;

public class NodeAVL<T extends Comparable<T>> extends NodeABB<T>{

	private int balanceFactor;

	public NodeAVL() {
		
		super();
		balanceFactor = 0; 
		
	}

	public NodeAVL(T value, NodeABB<T> rigth, NodeABB<T> left, NodeABB<T> father) {
		
		super(value, rigth, left, father);
		balanceFactor = 0;
		
	}

	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
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
