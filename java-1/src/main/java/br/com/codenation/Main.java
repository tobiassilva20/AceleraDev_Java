package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DesafioMeuTimeApplication d = new DesafioMeuTimeApplication();
        d.incluirTime(1L, "Sampaio", LocalDate.parse("2000-01-20"), "Branco", "Preto");
        d.incluirTime(2L, "Sampaio", LocalDate.parse("2000-01-20"), "Branco", "Preto");
        d.incluirJogador(1L, 1L, "Tobias", LocalDate.parse("1984-11-02"), 1, BigDecimal.valueOf(1000));
        d.incluirJogador(2L, 1L, "Tobias2", LocalDate.parse("1984-11-02"), 2, BigDecimal.valueOf(9000));
        d.incluirJogador(3L, 1L, "Tobias3", LocalDate.parse("1984-11-02"), 10, BigDecimal.valueOf(8000));
        d.definirCapitao(1L);
        //System.out.println(d.buscarCapitaoDoTime(1L));
        //System.out.println(d.buscarNomeJogador(2L));
        //System.out.println(d.buscarNomeTime(1L));
        //System.out.println(d.buscarMelhorJogadorDoTime(1L));
        //System.out.println(d.buscarJogadorMaiorSalario(1l));
    }
}
