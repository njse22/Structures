package Trees;

public class Interfaz {

	public static void main(String[] args) {
		
		TreeABB<Integer> tree = new TreeABB<>(); 
		
		tree.add(8);
		tree.add(4);
		tree.add(10);
		tree.add(12);
		tree.add(7);
		tree.add(3);
		tree.add(1);
		
		tree.printTree();
		
	}
	
	
}
