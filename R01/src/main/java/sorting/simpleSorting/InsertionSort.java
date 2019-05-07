package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/*
	 * Recebe array delimitado por um indice a esquerda(leftIndex) 
	 * e por um a direita(rightIndex), assumindo apenas esta porcao como a que sera
	 * ordenada. Aqui uma implementacao simples do insertionsort na qual a partir do primeiro
	 * elemento da particao do array na qual deseja-se particionar ate o penultimo elemento desta realiza
	 * comparacoes com o proximo elemento(i+1 em nosso algoritimo) iniciando um processo de trocas
	 * consecutivas ate que este elemento outrora no indice i+1 esteja "inserido"(dai o nome do algoritimo)
	 * em sua posicao correta. Parto do principio que o elemento da posicao indice i eh o ultimo elemento
	 * de um array interno ja ordenado, e a cada iteracao o elemento do indice i+1 eh um candidato a ser
	 * rearranjado neste array ja ordenado caso este elemento seja menor que o de indice i, caso contrario
	 * ele assumi a ultima posicao do array ordenado interno, por este ser o maior ate o dado momento.	 
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
			int insertionPointer = i;
			while (insertionPointer >= leftIndex && array[insertionPointer].compareTo(array[insertionPointer+1]) > 0) {
				Util.swap(array, insertionPointer, insertionPointer+1);
				insertionPointer--;
			}
		}
	}
}