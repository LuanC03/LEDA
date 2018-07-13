package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if ((this.tail + 1) % array.length == this.head)
			throw new QueueOverflowException();
		else {
			if(this.head==-1)
				this.head = 0;
			this.tail = (this.tail+1)%array.length;
			array[this.tail] = element;
			elements ++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T retorno = null;
		if((this.head+1)%array.length == this.head)
			throw new QueueUnderflowException();
		else {
			this.head = (this.head+1)%array.length;
			retorno = array[head];
			elements --;
		}			
		return retorno;
	}

	@Override
	public T head() {
		T retorno = null;
		if(this.head >= 0)
			retorno = array[this.head];
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if((this.head+1)%array.length == this.tail)
			retorno = true;
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if((this.tail+1)%array.length == this.head)
			retorno = true;
		return retorno;
	}

}
