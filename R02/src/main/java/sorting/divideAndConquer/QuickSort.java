package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    if (leftIndex < rightIndex) {
	        int pivot = partition(array, leftIndex, rightIndex-1, rightIndex);
	        sort(array, leftIndex, pivot-1);
	        sort(array, pivot+1, rightIndex);
	    }
	}
	
	private int partition(T[] array, int lhand, int rhand, int rightIndex) {
	    if(lhand < rhand) {
	        if (array[lhand].compareTo(array[rightIndex]) <= 0) {
	            return partition(array, lhand+1, rhand, rightIndex);
	        }
	        if (array[rhand].compareTo(array[rightIndex]) >= 0) {
	            return partition(array, lhand, rhand-1, rightIndex);
	        }
	        Util.swap(array, lhand, rhand);
	        return partition(array, lhand+1, rhand-1, rightIndex);
	    }
	    if (array[rhand].compareTo(array[rightIndex]) >= 0) {
	        Util.swap(array, rhand, rightIndex);
	        return rhand;
	    }
	    Util.swap(array, rhand+1, rightIndex);
	    return rhand+1;
	}
}