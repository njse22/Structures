package TetsStructures;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import AVLTree.AVLTree;
import AVLTree.NodeAVL;

class TestAVLTree {
	
	private AVLTree<String,Integer> tree; 
	
	void setUpStageOne() {
		tree = new AVLTree<String, Integer>(); 
	}
	
	
	@Test
	void testOne() {
		setUpStageOne();

		NodeAVL<String,Integer> newElement = new NodeAVL<String,Integer>("a",10); 
		NodeAVL<String,Integer> a = new NodeAVL<String,Integer>("b",3);
		NodeAVL<String,Integer> b = new NodeAVL<String,Integer>("c",20);
		NodeAVL<String,Integer> c = new NodeAVL<String,Integer>("d",6);
		NodeAVL<String,Integer> d = new NodeAVL<String,Integer>("e",15);		
		NodeAVL<String,Integer> e = new NodeAVL<String,Integer>("d",5);
		NodeAVL<String,Integer> f = new NodeAVL<String,Integer>("f",19);
		
		tree.add(newElement);		
		tree.add(a);
		tree.add(b);
		tree.add(c);
		tree.add(d);
		tree.add(e);
		tree.add(f);
		
		assertTrue(tree.getRoot().getKey() == 10);
		assertTrue(tree.getRoot().getLeft().getKey() == 5);
		assertTrue(tree.getRoot().getRight().getKey() == 19);
		assertTrue(tree.getRoot().getRight().getRight().getKey() == 20);
		assertTrue(tree.getRoot().getRight().getLeft().getKey() == 15);
		assertTrue(tree.getRoot().getLeft().getRight().getKey() == 6);
		assertTrue(tree.getRoot().getLeft().getLeft().getKey() == 3);
		
		/*
		 * 			10						
		 * 		   /   \				  
		 * 		  5     19          
		 * 		 / \    / \            
		 *      3   6  15  20       
		 *      
		 * */
		
		tree.printNode(tree.getRoot());
		
		
	}
	

	@Test
	void testTwo() {
		setUpStageOne();

		NodeAVL<String,Integer> newElement = new NodeAVL<String,Integer>("a",10); 
		NodeAVL<String,Integer> a = new NodeAVL<String,Integer>("b",3);
		NodeAVL<String,Integer> b = new NodeAVL<String,Integer>("c",20);
		NodeAVL<String,Integer> c = new NodeAVL<String,Integer>("d",6);
		NodeAVL<String,Integer> d = new NodeAVL<String,Integer>("e",15);		
		NodeAVL<String,Integer> e = new NodeAVL<String,Integer>("d",5);
		NodeAVL<String,Integer> f = new NodeAVL<String,Integer>("f",19);
		
		tree.add(newElement);		
		tree.add(a);
		tree.add(b);
		tree.add(c);
		tree.add(d);
		tree.add(e);
		tree.add(f);
		
		tree.remove(15);
		
		assertTrue(tree.getRoot().getKey() == 10);
		assertTrue(tree.getRoot().getLeft().getKey() == 5);
		assertTrue(tree.getRoot().getRight().getKey() == 19);
		assertTrue(tree.getRoot().getRight().getRight().getKey() == 20);
		assertTrue(tree.getRoot().getRight().getLeft() == null);
		assertTrue(tree.getRoot().getLeft().getRight().getKey() == 6);
		assertTrue(tree.getRoot().getLeft().getLeft().getKey() == 3);
		
	}

	@Test
	void testThree() {
		setUpStageOne();

		NodeAVL<String,Integer> newElement = new NodeAVL<String,Integer>("a",10); 
		NodeAVL<String,Integer> a = new NodeAVL<String,Integer>("b",3);
		NodeAVL<String,Integer> b = new NodeAVL<String,Integer>("c",20);
		NodeAVL<String,Integer> c = new NodeAVL<String,Integer>("d",6);
		NodeAVL<String,Integer> d = new NodeAVL<String,Integer>("e",15);		
		NodeAVL<String,Integer> e = new NodeAVL<String,Integer>("d",5);
		NodeAVL<String,Integer> f = new NodeAVL<String,Integer>("f",19);
		
		tree.add(newElement);		
		tree.add(a);
		tree.add(b);
		tree.add(c);
		tree.add(d);
		tree.add(e);
		tree.add(f);
		
		tree.remove(19);
		
		assertTrue(tree.getRoot().getKey() == 10);
		assertTrue(tree.getRoot().getLeft().getKey() == 5);
		assertTrue(tree.getRoot().getRight().getKey() == 15);
		assertTrue(tree.getRoot().getRight().getRight().getKey() == 20);
		assertTrue(tree.getRoot().getRight().getLeft() == null);
		assertTrue(tree.getRoot().getLeft().getRight().getKey() == 6);
		assertTrue(tree.getRoot().getLeft().getLeft().getKey() == 3);
		
		
		/*
		 * 			10						10
		 * 		   /   \				   /  \
		 * 		  5     19     -->        5    15
		 * 		 / \    / \              / \     \
		 *      3   6  15  20           3   6     20
		 *      
		 * */
		
		
	}
	
