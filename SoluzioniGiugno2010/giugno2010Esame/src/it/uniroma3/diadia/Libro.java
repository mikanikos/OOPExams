package it.uniroma3.diadia;

import java.util.*;

public class Libro {
	private Set<Autore> autori;
	private String titolo;
	
	public Libro(String titolo) {
		this.titolo = titolo;
		this.autori = new HashSet<Autore>();
	}
	
	public void AddAutore(Autore autore){
		this.autori.add(autore);
	}
	
	public Set<Autore> getAutori() {
		return Collections.unmodifiableSet(this.autori);
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
}
