package balancedTrees;



public class NodeAVL <T extends Comparable<T>> extends NodeABB<T> {
	
	private int balancedFactor;

	public NodeAVL(T value, NodeABB<T> rigth, NodeABB<T> left, NodeABB<T> father, int balancedFactor) {
		super(value, rigth, left, father);
		this.balancedFactor = balancedFactor;
	}

	public NodeAVL(T value) {
		super(value, null, null, null);
		this.balancedFactor = 0;
	}
	
	
	

	public int getBalancedFactor() {
		return balancedFactor;
	}

	public void setBalancedFactor(int balancedFactor) {
		this.balancedFactor = balancedFactor;
	} 
	
	public int calculateBalanceFactor() {
		if(this.isSon()) {
			return 0; 
		}
		else { 
			int fb = 0;
			int lefht = 0; 
			int right = 0; 
			if(this.haveRightSon()) { 
				right += ((NodeAVL<T>) this.getRight()).calculateBalanceFactor()+1;
			}
			if(this.haveLeftSon()) { 
				lefht += ((NodeAVL<T>) this.getLeft()).calculateBalanceFactor()+1;
			}
			return fb = right - lefht; 
		}
	}
	
	public int balanceFactor () {
		int r = 0, l = 0; 
		
		if(this.haveLeftSon())
			l = ((NodeAVL<T>) this.getLeft()).calculateHeight(); 
		if(this.haveRightSon())
			r = ((NodeAVL<T>) this.getRight()).calculateHeight(); 
		
		return r - l ; 
		
	}
		 
	public int calculateHeight() {
		int countR = 0; 
		int countL = 0; 
		if(this.haveRightSon()) {
			countR +=  ((NodeAVL<T>) this.getRight()).calculateHeight() + 1;
		}
		if(this.haveLeftSon()) {
			countL +=  ((NodeAVL<T>) this.getLeft()).calculateHeight() + 1;
		}
		return Math.max(countL, countR); 
	}
	
	
	
	

}