	@Test
	void testFour() {
		setUpStageOne();

		NodeAVL<String,Integer> newElement = new NodeAVL<String,Integer>("a",10); 
		NodeAVL<String,Integer> a = new NodeAVL<String,Integer>("b",3);
		NodeAVL<String,Integer> b = new NodeAVL<String,Integer>("c",20);
		NodeAVL<String,Integer> c = new NodeAVL<String,Integer>("d",6);
		NodeAVL<String,Integer> d = new NodeAVL<String,Integer>("e",15);		
		NodeAVL<String,Integer> e = new NodeAVL<String,Integer>("d",5);
		NodeAVL<String,Integer> f = new NodeAVL<String,Integer>("f",19);
		
		tree.add(newElement);		
		tree.add(a);
		tree.add(b);
		tree.add(c);
		tree.add(d);
		tree.add(e);
		tree.add(f);
		
		tree.remove(19);
		tree.remove(15);
		
		assertTrue(tree.getRoot().getKey() == 10);
		assertTrue(tree.getRoot().getLeft().getKey() == 5);
		assertTrue(tree.getRoot().getRight().getKey() == 20);
		assertTrue(tree.getRoot().getRight().getRight() == null);
		assertTrue(tree.getRoot().getRight().getLeft() == null);
		assertTrue(tree.getRoot().getLeft().getRight().getKey() == 6);
		assertTrue(tree.getRoot().getLeft().getLeft().getKey() == 3);
		
		
		/*
		 * 			10						10                  10
		 * 		   /   \				   /  \                /  \
		 * 		  5     19     -->        5    15      -->    5    20
		 * 		 / \    / \              / \     \           / \
		 *      3   6  15  20           3   6     20        3   6
		 *      
		 * */
		
		
	}


	@Test
	void testFive() {
		setUpStageOne();

		NodeAVL<String,Integer> newElement = new NodeAVL<String,Integer>("a",10); 
		NodeAVL<String,Integer> a = new NodeAVL<String,Integer>("b",3);
		NodeAVL<String,Integer> b = new NodeAVL<String,Integer>("c",12);
		NodeAVL<String,Integer> c = new NodeAVL<String,Integer>("d",6);
		NodeAVL<String,Integer> d = new NodeAVL<String,Integer>("e",20);		
		NodeAVL<String,Integer> e = new NodeAVL<String,Integer>("d",7);
//		NodeAVL<String,Integer> f = new NodeAVL<String,Integer>("f",11);
		
		tree.add(newElement);		
		tree.add(a);
		tree.add(b);
		tree.add(c);
		tree.add(d);
		tree.add(e);
//		tree.add(f);
		
		assertTrue(tree.getRoot().getKey() == 10);
		assertTrue(tree.getRoot().getLeft().getKey() == 6);
		assertTrue(tree.getRoot().getRight().getKey() == 12);
		assertTrue(tree.getRoot().getRight().getRight().getKey() == 20);
//		assertTrue(tree.getRoot().getRight().getLeft().getKey() == 15);
		assertTrue(tree.getRoot().getLeft().getRight().getKey() == 7);
		
		assertTrue(tree.getRoot().getLeft().getLeft().getKey() == 3);
		
	}
	
	@Test
	void testSix() {
		setUpStageOne();

		NodeAVL<String,Integer> newElement = new NodeAVL<String,Integer>("a",10); 
		NodeAVL<String,Integer> a = new NodeAVL<String,Integer>("b",3);
		NodeAVL<String,Integer> b = new NodeAVL<String,Integer>("c",20);
		NodeAVL<String,Integer> c = new NodeAVL<String,Integer>("d",6);
		NodeAVL<String,Integer> d = new NodeAVL<String,Integer>("e",15);		
		NodeAVL<String,Integer> e = new NodeAVL<String,Integer>("d",5);
		NodeAVL<String,Integer> f = new NodeAVL<String,Integer>("f",19);
		
		tree.add(newElement);		
		tree.add(a);
		tree.add(b);
		tree.add(c);
		tree.add(d);
		tree.add(e);
		tree.add(f);
		
		tree.remove(19);
		tree.remove(15);
		tree.remove(10);
		
		assertTrue(tree.getRoot().getKey() == 6);
		assertTrue(tree.getRoot().getLeft().getKey() == 5);
		assertTrue(tree.getRoot().getRight().getKey() == 20);
		assertTrue(tree.getRoot().getRight().getRight() == null);
		assertTrue(tree.getRoot().getRight().getLeft() == null);
		assertTrue(tree.getRoot().getLeft().getRight() == null);
		assertTrue(tree.getRoot().getLeft().getLeft().getKey() == 3);
		
		
		/*
		 * 			10						10                  10                 6
		 * 		   /   \				   /  \                /  \               / \
		 * 		  5     19     -->        5    15      -->    5    20   -->      5   20
		 * 		 / \    / \              / \     \           / \                /
		 *      3   6  15  20           3   6     20        3   6              3
		 *      
		 * */
		
//		tree.printNode(tree.getRoot());
	}
	
	
}
