package TetsStructures;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Queue.Queue;

class TestQueue {

	private Queue<Integer> queue; 
	
	private void stageOne() {
		queue = new Queue<Integer>(); 
	} 
	
	
	@Test
	void testAdded() {
		stageOne(); 
		
		assertTrue(queue.getSize() == 0);
		assertTrue(queue.isEmpty());
		
		queue.enQueue(19);
		queue.enQueue(37);
		queue.enQueue(24);
		queue.enQueue(51);
		queue.enQueue(75);
				
		assertFalse(queue.isEmpty()); 
		
		assertTrue( queue.getFront().getValue() == 19 );
		queue.deQueue();
		assertTrue( queue.getFront().getValue() == 37 );
		queue.deQueue();
		assertTrue( queue.getFront().getValue() == 24 );
		queue.deQueue();
		assertTrue( queue.getFront().getValue() == 51 );
		queue.deQueue();
		assertTrue( queue.getFront().getValue() == 75 );
		queue.deQueue();
		
		assertTrue(queue.isEmpty());	
		assertTrue(queue.getSize() == 0);
		
	}
	
	
	

}
