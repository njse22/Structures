package TetsStructures;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import AVLTree.AVLTree;
import AVLTree.NodeAVL;



class TestAVLTree {
	
	private AVLTree<String,Integer> tree; 
	
	void setUpStageOne() {
		tree = new AVLTree<String, Integer>(); 
	}
	
	
	@Test
	void test() {
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
		
		System.out.println(tree.getRoot().getKey());
		System.out.println(tree.getRoot().getRight().getKey());
		System.out.println(tree.getRoot().getLeft().getKey());
		
		System.out.println(tree.getRoot().getRight().getRight().getKey());
		
		System.out.println(tree.getRoot().getLeft().getLeft().getKey());
		System.out.println(tree.getRoot().getLeft().getRight().getKey());
		
		assertTrue(tree.getRoot().getLeft().getKey() == 5);
		assertTrue(tree.getRoot().getRight().getKey() == 19);
		assertTrue(tree.getRoot().getRight().getRight().getKey() == 20);
		assertTrue(tree.getRoot().getRight().getLeft().getKey() == 15);
		
		
	}

}
