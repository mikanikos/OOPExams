import java.util.*;
public class Disegno {
	
	private Map<Integer, List<Forma>> livello2forme;
	
	public Disegno() {
		this.livello2forme = new TreeMap<Integer, List<Forma>>();
	}
	
	public void aggiungiForma(Forma forma, int livello){
		//DOMANDA 1: scrivere il codice di questo metodo
		List<Forma> listaForme = this.livello2forme.get(livello);
		if(listaForme == null) {
			listaForme = new ArrayList<>();
			this.livello2forme.put(livello, listaForme);
		}
		listaForme.add(forma);
		//DOMANDA 2: eliminare questo metodo e sostituirlo con il metodo
		// public void aggiungiForma(Forma forma, int livello)
	}
	
	public Set<Colore> coloriPresentiNelDisegno() {
		Set<Colore> coloriNelDisegno = new HashSet<>();;
		//DOMANDA 3: scrivere il codice di questo metodo
		// (è possibile modificare Colore; non e’ possibile introdurre nuove classi)
		for(List<Forma> list : this.livello2forme.values()) {
			for(Forma f : list) {
				coloriNelDisegno.add(f.getColore());
			}
		}
		return coloriNelDisegno;
	}
	
	public Map<Colore, List<Forma>> colore2forme() {
		Map<Colore, List<Forma>> colore2forme = new HashMap<>();;
		//DOMANDA 4: scrivere il codice di questo metodo
		// (non è possibile introdurre altre classi; è possibile modificare Forma)
		for(List<Forma> list : this.livello2forme.values()) {
			for(Forma f : list) {
				List<Forma> listaForme = colore2forme.get(f.getColore());
				if(listaForme == null) {
					listaForme = new ArrayList<>();
					colore2forme.put(f.getColore(), listaForme);
				}
				listaForme.add(f);
				Collections.sort(listaForme);
			}
		}
		return colore2forme;
	}
	
	public List<Forma> formeOrdinatePerLuminosita() {
		List<Forma> forme = new ArrayList<>();
		//DOMANDA 5: scrivere il codice di questo metodo
		// (non è possibile modificare Forma e Colore, è possibile introdurre nuove classi)
		for(List<Forma> list : this.livello2forme.values())
			forme.addAll(list);
		Collections.sort(forme, new ComparatorePerLuminosità());
		return forme;
	}

}