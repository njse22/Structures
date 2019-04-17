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
	
	
	@Test
	void test() {
		setUpStageOne();
		
		NodeBlackRed<String, Integer> a = new NodeBlackRed<String, Integer>("a", 10); 
		NodeBlackRed<String, Integer> b = new NodeBlackRed<String, Integer>("b", 3);
		NodeBlackRed<String, Integer> c = new NodeBlackRed<String, Integer>("c", 12);
		NodeBlackRed<String, Integer> d = new NodeBlackRed<String, Integer>("d", 6);
		NodeBlackRed<String, Integer> e = new NodeBlackRed<String, Integer>("e", 20);
		NodeBlackRed<String, Integer> f = new NodeBlackRed<String, Integer>("f", 7);
		
		tree.add(a);
		assertTrue( a.getColor() == 0 );
		tree.add(b);
		assertTrue( b.getColor() == 1 );
		tree.add(c);
		assertTrue( c.getColor() == 1 );
		tree.add(d);
		assertTrue( a.getColor() == 0 );
		assertTrue( b.getColor() == 0 );
		assertTrue( c.getColor() == 0 );
		assertTrue( d.getColor() == 1 );
		tree.add(e);
		
		assertTrue( a.getColor() == 0 );
		assertTrue( b.getColor() == 0 );
		assertTrue( c.getColor() == 0 );
		assertTrue( d.getColor() == 1 );
		assertTrue( e.getColor() == 1 );
		
		tree.add(f);
		
		assertTrue( a.getColor() == 0 );
		assertTrue( b.getColor() == 1 );
		assertTrue( c.getColor() == 0 );
		assertTrue( d.getColor() == 0 );
		assertTrue( e.getColor() == 1 );
		assertTrue( f.getColor() == 1 );
		
		assertTrue(a.getLeft().getKey() == 6);
		
		
		
		
		
		
	}

}
