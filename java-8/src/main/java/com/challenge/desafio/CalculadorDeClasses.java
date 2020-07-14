package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {


    @Override
    public BigDecimal somar(Object object) {
        return calcularAtributos(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return calcularAtributos(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }

    public BigDecimal calcularAtributos(Object object, Class<? extends Annotation> annotation){
        BigDecimal soma = BigDecimal.ZERO;

        for (Field atributo : object.getClass().getDeclaredFields()){
            if(atributo.isAnnotationPresent(annotation) && atributo.getType() == BigDecimal.class){

                try {
                    atributo.setAccessible(true);
                    BigDecimal valorAtributo = new BigDecimal(String.valueOf(atributo.get(object)));
                    soma = soma.add(valorAtributo);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
            }
        }
        return soma;
    }
}
