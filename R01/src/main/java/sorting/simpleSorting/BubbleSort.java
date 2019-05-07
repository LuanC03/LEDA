package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/*
	 * Recebe array delimitado por um indice a esquerda(leftIndex) 
	 * e por um a direita(rightIndex), assumindo apenas esta porcao como a que sera
	 * ordenada. Aqui uma implementacao simples de bubblesort na qual parte do comeco
	 * da porcao a ser ordenada ate o penultimo elemento dela, a cada iteracao do for interior
	 * parte do final a ser ordenado do array ate o indice atual do for exterior, com o decorrer
	 * da execucao do algoritimo fazendo "flutuar" do menor para o maior os numeros para o comeco
	 * do array. Uso de uma flag para se ao final de toda uma iteracao de trocas nenhuma haver,
	 * quer dizer que o array ja esta ordenado, melhorando o tempo de execucao do bubble no melhor caso.
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
		boolean swapped = true;
		int i = leftIndex;
		while (swapped && i < rightIndex) {
			swapped = false;
			for (int j = rightIndex; j > i; j--) {
				if (array[j-1].compareTo(array[j]) > 0) {
					Util.swap(array, j-1, j);
					swapped = true;
				}
			}
			i++;
		}
	}
}