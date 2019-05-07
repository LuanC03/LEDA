package adt.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test
	public void test() throws QueueOverflowException, QueueUnderflowException {
		
		Queue<Integer> queue = new QueueDoubleLinkedListImpl<>(3);

		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
		queue.enqueue(new Integer(10));
		assertFalse(queue.isEmpty());
		queue.enqueue(new Integer(15));
		queue.enqueue(new Integer(19));
		assertTrue(queue.isFull());
		
		assertEquals(new Integer(10), queue.dequeue());
		queue.enqueue(new Integer(20));
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertTrue(queue.isEmpty());
		
		queue.enqueue(new Integer(21));
		queue.enqueue(new Integer(25));
		queue.enqueue(new Integer(18));
		assertTrue(queue.isFull());
		assertFalse(queue.isEmpty());
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertTrue(queue.isEmpty());
		
		assertEquals(null, queue.head());
		assertFalse(queue.isFull());
		assertTrue(queue.isEmpty());
		queue.enqueue(null);
		assertFalse(queue.isFull());
		assertTrue(queue.isEmpty());
		
		queue.enqueue(new Integer(3));
		queue.enqueue(new Integer(5));
		queue.enqueue(new Integer(7));
		
		assertEquals(new Integer(3), queue.head());
		queue.dequeue();
		assertEquals(new Integer(5), queue.head());
		queue.dequeue();
		assertEquals(new Integer(7), queue.head());
		queue.dequeue();
		
		assertEquals(null, queue.head());
		
		queue.enqueue(new Integer(3));
		queue.enqueue(new Integer(5));
		queue.enqueue(new Integer(7));
		
		try {
			queue.enqueue(new Integer(9));
			fail();
		}catch(QueueOverflowException e) {
			assertEquals("Fila cheia", e.getMessage());
		}
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		try {
			queue.dequeue();
			fail();
		}catch(QueueUnderflowException e) {
			assertEquals("Fila vazia", e.getMessage());
		}	
	}
}