package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DesafioMeuTimeApplication d = new DesafioMeuTimeApplication();
        d.incluirTime(10l, "Sampaio", LocalDate.parse("2000-01-20"), "Branco", "Preto");
        d.incluirJogador(1l, 10l, "Tobias", LocalDate.parse("1984-11-02"), 100, BigDecimal.valueOf(1000));
        d.incluirJogador(2l, 10l, "Tobias2", LocalDate.parse("1984-11-02"), 100, BigDecimal.valueOf(1000));
        d.definirCapitao(2L);
        System.out.println(d.buscarCapitaoDoTime(10l));
        d.definirCapitao(1l);
        System.out.println(d.buscarCapitaoDoTime(10l));

    }
}
