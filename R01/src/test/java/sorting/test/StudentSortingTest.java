package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.variationsOfInsertionsort.RecursiveInsertionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	
	private Integer[] vetorSingleElem;
	private Integer[] vetorDoubleElem;
	private String[] vetorStrings;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		populaVetorSingleElem(new Integer[] {67});
		populaVetorDoubleElem(new Integer[] {-8, -15});
		populaVetorStrings(new String[] {"Chorong", "Bomi", "Naeun", "Hayoung", 
											"Eunji", "Namjoo"});
		
		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new RecursiveInsertionSort<>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	private void populaVetorSingleElem(Integer[] arrayPadrao) {
		this.vetorSingleElem = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}
	
	private void populaVetorDoubleElem(Integer[] arrayPadrao) {
		this.vetorDoubleElem = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}
	
	private void populaVetorStrings(String[] arrayPadrao) {
		this.vetorStrings = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = Arrays.copyOf(array, array.length);
		System.out.println(Arrays.toString(array));
		implementation.sort(array);
		Arrays.sort(copy1);
		System.out.println(Arrays.toString(array));
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}
	
	@Test
	public void testSort06() {
		genericTest(vetorSingleElem);
	}
	
	@Test
	public void testSort07() {
		genericTest(vetorDoubleElem);
	}
	
	@Test
	public void testSort08() {
		AbstractSorting<String> implementation2;
		implementation2 = new RecursiveInsertionSort<>();
		String[] copy1 = Arrays.copyOf(vetorStrings, vetorStrings.length);
		
		System.out.println(Arrays.toString(vetorStrings));
		implementation2.sort(vetorStrings);
		Arrays.sort(copy1);
		System.out.println(Arrays.toString(vetorStrings));
		
		Assert.assertArrayEquals(copy1, vetorStrings);
	}
	
	@Test
	public void testSort09() {
		AbstractSorting<String> implementation2;
		implementation2 = new RecursiveInsertionSort<>();
		String[] copy1 = {"Chorong", "Bomi", "Eunji", "Hayoung", "Naeun", "Namjoo"};

		System.out.println(Arrays.toString(vetorStrings));
		implementation2.sort(vetorStrings, 2, 4);
		System.out.println(Arrays.toString(vetorStrings));

		Assert.assertArrayEquals(copy1, vetorStrings);
	}
	
	@Test
	public void testSort10() {
		AbstractSorting<Integer> implementation2;
		implementation2 = new RecursiveInsertionSort<>();
		Integer[] arrayInt = {7, 6, 5, 4, 3, 2, 1};
		Integer[] result = {7, 2, 3, 4, 5, 6, 1};

		System.out.println(Arrays.toString(arrayInt));
		implementation2.sort(arrayInt, 1, 5);
		System.out.println(Arrays.toString(arrayInt));
		
		Assert.assertArrayEquals(result, arrayInt);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}