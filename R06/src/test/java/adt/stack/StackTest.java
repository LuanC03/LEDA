package adt.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void test() throws StackOverflowException, StackUnderflowException {
		Stack<Integer> stack = new StackDoubleLinkedListImpl<>(3);
		
		assertTrue(stack.isEmpty());
		stack.push(new Integer(5));
		assertFalse(stack.isEmpty());
		stack.push(new Integer(2));
		stack.push(new Integer(0));
		assertTrue(stack.isFull());
		assertEquals(new Integer(0), stack.top());
		assertEquals(new Integer(0), stack.pop());
		assertFalse(stack.isFull());
		stack.push(null);
		assertFalse(stack.isFull());
		
		assertEquals(new Integer(2), stack.top());
		assertEquals(new Integer(2), stack.pop());
		
		assertEquals(new Integer(5), stack.top());
		assertEquals(new Integer(5), stack.pop());
		assertTrue(stack.top() == null);
		
		
		stack.push(new Integer(15));
		stack.push(new Integer(10));
		stack.push(new Integer(9));
		
		try {
			stack.push(new Integer(199));
			fail();
		}catch(StackOverflowException e) {
			assertEquals("Stack is full", e.getMessage());
		}
		
		stack.pop();
		stack.pop();
		stack.pop();
		
		try {
			stack.pop();
			fail();
		}catch(StackUnderflowException e) {
			assertEquals("Stack is empty", e.getMessage());
		}
	}
}