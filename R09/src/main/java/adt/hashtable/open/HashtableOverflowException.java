package adt.hashtable.open;

public class HashtableOverflowException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public HashtableOverflowException() {
		super("Hashtable overflow!");
	}

}
