package br.com.codenation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {
    Long id;
    String nome;
    LocalDate dataCriacao;
    String corUniformePrincipal;
    String corUniformeSecundario;
    Long capitao;
    List<Jogador> jogadores;

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
        this.jogadores = new ArrayList<>();
    }
}
