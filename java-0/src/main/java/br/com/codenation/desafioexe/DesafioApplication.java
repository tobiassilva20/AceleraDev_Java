package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> fibonacciSequence = new ArrayList<>();
		int itemZero = 0, itemOne = 1;
		fibonacciSequence.add(itemZero);
		fibonacciSequence.add(itemOne);

		while (itemOne < 377){
			itemOne = itemOne + itemZero;
			itemZero = itemOne - itemZero;
			fibonacciSequence.add(itemOne);
		}
		return fibonacciSequence;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}