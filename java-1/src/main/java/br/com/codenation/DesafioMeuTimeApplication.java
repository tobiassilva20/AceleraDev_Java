package br.com.codenation;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	List<Time> times = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario){

		// Verifica se o id já foi utilizado
		boolean usado = times.stream().anyMatch((time) -> time.id.equals(id));
		if(usado){
			throw new IdentificadorUtilizadoException();
		}else {
			Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
			times.add(time);
		}

		System.out.println("Time: " + times.get(0).nome);
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
		Time time = buscarTime(buscarJogador(idJogador));
		time.capitao = idJogador;
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = buscarTime(idTime);
		for (Jogador jogador: time.jogadores) {
			if(time.capitao != null){
				return jogador.id;
			}
		}
		return null;
	}

	public String buscarNomeJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public String buscarNomeTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> ids = new ArrayList<>();
		for (Time t: times){
			if(t.id == idTime){
				for (Jogador jogador: t.jogadores) {
					ids.add(jogador.id);
				}
			}
		}
		return ids;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarTimes() {
		List<Long> ids = new ArrayList<>();
		for (Time t: times){
			ids.add(t.id);
		}
		return ids;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		throw new UnsupportedOperationException();
	}

	public Time buscarTime(Long id){
		for (Time time: times) {
			if(time.id == id)
				return time;
		}
		return null;
	}
	public Long buscarJogador(Long idJogador){
		for (Time time: times) {
			for (Jogador jogador: time.jogadores) {
				if(jogador.id == idJogador){
					return jogador.idTime;
				}
			}
		}
		return null;
	}
}
