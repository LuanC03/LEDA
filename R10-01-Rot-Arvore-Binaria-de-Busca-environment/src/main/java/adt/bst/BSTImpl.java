package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;
	protected BSTNode<T> NIL = new BSTNode<T>();

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(getRoot());
	}

	protected int height(BSTNode<T> node) {
		int returnHeight = -1;
		if (!node.isEmpty()) {
			returnHeight = 1
					+ Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight()));
		}
		return returnHeight;
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, getRoot());
	}

	protected BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> retorno = NIL;

		if (element != null && !node.isEmpty()) {

			if (element.compareTo(node.getData()) == 0)
				retorno = node;
			else {
				if (element.compareTo(node.getData()) > 0)
					retorno = search(element, (BSTNode<T>) node.getRight());
				else
					retorno = search(element, (BSTNode<T>) node.getLeft());
			}
		}
		return retorno;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			insertElement(element, getRoot());
		}
	}

	protected void insertElement(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			if (node.getParent() == null)
				node.setParent(new BSTNode<T>());
			node.getRight().setParent(node);
			node.getLeft().setParent(node);
		}

		else {

			if (element.compareTo(node.getData()) > 0)
				insertElement(element, (BSTNode<T>) node.getRight());
			else if (element.compareTo(node.getData()) < 0)
				insertElement(element, (BSTNode<T>) node.getLeft());
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> retorno = null;
		if (!isEmpty())
			retorno = maximum(getRoot());

		return retorno;
	}

	protected BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> retorno = null;

		if (node.getRight().isEmpty())
			retorno = node;
		else
			retorno = maximum((BSTNode<T>) node.getRight());

		return retorno;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> retorno = null;
		if (!isEmpty())
			retorno = minimum(getRoot());
		return retorno;
	}	

	protected BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> retorno = null;

		if (!node.getLeft().isEmpty())
			retorno = minimum((BSTNode<T>) node.getLeft());
		else
			retorno = node;	

		return retorno;
	}
	
	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) {
			return null;
		}
		if (!node.getRight().isEmpty()) {
			return minimum((BSTNode<T>) node.getRight());
		} else {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			while (!parent.isEmpty() && node.equals(parent.getRight())) {
				node = parent;
				parent = (BSTNode<T>) node.getParent();
			}
			if (parent.isEmpty()) {
				return null;
			}
			return parent;
		}
	}


	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) {
			return null;
		}
		if (!node.getLeft().isEmpty()) {
			return maximum((BSTNode<T>) node.getLeft());
		} else {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			while (!parent.isEmpty() && node.equals(parent.getLeft())) {
				node = parent;
				parent = (BSTNode<T>) node.getParent();
			}
			if (parent.isEmpty()) {
				return null;
			}
			return parent;
		}
	}


	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) 
			return;
		remove(node);
	}

	private void remove(BSTNode<T> node) {
		if (node.isEmpty()) 
			return;
		if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
			BSTNode<T> newNode = sucessor(node.getData());
			node.setData(newNode.getData());
			remove(newNode);
		}
		else {
			BSTNode<T> newNode = (BSTNode<T>) node.getLeft();
			
			if (newNode.isEmpty())
				newNode = (BSTNode<T>) node.getRight();
			
			node.setData(newNode.getData());
			node.setRight(newNode.getRight());
			node.setLeft(newNode.getLeft());
			
			if (!node.isEmpty() && node.getRight() != null) 
				node.getRight().setParent(node);
			if (!node.isEmpty() && node.getLeft() != null) 
				node.getLeft().setParent(node);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		T[] preOrd = (T[]) new Comparable[this.size()];
		if (this.isEmpty())
			return preOrd;
		preOrder(preOrd, root, 0);
		return preOrd;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected int preOrder(T[] preOrd, BSTNode<T> node, int index) {
		preOrd[index++] = node.getData();

		if (!node.getLeft().isEmpty())
			index = preOrder(preOrd, (BSTNode) node.getLeft(), index);

		if (!node.getRight().isEmpty())
			index = preOrder(preOrd, (BSTNode) node.getRight(), index);

		return index;
	}


	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		T[] inOrd = (T[]) new Comparable[this.size()];
		if (this.isEmpty())
			return inOrd;
		order(inOrd, root, 0);
		return inOrd;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private int order(T[] inOrd, BSTNode<T> node, int index) {
		if (!node.getLeft().isEmpty()) 
			index = order(inOrd,(BSTNode) node.getLeft(), index);
		
		inOrd[index++] = node.getData();
		
		if (!node.getRight().isEmpty()) 
			index = order(inOrd,(BSTNode) node.getRight(), index);
		return index;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		T[] posOrd  = (T[]) new Comparable[this.size()];
		if (this.isEmpty()) 
			return posOrd;
		postOrder(posOrd, root, 0);
		return posOrd;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private int postOrder(T[] posOrd, BSTNode<T> node, int index) {
		if (!node.getLeft().isEmpty()) 
			index = postOrder(posOrd,(BSTNode) node.getLeft(), index);
		
		if (!node.getRight().isEmpty()) 
			index = postOrder(posOrd,(BSTNode) node.getRight(), index);
		
		posOrd[index++] = node.getData();
		return index;
	}

	public String toString(String ordenacao){
		if(ordenacao.equalsIgnoreCase("PreOrder"))
			return toString(preOrder());
		else if(ordenacao.equalsIgnoreCase("Order"))
			return toString(order());
		else if(ordenacao.equalsIgnoreCase("PostOrder"))
			return toString(postOrder());
		else
			return "Ordenacao Invalida";
	}
	
	private String toString(T[] colecao) {
		String retorno = "";
		for (T elemento : colecao) {
			retorno = elemento + " ";
		}
		return retorno;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		if (!node.isEmpty()) {
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
