package adt.bst;

public class main {

	public static void main(String[] args) {
		BSTImpl<Integer> bst = new BSTImpl<Integer>();
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			bst.insert(i);
		}
		System.out.println(bst.sucessor(-34));
		System.out.println(bst.predecessor(0));
	}

}
