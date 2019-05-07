package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int i = leftIndex;
		while (i <= rightIndex) {
			if (i == leftIndex || array[i].compareTo(array[i-1]) >= 0) {
				i++;
			}
			else {
				Util.swap(array, i, i-1);
				i--;
			}
		}
	}
}