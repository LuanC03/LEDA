package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T retorno = null;
		if (this.tail >= 0)
			retorno = array[0];
		return retorno;
	}

	private int getTail() {
		return this.tail;
	}

	private void setTail(int op) {
		if (op == 1)
			this.tail += 1;
		else
			this.tail -= 1;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if (getTail() == -1)
			retorno = true;
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if (getTail() + 1 >= array.length)
			retorno = true;
		return retorno;
	}

	private void shiftLeft() {
		for (int i = 0; i < getTail(); i++) {
			array[i] = array[i + 1];
		}
		setTail(2);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();
		else {
			setTail(1);
			array[getTail()] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T retorno = null;
		if(isEmpty())
			throw new QueueUnderflowException();
		else {
			retorno = head();
			shiftLeft();
		}
		return retorno;
	}

}
