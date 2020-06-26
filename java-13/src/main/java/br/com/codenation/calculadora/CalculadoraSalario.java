package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if (salarioBase < 1039){
			return 0L;
		}else{
			salarioBase = calcularInss(salarioBase);
			double salarioLiquido = calcularImposto(salarioBase);
			return Math.round(salarioLiquido);
		}
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {

		/*
		 *
		 * Faixa salarial					Percentual de desconto
		 * Até R$ 1.500,00	 				8%
		 * De R$ 1.500,01 até R$ 4.000,00	9%
		 * Acima de R$ 4.000,00				11%
		 */

		if(salarioBase <= 1500){
			return salarioBase - salarioBase * 0.08;

		}else if(salarioBase <= 4000){
			return salarioBase - salarioBase * 0.09;

		}else{
			return salarioBase - salarioBase * 0.11;
		}
	}
	private double calcularImposto(double salarioDescontadoInss){

		/*
		 * Faixa salarial					Percentual de desconto
		 * Até R$ 3.000,00					ISENTO
		 * De R$ 3.000,01 até R$ 6.000,00	7.5%
		 * Acima de R$ 6.000,00				15%
		 */

		if(salarioDescontadoInss <= 3000){
			return salarioDescontadoInss;
		}else if (salarioDescontadoInss <= 6000 ){
			return salarioDescontadoInss - salarioDescontadoInss * 0.075;
		}else{
			return salarioDescontadoInss - salarioDescontadoInss * 0.15;
		}
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/