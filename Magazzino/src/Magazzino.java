import java.util.*;

public class Magazzino {
	
	private Map<Articolo,Integer> articolo2quantita;
	
	public Magazzino() {
		this.articolo2quantita = new HashMap<Articolo,Integer>();
	}
	
	public void aggiungiArticolo(Articolo articolo, int quantita){
		articolo2quantita.put(articolo, quantita);
	}
	
	public int calcolaValoreMagazzino() {
		int valore = 0;
		for(Articolo a : this.articolo2quantita.keySet())
			valore += a.getCostoUnitario() * this.articolo2quantita.get(a);
		return valore;
	}
	
	public Map<Integer,Set<String>> articoliEconomici(int soglia) {
		// costo -> insieme di codici di articoli con il costo della chiave
		Map<Integer,Set<String>> costo2insiemeCodiceArticoli = new HashMap<Integer,Set<String>>();
		// DOMANDA 3: scrivere codice mancante
		for(Articolo a : this.articolo2quantita.keySet()) {
			int costo = a.getCostoUnitario();
			if(costo < soglia) {
				Set<String> insieme = costo2insiemeCodiceArticoli.get(costo);
				if(insieme == null) {
					insieme = new HashSet<>();
					costo2insiemeCodiceArticoli.put(costo, insieme);
				}
				insieme.add(a.getCodice());
			}
		}
		return costo2insiemeCodiceArticoli;
	}
	
	public List<Articolo> articoliOrdinatiPerCosto() {
		List<Articolo> listaArticoli = new LinkedList<Articolo>();
		// DOMANDA 4: scrivere codice mancante
		listaArticoli.addAll(this.articolo2quantita.keySet());
		Collections.sort(listaArticoli, new ComparatorePerCosto());
		return listaArticoli;
	}
}