package TetsStructures;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import balancedTrees.AVLTree;
import balancedTrees.NodeAVL;


class TestAVLTree {
	
	private AVLTree<Integer> tree; 
	
	void setUpStageOne() {
		tree = new AVLTree<Integer>(); 
	}
	
	
	@Test
	void test() {
		setUpStageOne();

		NodeAVL<Integer> newElement = new NodeAVL<Integer>(10); 
		NodeAVL<Integer> a = new NodeAVL<Integer>(3);
		NodeAVL<Integer> b = new NodeAVL<Integer>(12);
		NodeAVL<Integer> c = new NodeAVL<Integer>(6);
		NodeAVL<Integer> d = new NodeAVL<Integer>(20);
		NodeAVL<Integer> e = new NodeAVL<Integer>(5);
		
		tree.add(newElement);		
		tree.add(a);
		tree.add(b);
		tree.add(c);
		tree.add(d);
		tree.add(e);
		
		assertTrue(tree.getRoot().getLeft().getValue() == 5);
		
	}

}
