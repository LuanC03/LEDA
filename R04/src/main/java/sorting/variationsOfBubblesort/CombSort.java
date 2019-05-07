package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && leftIndex < rightIndex && leftIndex >= 0 && rightIndex - leftIndex >= 1
	            && rightIndex < array.length) {

			int gap =  rightIndex - leftIndex;
			final double fator = 1.25;
			boolean sorted = false;

			while (sorted == false) {
				gap = (int) Math.floor(gap/fator);
				
				if (gap > 1) {
					sorted = false;
				}
				else {
					gap = 1;
					sorted = true;
				}
				
				int i = leftIndex;
				while (i + gap <= rightIndex) {
					if (array[i].compareTo(array[i+gap]) > 0) {
						Util.swap(array, i, i+gap);
						sorted = false;
					}
					i++;
				}
			}
		}
	}
}