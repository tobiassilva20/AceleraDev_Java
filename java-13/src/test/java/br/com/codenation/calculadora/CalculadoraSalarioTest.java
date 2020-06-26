package br.com.codenation.calculadora;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CalculadoraSalarioTest {

	@Test
	public void salarioLiquidoIsNotNull() {
		assertNotNull(new CalculadoraSalario().calcularSalarioLiquido(1000.0));
	}

	@Test
	public void calcularValorLiquidoDe1500(){
		double salarioLiquido = new CalculadoraSalario().calcularSalarioLiquido(1500);
		assertEquals(1380, salarioLiquido, 0);
	}
}