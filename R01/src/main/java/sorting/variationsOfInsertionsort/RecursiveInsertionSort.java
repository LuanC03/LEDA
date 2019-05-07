package sorting.variationsOfInsertionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveInsertionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementacaoo RECURSIVA do insertion sort. Para isso, tente definir o 
	 * caso base do algoritmo e depois o caso recursivo, que reduz o problema 
	 * para uma entrada menor em uma chamada recursiva. Seu algoritmo deve 
	 * ter complexidade quadratica O(n^2).
	 * 
	 * Restrições:
	 *  - voce nao pode utilizar arry auxiliar
	 *  - voce pode utilizar variaveis temporarias
	 *  - voce nao pode declarar novos atributos na classe
	 *  - para as trocas no array, utilize o metodo Util.swap
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		this.sort(array, leftIndex, 0, rightIndex);
	}

	/*
	 * Uso de metodo auxiliar recursivo para permitir o redimensionamento do array entre
	 * porcao ordenada e nao ordenada, delimitando aonde o ultimo o ultimo elemento adcionado
	 * na parte ordenada esta, permitindo a cada passo recursivo ter um array desordenado menor
	 * e um array ordenado maior.
	 */
	/**
	 * Ordena uma porcao definida de um array, podendo compreender todo o array
	 * caso seja passado como argumentos 0 e array.length-1 como segundo e terceiro
	 * argumentos respectivamente.
	 * 
	 * @param array				array de tipo generico no qual as operacoes de ordenacao serao realizadas
	 * @param leftIndex			indice na qual delimita o comeco da porcao a ser ordenada
	 * @param insertionPointer	indice na qual divide a porcao ordenada da a ser ordenada no insertitionsort
	 * @param rightIndex		indice na qual delimita o final da porcao a ser ordenada
	 * 
	 * @author 				Gabriel Fernandes
	 */
	private void sort(T[] array, int leftIndex, int insertionPointer, int rightIndex) {
		if (insertionPointer < rightIndex) {
			if (array[insertionPointer].compareTo(array[insertionPointer+1]) > 0) {
				this.orderedInsertion(array, leftIndex, insertionPointer);
			}
			this.sort(array, leftIndex, insertionPointer+1, rightIndex);
		}
	}

	/*
	 * Responsavel pelos rearranjos de posicao ao encontrar um elemento menor do que o ultimo
	 * atual da porcao ordenada, agindo assim como o outro metodo, tambem recursivamente, alem de ir de acordo
	 * com as recomendacoes do professor adalberto de nao ter return em metodo void.
	 */
	private void orderedInsertion(T[] array, int leftIndex, int insertionPointer) {
		if (leftIndex <= insertionPointer) {
			if (array[insertionPointer].compareTo(array[insertionPointer+1]) > 0) {
				Util.swap(array, insertionPointer, insertionPointer+1);
				this.orderedInsertion(array, leftIndex, insertionPointer-1);
			}
		}
	}
}