package br.com.codenation;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	List<Time> times = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario){

		boolean usado = times.stream().anyMatch((time) -> time.id.equals(id));
		if(usado){
			throw new IdentificadorUtilizadoException();
		}else {
			Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			times.add(time);
		}
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Time time = buscarTime(idTime);
		if(time == null){
			throw new TimeNaoEncontradoException();
		}
		List lista = buscarJogadoresDoTime(time.id);
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);

		if(lista.contains(id)){
			throw new IdentificadorUtilizadoException();
		}
		time.jogadores.add(jogador);
	}

	public void definirCapitao(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		Time time = buscarTime(jogador.idTime);
		time.capitao = idJogador;
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = buscarTime(idTime);
		for (Jogador jogador: time.jogadores) {
			if(time.capitao != null){
				return time.capitao;
			}
		}
		throw new CapitaoNaoInformadoException();
	}

	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		return jogador.nome;
	}

	public String buscarNomeTime(Long idTime) {
		Time time = buscarTime(idTime);
		return time.nome;
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time time = buscarTime(idTime);
		List<Long> jogadores = new ArrayList<>();
		time.jogadores.forEach(jogador -> jogadores.add(jogador.id));
		return jogadores;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time time = buscarTime(idTime);
		Jogador melhorJogador = null;
		int aux = 0;
		for (Jogador jogador: time.jogadores) {
			if(jogador.nivelHabilidade > aux){
				 aux = jogador.nivelHabilidade;
				 melhorJogador = jogador;
			}
		}
		return melhorJogador.id;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		Time time = buscarTime(idTime);
		Jogador maisVelho = time.jogadores.get(0);
		for (Jogador jogador: time.jogadores) {
			if(maisVelho.dataNascimento.isAfter(jogador.dataNascimento)){
				maisVelho = jogador;
			}
		}
		return maisVelho.id;
	}

	public List<Long> buscarTimes() {
		List<Long> ids = new ArrayList<>();
		for (Time t: times){
			ids.add(t.id);
		}
		return ids;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		Time time = buscarTime(idTime);
		Jogador melhorJogador = null;
		BigDecimal aux = new BigDecimal(0);
		for (Jogador jogador: time.jogadores) {
			if(jogador.salario.compareTo(aux) > 0){
				aux = jogador.salario;
				melhorJogador = jogador;

			}
		}
		return melhorJogador.id;
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		return jogador.salario;
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> melhores = new ArrayList<>();
		List<Jogador> todosJogadores = new ArrayList<>();
		times.forEach(time -> todosJogadores.addAll(time.jogadores));
		if (!todosJogadores.isEmpty()) {
			Collections.sort(todosJogadores, (Jogador o1, Jogador o2) -> {
				Integer n1 = o1.nivelHabilidade;
				Integer n2 = o2.nivelHabilidade;
				return !n1.equals(n2) ? Integer.compare(n2, n1) : Long.compare(o1.id, o2.id); // inverti os
				// jogadores
				// para ordenar
				// decrescente
			});
			if (top > todosJogadores.size())
				top = todosJogadores.size();
			List<Jogador> topJogadores = todosJogadores.subList(0, top);
			topJogadores.forEach(jogador -> melhores.add(jogador.id));
		}
		return melhores;

	}

	public Time buscarTime(Long id){
		Time time = times.stream()
					.filter(time1 -> time1.id == id)
					.findAny()
					.orElseThrow(TimeNaoEncontradoException::new);
		return time;
	}

	public Jogador buscarJogador(Long idJogador){
		List<Jogador> jogadores = new ArrayList<>();
		times.forEach(time -> jogadores.addAll(time.jogadores));
		Jogador jogador = jogadores.stream()
							.filter(jogador1 -> jogador1.id == idJogador)
							.findAny()
							.orElseThrow(JogadorNaoEncontradoException::new);
		if(buscarTime(jogador.idTime) == null){
			throw new TimeNaoEncontradoException();
		}else{
			return jogador;
		}
	}
}
