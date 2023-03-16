import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {

	public static void main (String [] args){
		
		Curso curso1 = new Curso();
		Curso curso2 = new Curso();
		
		curso1.setTitulo("curso java");
		curso1.setDescricao("descrição curso java");
		curso1.setCargaHoraria(8);
		
		curso2.setTitulo("curso js");
		curso2.setDescricao("descrição curso js");
		curso2.setCargaHoraria(4);
		
		Conteudo conteudo = new Curso();
		
		Mentoria mentoria = new Mentoria();
		
		mentoria.setTitulo("mentoria de java");
		mentoria.setDescricao("descrição mentoria java");
		mentoria.setData(LocalDate.now());
		
		/*System.out.println(curso1);
		System.out.println(curso2);
		System.out.println(mentoria);*/
		
		// criando bootcamp
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		// criando devs
		
		Dev dev1 = new Dev();
		dev1.setNome("Alberto");
		dev1.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos inscritos Alberto: " + dev1.getConteudosInscritos());
		dev1.progredir();
		dev1.progredir();
		System.out.println("Após progresso:");
		System.out.println("Conteúdos inscritos Alberto: " + dev1.getConteudosInscritos());
		System.out.println("Conteúdos concluídos Alberto: " + dev1.getConteudosConcluidos());
		System.out.println("XP: " + dev1.calcularTotalXp());
		
		System.out.println("--------------------");
		
		Dev dev2 = new Dev();
		dev2.setNome("Beatriz");
		dev2.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos inscritos Beatriz: " + dev2.getConteudosInscritos());
		dev2.progredir();
		System.out.println("Após progresso:");
		System.out.println("Conteúdos inscritos Beatriz: " + dev2.getConteudosInscritos());
		System.out.println("Conteúdos concluídos Beatriz: " + dev2.getConteudosConcluidos());
		System.out.println("XP: " + dev2.calcularTotalXp());
	}

}