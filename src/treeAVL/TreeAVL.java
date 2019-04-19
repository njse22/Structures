package treeAVL;

import org.junit.jupiter.engine.descriptor.NestedClassTestDescriptor;

public class TreeAVL<K extends Comparable<K>, T> implements ITreeAVL<K, T> {
	
	private NodeAVL<K, T> root;
	
	public TreeAVL() {
		root = null;
	}

	@Override
	public void add(K key, T value) throws ElementNoFoundException {
		NodeAVL<K, T> newNode = new NodeAVL<K, T>(key, value, 0);
		if(root == null) {
			root = newNode;
			root.calculateBalanceFactor();
		}else {
			root.add(newNode);
			NodeAVL<K, T> current = search(key);
			System.out.println("////////////");
			balanceTree(current.getFather());
			System.out.println("--------");
			System.out.println(root.getKey());
			System.out.println(root.getRight());
//			printTree();
		}
		
	}

	@Override
	public NodeAVL<K, T> search(K key) throws ElementNoFoundException {
		if(key.compareTo(root.getKey())== 0) {
			return root;
		}else {
			return root.search(key);
		}
	}

	@Override
	public boolean remove(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void leftRotate(NodeAVL<K, T> nodeReference) {

		
		
	}

	@Override
	public void rigthRotate(NodeAVL<K, T> nodeReference) {
		
		
		
	}

	@Override
	public void balanceTree( NodeAVL<K, T> fatherNode) {
		

	}
	
	public void printTree() {
		if(root != null) {
			root.printTree();
		}
	}

}
