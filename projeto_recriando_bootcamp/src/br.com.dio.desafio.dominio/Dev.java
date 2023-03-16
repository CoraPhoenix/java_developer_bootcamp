package br.com.dio.desafio.dominio;

//import br.com.dio.desafio.dominio.Bootcamp.Bootcamp;
//import br.com.dio.desafio.dominio.Conteudo;

import java.util.*;

public class Dev {

	// atributos
	private String nome;
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
	
	// métodos
	
	public void inscreverBootcamp(Bootcamp bootcamp){
		// uma vez inscrito no bootcamp, todos os conteúdos deste são automaticamente inscritos
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}
	
	public void progredir(){
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		// se o conteúdo existir, adiciona aos conteúdos concluídos
		if (conteudo.isPresent()){
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get()); // uma vez concluido, o conteudo é removido da lista de inscritos
		} else { // se o conteúdo não existir, é porque nenhum conteúdo está na lista de inscritos
			System.err.println("Você não está matriculado em nenhum conteúdo");
		}
	}

	public double calcularTotalXp() {
		Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public Set<Conteudo> getConteudosInscritos(){
		return conteudosInscritos;
	}
	
	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos){
		this.conteudosInscritos = conteudosInscritos;
	}
	
	public Set<Conteudo> getConteudosConcluidos(){
		return conteudosConcluidos;
	}
	
	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos){
		this.conteudosConcluidos = conteudosConcluidos;
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dev dev = (Dev) o;
		return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
	}

	@Override
	public int hashCode(){
		return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
	}

}