package br.com.codenation;

public class StatisticUtil {

	public static int average(int[] elements) {
		int media = 0;
		for(int i = 0; i < elements.length; i++){
			media += elements[i];
		}
		return media/elements.length;
	}

	public static int mode(int[] elements) {

		int[][] elementos  = new int[elements.length][2];
		int moda = 0;
		for (int i=0; i<elements.length; i++){
			elementos[i][0] = elements[i];
		}
		for(int j = 0; j < elementos.length; j++){
			for (int k=0; k < elementos.length; k++){
				if(elementos[j][0] == elements[k]){
					elementos[j][1] ++;
				}
			}
		}
		for(int l=0; l < elementos.length; l++){
			if(elementos[l][1] > moda)
				moda = l;
		}
		return elementos[moda][0];
	}

	public static int median(int[] elements) {

		int auxiliar = 0;
		for(int i=0; i < elements.length; i++){
			for (int j=0; j < elements.length - 1; j++){
				if(elements[i] < elements [j]){
					auxiliar = elements[j];
					elements[j] = elements[i];
					elements[i] = auxiliar;
				}
			}
		}
		int median = 0;
		if(elements.length % 2 == 0){
			median = (elements[elements.length/2 - 1] + elements[elements.length/2])/2;
		}else{
			median = elements[elements.length/2];
		}
		return median;

	}
}