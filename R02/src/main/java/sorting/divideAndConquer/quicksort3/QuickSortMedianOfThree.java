package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte: 1. Comparar o elemento mais a
 * esquerda, o central e o mais a direita do intervalo. 2. Ordenar os elemento,
 * tal que: A[left] < A[center] < A[right]. 3. Adotar o A[center] como pivô. 4.
 * Colocar o pivô na penúltima posição A[right-1]. 5. Aplicar o particionamento
 * considerando o vetor menor, de A[left+1] até A[right-1]. 6. Aplicar o
 * algoritmo na metade a esquerda e na metade a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	    if (leftIndex < rightIndex) {
	    	medOf(array, leftIndex, rightIndex);
	        int pivot = partition(array, leftIndex, rightIndex-1, rightIndex);
	        sort(array, leftIndex, pivot-1);
	        sort(array, pivot+1, rightIndex);
	    }
	}
	
	private void medOf(T[] array, int leftIndex, int rightIndex) {
	    int mid = (leftIndex+rightIndex)/2;

	    if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
	        Util.swap(array, leftIndex, rightIndex);
	    }

	    if (array[rightIndex].compareTo(array[mid]) > 0) {
	        Util.swap(array, rightIndex, mid);

	        if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
	            Util.swap(array, leftIndex, rightIndex);
	        }
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