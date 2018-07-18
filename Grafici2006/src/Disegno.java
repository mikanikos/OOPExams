import java.util.*;

public class Disegno {

	private Map<Forma, Integer> forma2livello;

	public Disegno() {
		this.forma2livello = new HashMap<Forma, Integer>();
	}

	public void aggiungiForma(Forma forma, int livello){
		forma2livello.put(forma, livello);
	}
	
	public Set<Colore> coloriNelDisegno() {
		Set<Colore> coloriNelDisegno = new HashSet<Colore>();
		for(Forma f : this.forma2livello.keySet())
			coloriNelDisegno.add(f.getColore());
		return coloriNelDisegno;
	}
	
	public Map<Integer,List<Forma>> formeAffioranti (int livelloMinimo) {
		// livello -> lista di forme al livello della chiave
		Map<Integer,List<Forma>> livello2forme = new HashMap<Integer,List<Forma>>();
		for(Forma f : this.forma2livello.keySet()) {
			int livello = this.forma2livello.get(f);
			if(livello >= livelloMinimo) {
				List<Forma> lista = livello2forme.get(livello);
				if(lista == null) {
					lista = new ArrayList<>();
					livello2forme.put(livello, lista);
				}
				lista.add(f);
			}
		}
		return livello2forme;
	}
	
	public List<Forma> formeOrdinatePerLivello() {
		List<Forma> listaFormeOrdinata = new ArrayList<Forma>();
		ComparatorePerLivello comp = new ComparatorePerLivello(this.forma2livello);
		listaFormeOrdinata.addAll(this.forma2livello.keySet());
		Collections.sort(listaFormeOrdinata, comp);
		return listaFormeOrdinata;
	}
}