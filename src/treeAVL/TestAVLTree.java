package treeAVL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAVLTree {
	
	private TreeAVL<Integer, String> tree;
	
	void stageOne() {
		tree = new TreeAVL<>();
	}

	@Test
	void testRotateRigth() throws ElementNoFoundException {
		stageOne();
		
		tree.add(8, "mateo");
		tree.add(4, "camilo");
		tree.add(2, "daniel");
		tree.add(5, "lili");
		tree.add(1, "majo");
		tree.add(0, "angie");
//		tree.add(6, "dany");
		
//		assertTrue(tree.search(8).calculateBalanceFactor()== -2);
//		assertTrue(tree.search(4).calculateBalanceFactor() == 0);
//		assertTrue(tree.search(2).calculateBalanceFactor() == 0);
//		assertTrue(tree.search(5).calculateBalanceFactor() == 0);
//		tree.rigthRotate(tree.search(8));
//		System.out.println(tree.search(8).calculateBalanceFactor());
		System.out.println(tree.search(8).getKey());
		assertTrue(tree.search(8).calculateBalanceFactor() == -1);
		assertTrue(tree.search(4).calculateBalanceFactor() == 0);
//		System.out.println(tree.search(2).calculateBalanceFactor());
		assertTrue(tree.search(2).calculateBalanceFactor() == 0);
		assertTrue(tree.search(5).calculateBalanceFactor() == 0);
		assertTrue(tree.search(1).calculateBalanceFactor() == 0);
		assertTrue(tree.search(0).calculateBalanceFactor() == 0);
//		assertTrue(tree.search(6).calculateBalanceFactor() == 0);

	}
	
//	@Test
//	void testRotateLeft() throws ElementNoFoundException{
//		stageOne();
//		tree.add(8, "mateo");
//		tree.add(12, "camilo");
//		tree.add(14, "daniel");
//		tree.add(11, "lili");
//		assertTrue(tree.search(8).calculateBalanceFactor() == 2);
//		assertTrue(tree.search(12).calculateBalanceFactor() == 0);
//		assertTrue(tree.search(14).calculateBalanceFactor() == 0);
//		assertTrue(tree.search(11).calculateBalanceFactor() == 0);
//		tree.leftRotate(tree.search(8));
//		assertTrue(tree.search(8).calculateBalanceFactor() == 1);
//		assertTrue(tree.search(12).calculateBalanceFactor() == -1);
//		assertTrue(tree.search(14).calculateBalanceFactor() == 0);
//		assertTrue(tree.search(11).calculateBalanceFactor() == 0);
//	}

}
