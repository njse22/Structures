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
	private Hash<Character, String> hash1; 
	private Hash<Integer, Integer> hash2;
	
	private void setUpStageOne() {
		hash = new Hash<Integer, String>(); 
		for (int i = 0; i < 10; i++) {
			hash.put(i, "#"+i);
		}		
	}
	
	private void setUpstageTwo() {
		hash1 = new Hash<Character, String>(); 
		
		for (char i = 0; i < 10; i++) {
			hash1.put(i, "#"+i);
		}
		
	}
	
	private void setUpStageThree() {
		hash2 = new Hash<Integer, Integer>(); 
		for (int i = 0; i < 10; i++) {
			hash2.put(i, i*i);
		}
		
	}
	
	private void setUpStageFour() {
		hash = new Hash<Integer, String>(); 
	}
	
	@Test
	void testOne() {
		setUpStageOne();
		assertTrue(hash.getSize() == 10);
		for (int i = 0; i < hash.getSize(); i++) {
			assertTrue(hash.get(11).equals("#"+i) );
		}
	}
	
	@Test
	void testTwo() {
		setUpstageTwo();
		assertTrue(hash1.getSize() == 10);
		for (char i = 0; i < hash1.getSize(); i++) {
			assertTrue(hash1.get(i).equals("#"+i) );
		}
		
	}
	
	@Test
	void testThree() {
		setUpStageThree();
		assertTrue(hash2.getSize() == 10);
		for (int i = 0; i < hash2.getSize(); i++) {
			assertTrue(hash2.get(i).equals(i*i) );
		}
		
	}
	
	@Test
	void testFour() {
		setUpStageOne();
		
		try {
			for (int i = 0; i < hash.getSize(); i++) {
				hash.remove(i);	
				assertTrue(hash.getSize() == 0);
				
			}
			
		} catch (HashIsEmptyException | NonexistentKeyException e) {
			
			fail("Error en la prueba"); 
		}

	}
	
	@Test
	void testFive() {
		setUpStageOne();
		System.out.println(hash.getSize());
		assertTrue(hash.getSize() == 10);
		
	}
	
	
	
	
	
	
}