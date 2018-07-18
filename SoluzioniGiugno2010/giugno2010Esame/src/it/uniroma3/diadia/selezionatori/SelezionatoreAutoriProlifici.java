package it.uniroma3.diadia.selezionatori;

import it.uniroma3.diadia.Autore;
import it.uniroma3.diadia.Biblioteca;
import it.uniroma3.diadia.Libro;
import java.util.*;

public class SelezionatoreAutoriProlifici implements Selezionatore{

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		Set<Autore> autoriProlifici = new TreeSet<Autore>();
		Map<Autore, Set<Libro>> autore2libro = autore2libri(libriInBiblioteca);
		int maxLibriScritti = MaxLibriScritti(autore2libro);
		for (Libro libro : libriInBiblioteca){
			for (Autore autore : libro.getAutori()){
				if (autore2libro.get(autore).size() == maxLibriScritti)
					autoriProlifici.add(autore);
			}
		}
		return new ArrayList<Autore>(autoriProlifici);
	}
	
	private int MaxLibriScritti(Map<Autore, Set<Libro>> autore2libro ){
		int maxLibriScritti = 0;
		for (Autore autore : autore2libro.keySet()){
			int libriScritti = autore2libro.get(autore).size();
			if (libriScritti > maxLibriScritti)
				maxLibriScritti = libriScritti;
		}
		return maxLibriScritti;
	}
	
	private Map<Autore, Set<Libro>> autore2libri(List<Libro> libri){
		Biblioteca biblioteca = new Biblioteca();
		for (Libro libro : libri){
			biblioteca.addLibro(libro.getTitolo(), libro);
		}
		return biblioteca.autore2Libri();
	}

}
