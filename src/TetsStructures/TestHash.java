package TetsStructures;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;
import Hash.Hash;
import Hash.HashIsEmptyException;
import Hash.NonexistentKeyException;

class TestHash {

	private Hash<Integer, String> hash; 
	
	private void stageOne() {
		hash = new Hash<Integer, String>();
		
	}	
	
	private void stageTwo()  {
		hash = new Hash<Integer, String>();
	
		for (int i = 0; i < 10; i++) {
			hash.put(i, "#"+i);
		}
	
		for (int i = 0; i < 10; i++) {
			hash.put(i, "#"+i+i);
		}
		
		
	
	}
	
	
	@Test
	void testOne() {
		stageOne();
		
		assertTrue(hash.getSize() == 0);
		assertTrue(hash.isEmpty());
		
		for (int i = 0; i < 10; i++) {
			hash.put(i, "#"+i);
		}
	
		assertTrue(hash.getSize() == 10);
		assertFalse(hash.isEmpty());
		
		assertTrue(hash.get(4).equals("#4"));
		
		assertTrue(hash.get(8).equals("#8"));
		
		for (int i = 0; i < 10; i++) {
			try {
				hash.remove(i);
			}catch (Exception e) {
				fail(" No debería pasar "); 
			}
				
		}
		
		assertTrue(hash.getSize() == 0);
		assertTrue(hash.isEmpty());
		
	}

	@Test
	void testTwo() {
		stageOne();
		
		try {
			hash.remove(0);
		} catch (HashIsEmptyException | NonexistentKeyException e1) {
			assertTrue(e1 instanceof HashIsEmptyException);
		}
		
		for (int i = 0; i < 10; i++) {
			hash.put(i, "#"+i);
		}
	
		try {
			hash.remove(12);
		} catch (HashIsEmptyException | NonexistentKeyException e2) {
			assertTrue(e2 instanceof NonexistentKeyException);
		}
		
		for (int i = 0; i < 10; i++) {
			try {
				hash.remove(i);
			}catch (Exception e) {
				fail(" No debería pasar "); 
			}
				
		}
		
		assertTrue(hash.getSize() == 0);
		assertTrue(hash.isEmpty());
		
	}

	@Test
	void testThree() {
		stageOne();
		
		for (int i = 0; i < 10; i++) {
			hash.put(i, "#"+i);
		}
		
		hash.put(0, "#77");
		
		assertTrue(hash.getObject(0).getPrevius().getValue().equals("#77"));

	}
	
	@Test
	void testFour() {
		stageTwo();
		
		for (int i = 0; i < 10; i++) {
			
				
			System.out.println(hash.getObject(i).getValue());	 
			
		}
		
		System.out.println(hash.getObject(0).getNext().getValue());
		
		for (int i = 0; i < 1 ; i++) {

			assertTrue(hash.getObject(i).getValue().equals("#"+i+i));

		}
		
		
		
	}
	
	
}
