package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T retorno = null;
		if(getTop() >= 0)
			retorno = array[getTop()];
		return retorno;
	}

	private int getTop() {		
		return this.top;
	}
	
	private void setTop(int operacao) {
		if(operacao == 1)
			this.top = getTop() + 1;
		else
			this.top = getTop() - 1;
	}

	@Override
	public boolean isEmpty() {
		boolean retorno = false;
		if(getTop() == -1)
			retorno = true;
		return retorno;
	}

	@Override
	public boolean isFull() {
		boolean retorno = false;
		if(getTop()+1 >= array.length)
			retorno = true;
		return retorno;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull())
			throw new StackOverflowException();
		else {
			setTop(1);
			array[getTop()] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T retorno = null;
		if(isEmpty())
			throw new StackUnderflowException();
		else {
			retorno =  top();
			setTop(2);
		}
		return retorno;
	}

}
