import java.util.*;

public class Biblioteca {

	private Map<String, Libro> codice2libro;

	public Biblioteca() {
		this.codice2libro = new HashMap<String, Libro>();
	}

	public void addLibro(String codice, Libro libro) {
		this.codice2libro.put(codice, libro);
	}

	public List<Autore> seleziona(Selezionatore selezionatore) {
		return selezionatore.eseguiSelezione(new ArrayList<>(this.codice2libro.values()));
	}

	public Map<Autore, Set<Libro>> autore2libri() {
		Map<Autore, Set<Libro>> autore2libri = new HashMap<>();
		for(Libro l : this.codice2libro.values()) {
			for(Autore a : l.getAutori()) {
				Set<Libro> insiemeLibri = autore2libri.get(a);
				if(insiemeLibri == null) {
					insiemeLibri = new HashSet<>();
					autore2libri.put(a, insiemeLibri);
				}
				insiemeLibri.add(l);
			}
		}
		return autore2libri;
	}
	
}