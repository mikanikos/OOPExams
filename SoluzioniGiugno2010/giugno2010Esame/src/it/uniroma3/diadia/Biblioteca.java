package it.uniroma3.diadia;

import it.uniroma3.diadia.selezionatori.Selezionatore;

import java.util.*;


public class Biblioteca {
	private Map<String, Libro> codice2libro;

	public Biblioteca() {
		this.codice2libro = new HashMap<String, Libro>();
	}
	
	public void addLibro(String codice, Libro libro){
		this.codice2libro.put(codice, libro);
	}
	
	public List<Autore> seleziona(Selezionatore selezionatore){
		return selezionatore.eseguiSelezione(new ArrayList<Libro>(this.codice2libro.values()));
	}
	
	public Map<Autore, Set<Libro>> autore2Libri(){
		Map<Autore, Set<Libro>> autore2libri = new HashMap<Autore, Set<Libro>>();
		for (Libro libro : this.codice2libro.values()){
			for (Autore autore : libro.getAutori()){
				Set<Libro> libri; 
				if (autore2libri.containsKey(autore))
					libri = new HashSet<Libro>(autore2libri.get(autore));
				else
					libri = new HashSet<Libro>();
				libri.add(libro);
				autore2libri.put(autore, libri);
			}
		}
		return autore2libri;
	}
	
}
