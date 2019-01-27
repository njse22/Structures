package TetsStructures;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Trees.NodeNotFoundException;
import Trees.RedBlackTree;

class TestRedBlackTree {

	private RedBlackTree<Integer> tree; 
	
	void stageOne() {
		tree = new RedBlackTree<>(); 
	}
	
	@Test
	void test() throws NodeNotFoundException {
		stageOne();  
		
		tree.add(10);
		tree.add(12);
		tree.add(8);
		tree.add(4);
		tree.add(1);
		tree.add(7);
		tree.add(3);
		
		tree.printTree();
		
		/* testing sons */
		assertTrue(tree.search(8) == tree.getRoot());
		assertTrue(tree.search(8).getRight().getValue() == 10);
		assertTrue(tree.search(8).getLeft().getValue() == 4);
		assertTrue(tree.search(8).getRight().getRight().getValue() == 12);
		assertTrue(tree.search(8).getLeft().getRight().getValue() == 7);
		assertTrue(tree.search(8).getLeft().getLeft().getValue() == 3);
		assertTrue(tree.search(8).getLeft().getLeft().getLeft().getValue() == 1);
		/* testing fathers */
		assertTrue(tree.search(1).getFather().getValue() == 3);
		assertTrue(tree.search(3).getFather().getValue() == 4);
		assertTrue(tree.search(7).getFather().getValue() == 4);
		assertTrue(tree.search(4).getFather().getValue() == 8);
		assertTrue(tree.search(12).getFather().getValue() == 10);
		assertTrue(tree.search(10).getFather().getValue() == 8);
		
		
	}
	

}
