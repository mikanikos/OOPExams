package it.uniroma3.diadia;

public class Autore implements Comparable<Autore>{
	private int annoNascita;
	private String nome;
	
	public Autore(String nome, int annoNascita){
		this.nome = nome;
		this.annoNascita = annoNascita;
	}
	
	public int getAnnoNascita() {
		return annoNascita;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		return this.annoNascita + this.nome.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Autore autore = (Autore) obj;
		if ((this.nome.equals(autore.getNome())) && (this.annoNascita == autore.getAnnoNascita()))
			return true;
		return false;
	}

	@Override
	public int compareTo(Autore autore) {
		return this.nome.compareTo(autore.getNome());
	}
}
