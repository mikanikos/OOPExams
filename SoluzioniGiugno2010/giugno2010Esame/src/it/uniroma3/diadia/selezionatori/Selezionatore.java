package it.uniroma3.diadia.selezionatori;

import it.uniroma3.diadia.Autore;
import it.uniroma3.diadia.Libro;

import java.util.List;


public interface Selezionatore {
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca);
}
