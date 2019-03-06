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
	private Hash<Integer, String> hash1; 
	private Hash<Integer, String> hash2; 
	
	private void stageOne() {
		hash = new Hash<Integer, String>();
		for (int i = 0; i < 10; i++) {
			hash.put(i, "#"+i);
		}
	}	
	
	
	@Test
	void testStageOne()
	{
		stageOne();
		assertTrue(hash.getSize() == 10);
		assertFalse(hash.isEmpty());
	}
	
	
	private void stageTwo()
	{
		hash1 = new Hash<Integer, String>();
		for (int i = 0; i < 10; i++) {
			hash1.put(i, "#"+i);
		}
		
		for (int i = 0; i < 10; i++) {
			
				try {
					hash1.remove(i);
				} catch (HashIsEmptyException | NonexistentKeyException e) {
					
					e.printStackTrace();
				}
		
		}
		
	}
	
	@Test
	void testStageTwo()
	{
		stageTwo();
		assertTrue(hash1.getSize() == 0);
		assertTrue(hash1.isEmpty());
	}
	
	
	private void stageThree()
	{
		hash2 = new Hash<Integer, String>();
		
		for (int i = 0; i < 10; i++) {
			hash1.put(i, "#"+i);
		}
	}
//	@Test
//	void testOne() {
//		stageOne();
//		
//		assertTrue(hash.getSize() == 0);
//		assertTrue(hash.isEmpty());
//	
//		assertTrue(hash.getSize() == 10);
//		assertFalse(hash.isEmpty());
//		
//		assertTrue(hash.get(4).equals("#4"));
//		
//		assertTrue(hash.get(8).equals("#8"));
//		
//		for (int i = 0; i < 10; i++) {
//			try {
//				hash.remove(i);
//			}catch (Exception e) {
//				fail(" No debería pasar "); 
//			}
//				
//		}
//		
//		assertTrue(hash.getSize() == 0);
//		assertTrue(hash.isEmpty());
//		
//	}
	
	private void stageEmty() {
		hash = new Hash<Integer, String>();
	}
	
	
	@Test
	void testEmpty() {
		stageEmty();
		assertTrue(hash.getSize() == 0);
		assertTrue(hash.isEmpty());
	}
	
	


//	@Test
//	void testTwo() {
//		stageOne();
//		
//		try {
//			hash.remove(0);
//		} catch (HashIsEmptyException | NonexistentKeyException e1) {
//			assertTrue(e1 instanceof HashIsEmptyException);
//		}
//		
//		for (int i = 0; i < 10; i++) {
//			hash.put(i, "#"+i);
//		}
//	
//		try {
//			hash.remove(12);
//		} catch (HashIsEmptyException | NonexistentKeyException e2) {
//			assertTrue(e2 instanceof NonexistentKeyException);
//		}
//		
//		for (int i = 0; i < 10; i++) {
//			try {
//				hash.remove(i);
//			}catch (Exception e) {
//				fail(" No debería pasar "); 
//			}
//				
//		}
//		
//		assertTrue(hash.getSize() == 0);
//		assertTrue(hash.isEmpty());
//		
//	}

	@Test
	void testThree() {
		stageOne();
		
		for (int i = 0; i < 10; i++) {
			hash.put(i, "#"+i);
		}
		
		hash.put(0, "#77");
		
		

	}
	
	@Test
	void testFour() {
		stageOne();
		
		for (int i = 0; i < 10; i++) {
			try {
				hash.put(i, "#"+i);
				hash.put(i ,"#"+i+i); 
				hash.remove(i);
				
				
			} catch (HashIsEmptyException | NonexistentKeyException e) {}
			
		}
		
		for (int i = hash.getSize(); i >= hash.getSize() ; i--) {

			assertTrue(hash.getObject(i).getValue().equals("#"+i+i));

		}
		
		
		
	}
	
	
}
