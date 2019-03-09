package TetsStructures;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import Hash.Hash;
import Hash.HashIsEmptyException;
import Hash.HashNode;
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
	
	private void setUpStageFour1() {
		hash1 = new Hash<Character, String>(); 
	}
	
	private void setUpStageFour2() {
		hash2 = new Hash<Integer, Integer>(); 
	}
	
	private void setUpsetageFive() {
		hash = new Hash<Integer, String>(); 

		hash.put(0, "teachers");
		hash.put(0, "let");
		hash.put(0, "the");
		hash.put(9, "kids");
		hash.put(5, "alone");
	}
	
	private void setUpsetageFive1() {
		hash1 = new Hash<Character, String>(); 

		hash1.put('a', "teachers");
		hash1.put('a', "let");
		hash1.put('a', "the");
		hash1.put('c', "kids");
		hash1.put('f', "alone");
	}

	private void setUpsetageFive2() {
		hash2 = new Hash<Integer, Integer>(); 

		hash2.put(0, 0);
		hash2.put(0, 1);
		hash2.put(0, 2);
		hash2.put(9, 3);
		hash2.put(5, 4);
	}

	
	
	@Test
	void testOne() {
		setUpStageOne();
		assertTrue(hash.getSize() == 10);
		for (int i = 0; i < hash.getSize(); i++) {
			assertTrue(hash.get(i).equals("#"+i) );
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
			for (int i = 0; i < 10; i++) {
				hash.remove(i);	
				
			}
			
			assertTrue(hash.getSize() == 0);
			
		} catch (HashIsEmptyException | NonexistentKeyException e) {
			
			fail("Error en la prueba"); 
		}

	}


	@Test
	void testFour1() {
		setUpstageTwo();
		
		try {
			for (char i = 0; i < 10; i++) {
				hash1.remove(i);	
				
			}
			
			assertTrue(hash1.getSize() == 0);
			
		} catch (HashIsEmptyException | NonexistentKeyException e) {
			
			fail("Error en la prueba"); 
		}

	}

	@Test
	void testFour2() {
		setUpStageThree();
		
		try {
			for (int i = 0; i < 10; i++) {
				hash2.remove(i);	
				
			}
			
			assertTrue(hash2.getSize() == 0);
			
		} catch (HashIsEmptyException | NonexistentKeyException e) {
			
			fail("Error en la prueba"); 
		}

	}

	
	@Test
	void testFive() {
		setUpStageFour();
		assertTrue(hash.getSize() == 0);
		
	}
	
	@Test
	void testFive1() {
		setUpStageFour1();
		assertTrue(hash1.getSize() == 0);
		
	}
	
	@Test
	void testFive2() {
		setUpStageFour2();
		assertTrue(hash2.getSize() == 0);
		
	}
	
	
	
	
	@Test
	void testSix() {
		setUpsetageFive();
			try {
				
				assertTrue(hash.getObjet(0, "teachers").getValue().equals("teachers"));
				assertTrue(hash.getObjet(0, "let").getValue().equals("let"));
				assertTrue(hash.getObjet(0, "the").getValue().equals("the"));
				assertTrue(hash.getObjet(9, "kids").getValue().equals("kids"));
				assertTrue(hash.getObjet(5, "alone").getValue().equals("alone"));
				
			} catch (NonexistentKeyException e) {
				fail("NonexistentKeyException .... !!"); 
			}
		
		
	}
	
	@Test
	void testSix1() {
		setUpsetageFive1();
			try {
				
				assertTrue(hash1.getObjet('a', "teachers").getValue().equals("teachers"));
				assertTrue(hash1.getObjet('a', "let").getValue().equals("let"));
				assertTrue(hash1.getObjet('a', "the").getValue().equals("the"));
				assertTrue(hash1.getObjet('c', "kids").getValue().equals("kids"));
				assertTrue(hash1.getObjet('f', "alone").getValue().equals("alone"));
				
			} catch (NonexistentKeyException e) {
				fail("NonexistentKeyException .... !!"); 
			}
		
		
	}
	
	@Test
	void testSix2() {
		setUpsetageFive2();
			try {
				
				assertTrue(hash2.getObjet(0,0).getValue().equals(0));
				assertTrue(hash2.getObjet(0, 1).getValue().equals(1));
				assertTrue(hash2.getObjet(0, 2).getValue().equals(2));
				assertTrue(hash2.getObjet(9, 3).getValue().equals(3));
				assertTrue(hash2.getObjet(5, 4).getValue().equals(4));
				
			} catch (NonexistentKeyException e) {
				fail("NonexistentKeyException .... !!"); 
			}
		
		
	}
	
	
	
	
	@Test
	void testSeven() {
		setUpsetageFive();
		try {

			hash.remove(0);
			
			assertNull(hash.getObjet(0, "teachers").getNext().getNext()); 
			
			hash.remove(0);
			
			assertNull(hash.getObjet(0, "teachers").getNext());
			
		}catch (HashIsEmptyException | NonexistentKeyException e) {
			fail("the test has been fail....");
		}	
		
	}

	@Test
	void testSeven1() {
		setUpsetageFive1();
		try {

			hash1.remove('a');
			
			assertNull(hash1.getObjet('a', "teachers").getNext().getNext()); 
			
			hash1.remove('a');
			
			assertNull(hash1.getObjet('a', "teachers").getNext());
			
		}catch (HashIsEmptyException | NonexistentKeyException e) {
			fail("the test has been fail....");
		}	
		
	}

	@Test
	void testSeven2() {
		setUpsetageFive2();
		try {

			hash2.remove(0);
			
			assertNull(hash2.getObjet(0, 0).getNext().getNext()); 
			
			hash2.remove(0);
			
			assertNull(hash2.getObjet(0, 0).getNext());
			
		}catch (HashIsEmptyException | NonexistentKeyException e) {
			fail("the test has been fail....");
		}	
		
	}

	
	
	@Test
	void tetsEight() {
		setUpsetageFive();
		try {
			hash.remove(5);
			
		} catch (HashIsEmptyException | NonexistentKeyException e) {
			
			assertTrue(e instanceof NonexistentKeyException);	
		}
		
	}
	
	@Test
	void testNine() {
		setUpStageFour(); 
		
		try {
			hash.remove(0);
		} catch (HashIsEmptyException | NonexistentKeyException e) {
			
			assertTrue(e instanceof HashIsEmptyException );
		}

	}
	
	
	
	
	
	
	
}