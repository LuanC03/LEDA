package adt.rbtree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.rbtree.RBNode.Colour;

public class TestRB {
	
	public RBTreeImpl<Integer> myRB;

	@Before
	public void initialize() {
		myRB = new RBTreeImpl<Integer>();
	}

	@Test
	public void test() {
		Integer[] preOrd = new Integer[] { 6, 1, 100};
		
		myRB.insert(1);
		myRB.insert(100);
		myRB.insert(6);
		
		assertArrayEquals(preOrd, myRB.preOrder());
		
		RBNode<Integer>[] myPre = myRB.rbPreOrder();
		
		Colour[] coresPreOrd = {Colour.BLACK, Colour.RED, Colour.RED};
		
		for(int i = 0; i < myPre.length; i ++) {
			assertTrue(myPre[i].getColour() == coresPreOrd[i]);
		}
		
	}
	
	@Test
	public void test1() {
		
		myRB.insert(1);
		myRB.insert(100);
		myRB.insert(6);

		
		myRB.insert(9);
		
		Colour[] coresPreOrd = {Colour.BLACK, Colour.BLACK, Colour.BLACK, Colour.RED};
		
		Integer[] preOrd = new Integer[] { 6,1, 100, 9};
		
		RBNode<Integer>[] myPre = myRB.rbPreOrder();
		for(int i = 0; i < myPre.length; i ++) {
			assertTrue(myPre[i].getColour() == coresPreOrd[i]);
			assertEquals(preOrd[i], myPre[i].getData());
		}
		
		assertTrue(myRB.verifyProperties());
	}
	
	@Test
	public void test2() {

		myRB.insert(1);
		myRB.insert(100);
		myRB.insert(6);
		myRB.insert(9);
		myRB.insert(75);
		
		Integer[] preOrd = new Integer[] { 6,1, 75, 9, 100};
		
		RBNode<Integer>[] myPre = myRB.rbPreOrder();
		
		Colour[] coresPreOrd = {Colour.BLACK, Colour.BLACK, Colour.BLACK, Colour.RED, Colour.RED};
		
		
		for(int i = 0; i < myPre.length; i ++) {
			assertTrue(myPre[i].getColour() == coresPreOrd[i]);
			assertEquals(preOrd[i], myPre[i].getData());
		}
		
		assertTrue(myRB.verifyProperties());
	}
	
	@Test
	public void test3() {
		
		myRB.insert(1);
		myRB.insert(100);
		myRB.insert(6);
		myRB.insert(9);
		myRB.insert(75);
		myRB.insert(33);
		
		Integer[] preOrd = new Integer[] { 6,1, 75, 9,33, 100};
		
		RBNode<Integer>[] myPre = myRB.rbPreOrder();
		
		Colour[] coresPreOrd = {Colour.BLACK, Colour.BLACK, 
				Colour.RED, Colour.BLACK, Colour.RED, Colour.BLACK};
		
		for(int i = 0; i < myPre.length; i ++) {
			assertTrue(myPre[i].getColour() == coresPreOrd[i]);
			assertEquals(preOrd[i], myPre[i].getData());
		}
		
		assertTrue(myRB.verifyProperties());
	}
	
	@Test
	public void test4() {
		
		myRB.insert(1);
		myRB.insert(100);
		myRB.insert(6);
		myRB.insert(9);
		myRB.insert(75);
		myRB.insert(33);
		myRB.insert(50);
		
		Integer[] preOrd = new Integer[] { 6,1, 75, 33, 9, 50, 100};
		
		RBNode<Integer>[] myPre = myRB.rbPreOrder();
		
		Colour[] coresPreOrd = {Colour.BLACK, Colour.BLACK, Colour.RED,
				Colour.BLACK, Colour.RED, Colour.RED, Colour.BLACK};
		for(int i = 0; i < myPre.length; i ++) {
			assertTrue(myPre[i].getColour() == coresPreOrd[i]);
			assertEquals(preOrd[i], myPre[i].getData());
		}
		
		assertTrue(myRB.verifyProperties());
		
	}
	
	@Test
	public void test5() {
		
		myRB.insert(1);
		myRB.insert(100);
		myRB.insert(6);
		myRB.insert(9);
		myRB.insert(75);
		myRB.insert(33);
		myRB.insert(50);
		myRB.insert(28);
		
		RBNode<Integer>[] myPre = myRB.rbPreOrder();
		
		Integer[] preOrd = new Integer[] {33, 6, 1, 9, 28, 75, 50, 100 };
		assertArrayEquals(preOrd, myRB.preOrder());
		
		Colour[] coresPreOrd = {Colour.BLACK, Colour.RED, Colour.BLACK, 
				Colour.BLACK, Colour.RED, Colour.RED, Colour.BLACK, Colour.BLACK};
		for(int i = 0; i < myPre.length; i ++) {
			assertTrue(myPre[i].getColour() == coresPreOrd[i]);
			assertEquals(preOrd[i], myPre[i].getData());
		}
		
		assertTrue(myRB.verifyProperties());
		
		myRB.insert(85);
		myRB.insert(39);
	}
}