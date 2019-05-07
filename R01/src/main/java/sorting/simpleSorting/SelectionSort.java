package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/*
	 * Recebe array delimitado por um indice a esquerda(leftIndex) 
	 * e por um a direita(rightIndex), assumindo apenas esta porcao como a que sera
	 * ordenada. Aqui uma implementacao simples de selectionsort na qual varre o array
	 * a cada vez procurando o menor elemento, excluindo o menor elemento anterior visto
	 * que cada iteracao de busca de novo menor elemento parte da posicao adjacente(a direita)
	 * ao menor elemento anterior. A cada novo menor elemento o posiciona no indice atual do
	 * contador i do for, na qual sera desconsiderado nas proximas iteracoes, ate que o ultimo menor
	 * elemento(o maior no caso) esteja posicionado no ultimo indice.
	 */
	/**
	 * Ordena uma porcao definida de um array, podendo compreender todo o array
	 * caso seja passado como argumentos 0 e array.length-1 como segundo e terceiro
	 * argumentos respectivamente.
	 * 
	 * @param array			array de tipo generico no qual as operacoes de ordenacao serao realizadas
	 * @param leftIndex		indice na qual delimita o comeco da porcao a ser ordenada
	 * @param rightIndex	indice na qual delimita o final da porcao a ser ordenada
	 * 
	 * @author 				Gabriel Fernandes
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i < rightIndex; i++) {
			int minElemIndex = i;
			for (int j = i; j <= rightIndex; j++) {
				if (array[minElemIndex].compareTo(array[j]) > 0) {
					minElemIndex = j;
				}
			}
			Util.swap(array, i, minElemIndex);
		}
	}
}