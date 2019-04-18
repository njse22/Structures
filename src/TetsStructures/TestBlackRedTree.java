package TetsStructures;

import BlackRedTree.BlackRedTree;
import BlackRedTree.NodeBlackRed;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestBlackRedTree {

	private BlackRedTree<String, Integer> tree; 
	
	void setUpStageOne() {
		tree = new BlackRedTree<String, Integer>(); 
	}
	
//	
//	@Test
//	void testOne() {
//		setUpStageOne();
//		
//		NodeBlackRed<String, Integer> a = new NodeBlackRed<String, Integer>("a", 10); 
//		NodeBlackRed<String, Integer> b = new NodeBlackRed<String, Integer>("b", 3);
//		NodeBlackRed<String, Integer> c = new NodeBlackRed<String, Integer>("c", 12);
//		NodeBlackRed<String, Integer> d = new NodeBlackRed<String, Integer>("d", 6);
//		NodeBlackRed<String, Integer> e = new NodeBlackRed<String, Integer>("e", 20);
//		NodeBlackRed<String, Integer> f = new NodeBlackRed<String, Integer>("f", 7);
//		
//		tree.add(a);
//		assertTrue( a.getColor() == 0 );
//		tree.add(b);
//		assertTrue( b.getColor() == 1 );
//		tree.add(c);
//		assertTrue( c.getColor() == 1 );
//		tree.add(d);
//		assertTrue( a.getColor() == 0 );
//		assertTrue( b.getColor() == 0 );
//		assertTrue( c.getColor() == 0 );
//		assertTrue( d.getColor() == 1 );
//		tree.add(e);
//		
//		assertTrue( a.getColor() == 0 );
//		assertTrue( b.getColor() == 0 );
//		assertTrue( c.getColor() == 0 );
//		assertTrue( d.getColor() == 1 );
//		assertTrue( e.getColor() == 1 );
//		
//		tree.add(f);
//		
//		assertTrue( a.getColor() == 0 );
//		assertTrue( b.getColor() == 1 );
//		assertTrue( c.getColor() == 0 );
//		assertTrue( d.getColor() == 0 );
//		assertTrue( e.getColor() == 1 );
//		assertTrue( f.getColor() == 1 );	
//		
//		assertTrue(a.getLeft().getKey() == 6);
//		
//	}
//
//	@Test
//	void testTwo() {
//		setUpStageOne();
//		
//		NodeBlackRed<String, Integer> a = new NodeBlackRed<String, Integer>("a", 10); 
//		NodeBlackRed<String, Integer> b = new NodeBlackRed<String, Integer>("b", 3);
//		NodeBlackRed<String, Integer> c = new NodeBlackRed<String, Integer>("c", 12);
//		NodeBlackRed<String, Integer> d = new NodeBlackRed<String, Integer>("d", 6);
//		NodeBlackRed<String, Integer> e = new NodeBlackRed<String, Integer>("e", 20);
//		NodeBlackRed<String, Integer> f = new NodeBlackRed<String, Integer>("f", 5);
//		
//		tree.add(a);
//		assertTrue( a.getColor() == 0 );
//		tree.add(b);
//		assertTrue( b.getColor() == 1 );
//		tree.add(c);
//		assertTrue( c.getColor() == 1 );
//		tree.add(d);
//		assertTrue( a.getColor() == 0 );
//		assertTrue( b.getColor() == 0 );
//		assertTrue( c.getColor() == 0 );
//		assertTrue( d.getColor() == 1 );
//		tree.add(e);
//		
//		assertTrue( a.getColor() == 0 );
//		assertTrue( b.getColor() == 0 );
//		assertTrue( c.getColor() == 0 );
//		assertTrue( d.getColor() == 1 );
//		assertTrue( e.getColor() == 1 );
//		
//		tree.add(f);
//		
//		assertTrue( a.getColor() == 0 );//10
//		assertTrue( b.getColor() == 1 );//3
//		assertTrue( c.getColor() == 0 );//12
//		assertTrue( d.getColor() == 1 );//6
//		assertTrue( e.getColor() == 1 );//20
//		assertTrue( f.getColor() == 0 );//5
//		
//		assertTrue(a.getLeft().getKey() == 5);
//		
//	}
//
//	@Test
//	void testThree() {
//		setUpStageOne();
//		
//		NodeBlackRed<String, Integer> a = new NodeBlackRed<String, Integer>("a", 10); 
//		NodeBlackRed<String, Integer> b = new NodeBlackRed<String, Integer>("b", 3);
//		NodeBlackRed<String, Integer> c = new NodeBlackRed<String, Integer>("c", 12);
//		NodeBlackRed<String, Integer> d = new NodeBlackRed<String, Integer>("d", 6);
//		NodeBlackRed<String, Integer> e = new NodeBlackRed<String, Integer>("e", 20);
//		NodeBlackRed<String, Integer> f = new NodeBlackRed<String, Integer>("f", 5);
//		NodeBlackRed<String, Integer> g = new NodeBlackRed<String, Integer>("f", 22);
//		
//		tree.add(a);
//		assertTrue( a.getColor() == 0 );
//		tree.add(b);
//		assertTrue( b.getColor() == 1 );
//		tree.add(c);
//		assertTrue( c.getColor() == 1 );
//		tree.add(d);
//		assertTrue( a.getColor() == 0 );
//		assertTrue( b.getColor() == 0 );
//		assertTrue( c.getColor() == 0 );
//		assertTrue( d.getColor() == 1 );
//		tree.add(e);
//		
//		assertTrue( a.getColor() == 0 );
//		assertTrue( b.getColor() == 0 );
//		assertTrue( c.getColor() == 0 );
//		assertTrue( d.getColor() == 1 );
//		assertTrue( e.getColor() == 1 );
//		
//		tree.add(f);
//		
//		assertTrue( a.getColor() == 0 );//10
//		assertTrue( b.getColor() == 1 );//3
//		assertTrue( c.getColor() == 0 );//12
//		assertTrue( d.getColor() == 1 );//6
//		assertTrue( e.getColor() == 1 );//20
//		assertTrue( f.getColor() == 0 );//5
//		
//		tree.add(g);
//		assertTrue( a.getColor() == 0 );//10
//		assertTrue( b.getColor() == 1 );//3
//		assertTrue( c.getColor() == 1 );//12
//		assertTrue( d.getColor() == 1 );//6
//		assertTrue( e.getColor() == 0 );//20
//		assertTrue( f.getColor() == 0 );//5
//		assertTrue( g.getColor() == 1 );//22
//		
//		assertTrue(a.getRight().getKey() == 20);
//		
//	}
//	
//	@Test
//	void testFour() {
//		setUpStageOne();
//		
//		NodeBlackRed<String, Integer> a = new NodeBlackRed<String, Integer>("a", 10); 
//		NodeBlackRed<String, Integer> b = new NodeBlackRed<String, Integer>("b", 3);
//		NodeBlackRed<String, Integer> c = new NodeBlackRed<String, Integer>("c", 12);
//		NodeBlackRed<String, Integer> d = new NodeBlackRed<String, Integer>("d", 6);
//		NodeBlackRed<String, Integer> e = new NodeBlackRed<String, Integer>("e", 20);
//		NodeBlackRed<String, Integer> f = new NodeBlackRed<String, Integer>("f", 5);
//		NodeBlackRed<String, Integer> g = new NodeBlackRed<String, Integer>("g", 19);
//		
//		tree.add(a);
//		assertTrue( a.getColor() == 0 );
//		tree.add(b);
//		assertTrue( b.getColor() == 1 );
//		tree.add(c);
//		assertTrue( c.getColor() == 1 );
//		tree.add(d);
//		assertTrue( a.getColor() == 0 );
//		assertTrue( b.getColor() == 0 );
//		assertTrue( c.getColor() == 0 );
//		assertTrue( d.getColor() == 1 );
//		tree.add(e);
//		
//		assertTrue( a.getColor() == 0 );
//		assertTrue( b.getColor() == 0 );
//		assertTrue( c.getColor() == 0 );
//		assertTrue( d.getColor() == 1 );
//		assertTrue( e.getColor() == 1 );
//		
//		tree.add(f);
//		
//		assertTrue( a.getColor() == 0 );//10
//		assertTrue( b.getColor() == 1 );//3
//		assertTrue( c.getColor() == 0 );//12
//		assertTrue( d.getColor() == 1 );//6
//		assertTrue( e.getColor() == 1 );//20
//		assertTrue( f.getColor() == 0 );//5
//		
//		tree.add(g);
//		assertTrue( a.getColor() == 0 );//10
//		assertTrue( b.getColor() == 1 );//3
//		assertTrue( c.getColor() == 1 );//12
//		assertTrue( d.getColor() == 1 );//6
//		assertTrue( e.getColor() == 1 );//20
//		assertTrue( f.getColor() == 0 );//5
//		assertTrue( g.getColor() == 0 );//19
//		
//		assertTrue(a.getRight().getKey() == 19);
//		
//	}
//
//	@Test
//	void testFive() {
//		setUpStageOne();
//		
//		NodeBlackRed<String, Integer> a = new NodeBlackRed<String, Integer>("a", 1); 
//		NodeBlackRed<String, Integer> b = new NodeBlackRed<String, Integer>("b", 2);
//		NodeBlackRed<String, Integer> c = new NodeBlackRed<String, Integer>("c", 3);
//		NodeBlackRed<String, Integer> d = new NodeBlackRed<String, Integer>("d", 4);
//		NodeBlackRed<String, Integer> e = new NodeBlackRed<String, Integer>("e", 5);
//		NodeBlackRed<String, Integer> f = new NodeBlackRed<String, Integer>("f", 6);
//		NodeBlackRed<String, Integer> g = new NodeBlackRed<String, Integer>("f", 7);
//		NodeBlackRed<String, Integer> h = new NodeBlackRed<String, Integer>("f", 8);
//		NodeBlackRed<String, Integer> i = new NodeBlackRed<String, Integer>("f", 9);
//		NodeBlackRed<String, Integer> j = new NodeBlackRed<String, Integer>("f", 10);
//		NodeBlackRed<String, Integer> k = new NodeBlackRed<String, Integer>("f", 11);
//		NodeBlackRed<String, Integer> l = new NodeBlackRed<String, Integer>("f", 12);
//		NodeBlackRed<String, Integer> m = new NodeBlackRed<String, Integer>("f", 13);
//		NodeBlackRed<String, Integer> n = new NodeBlackRed<String, Integer>("f", 14);
//		NodeBlackRed<String, Integer> o = new NodeBlackRed<String, Integer>("f", 15);
//		NodeBlackRed<String, Integer> p = new NodeBlackRed<String, Integer>("f", 16);
//		NodeBlackRed<String, Integer> q = new NodeBlackRed<String, Integer>("f", 17);
//		NodeBlackRed<String, Integer> r = new NodeBlackRed<String, Integer>("f", 18);
//		
//		tree.add(a);
//		tree.add(b);
//		tree.add(c);
//		tree.add(d);
//		tree.add(e);		
//		tree.add(f);
//		tree.add(g);
//		tree.add(h);
//		tree.add(i);
//		tree.add(j);
//		tree.add(k);
//		tree.add(l);
//		tree.add(m);
//		tree.add(n);
//		tree.add(o);
//		tree.add(p);
//		tree.add(q);
//		tree.add(r);
//
//		assertTrue(tree.getRoot().getKey() == 8);
//		assertTrue(tree.getRoot().getRight().getKey() == 12);
//		assertTrue(tree.getRoot().getLeft().getKey() == 4);
//		
//		assertTrue(tree.getRoot().getRight().getRight().getKey() == 14);
//		assertTrue(tree.getRoot().getRight().getRight().getRight().getKey() == 16);
//		assertTrue(tree.getRoot().getRight().getRight().getRight().getRight().getKey() == 17);
//		assertTrue(tree.getRoot().getRight().getRight().getRight().getRight().getRight().getKey() == 18);
//		
//		assertTrue(tree.getRoot().getRight().getRight().getRight().getLeft().getKey() == 15);
//		
//		assertTrue(tree.getRoot().getRight().getRight().getLeft().getKey() == 13);
//		
//		assertTrue(tree.getRoot().getRight().getLeft().getKey() == 10);
//		assertTrue(tree.getRoot().getRight().getLeft().getRight().getKey() == 11);
//		assertTrue(tree.getRoot().getRight().getLeft().getLeft().getKey() == 9);
//		
//		assertTrue(tree.getRoot().getLeft().getLeft().getKey() == 2);
//		assertTrue(tree.getRoot().getLeft().getLeft().getLeft().getKey() == 1);
//		assertTrue(tree.getRoot().getLeft().getLeft().getRight().getKey() == 3);
//		
//		assertTrue(tree.getRoot().getLeft().getRight().getKey() == 6);
//		assertTrue(tree.getRoot().getLeft().getRight().getRight().getKey() == 7);
//		assertTrue(tree.getRoot().getLeft().getRight().getLeft().getKey() == 5);
//		
//		
//	}
//	
	@Test
	void testSix() {
		setUpStageOne();
		
		NodeBlackRed<String, Integer> a = new NodeBlackRed<String, Integer>("a", 10); 
		NodeBlackRed<String, Integer> b = new NodeBlackRed<String, Integer>("b", 3);
		NodeBlackRed<String, Integer> c = new NodeBlackRed<String, Integer>("c", 12);
		NodeBlackRed<String, Integer> d = new NodeBlackRed<String, Integer>("d", 6);
		NodeBlackRed<String, Integer> e = new NodeBlackRed<String, Integer>("e", 20);
		NodeBlackRed<String, Integer> f = new NodeBlackRed<String, Integer>("f", 5);
		
		tree.add(a);
		tree.add(b);
		tree.add(c);
		tree.add(d);
		tree.add(e);
		tree.add(f);
		
		tree.remove(10);
		
		//se remplazo la raíz por el secesor 
		assertTrue(tree.getRoot().getLeft().getRight() == null);
		
		assertTrue(tree.getRoot().getKey() == 6);
		assertTrue(tree.getRoot().getColor() == NodeBlackRed.BLACK);
		
		assertTrue(tree.getRoot().getLeft().getKey() == 5); 
		assertTrue(tree.getRoot().getLeft().getColor() == NodeBlackRed.BLACK);
		assertTrue(tree.getRoot().getLeft().getLeft().getKey() == 3);
		assertTrue(tree.getRoot().getLeft().getLeft().getColor() == NodeBlackRed.RED);
		
		assertTrue(tree.getRoot().getRight().getKey() == 12);
		assertTrue(tree.getRoot().getRight().getColor() == NodeBlackRed.BLACK);
		assertTrue(tree.getRoot().getRight().getRight().getKey() == 20);
		assertTrue(tree.getRoot().getRight().getRight().getColor() == NodeBlackRed.RED);
		
		
		/*
		 *       10                  6
		 * 		/  \                / \
		 *     5    12     -->     5   12
		 * 	  / \     \           /     \
		 *   3  6     20         3       20
		 * 
		 * */
		
		
		
	}
	
	
	
	
}
