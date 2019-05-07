package adt.linkedList;

import java.util.Arrays;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;
	
	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if (this.data == null) {
			empty = true;
		}
		return empty;
	}

	@Override
	public int size() {
		int result = 0;
		if (!this.isEmpty()) {
			result = 1 + this.next.size();
		}
		return result;
	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null) {
			if (!this.isEmpty()) {
				if (this.data.equals(element)) {
					result = this.data;
				}
				else {
					result = this.next.search(element);
				}
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<>();
			}
			else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				if (this.data.equals(element)) {
					this.data = this.getNext().getData();
					if (!this.next.isEmpty()) {
						this.next = this.getNext().getNext();
					}
				} 
				else {
					this.next.remove(element);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] result = null;
		if (!this.isEmpty()) {
			result = (T[]) new Object[1];
			result[0] = this.data;
			result = this.juntaArrays(result, this.next.toArray());
		}
		if (result == null) {
			result = (T[]) new Object[0];
		}
		return result;
	}

	public T[] juntaArrays(T[] first, T[] second) {
		  T[] result = Arrays.copyOf(first, first.length + second.length);
		  System.arraycopy(second, 0, result, first.length, second.length);
		  return result;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}