import java.util.*;

public class Progetto extends Compito {
	
	private List<Compito> elencoCompiti;
	
	public Progetto(String nome, String responsabile) {
		super(nome, responsabile);
		this.elencoCompiti = new ArrayList<Compito>();
	}
	
	public void addCompito(Compito compito) {
		this.elencoCompiti.add(compito);
		Collections.sort(this.elencoCompiti, new ComparatorePerCosto());
	}
	
	@Override
	public int getCosto() {
		int costo = 0;
		for(Compito compito : this.elencoCompiti)
			costo += compito.getCosto();
		return costo;
	}

	/*public Map<String, Set<Compito>> responsabile2compitoSuSet() {
		Map<String, Set<Compito>> resp2compito = new HashMap<>();
		Set<Compito> list = new HashSet<Compito>();
		list.add(this);
		resp2compito.put(this.getResponsabile(), list);
		for(Compito c : this.elencoCompiti) {
			Set<Compito> listaCompiti = resp2compito.get(c.getResponsabile());
			if(listaCompiti == null) {
				listaCompiti = new HashSet<>();
				resp2compito.put(c.getResponsabile(), listaCompiti);
			}
			listaCompiti.add(c);
			Map<String, Set<Compito>> derivata = c.responsabile2compitoSuSet();
			for (String s : derivata.keySet()) {
				if(resp2compito.get(s) != null)
					resp2compito.get(s).addAll(derivata.get(s));
				else
					resp2compito.put(s, derivata.get(s));
			}
		}
		return resp2compito;
	}

	@Override
	public Map<String, List<Compito>> responsabile2compito() {
		Map<String, List<Compito>> resp2compito = new HashMap<>();
		Map<String, Set<Compito>> resp2compitoSet = responsabile2compitoSuSet();
		for(String s : resp2compitoSet.keySet()) {
			List<Compito> lista = new ArrayList<>(resp2compitoSet.get(s));
			resp2compito.put(s, lista);
		}
		return resp2compito;
	}*/
	
	@Override
	public Map<String, List<Compito>> responsabile2compito(){
		/* Creo la mappa (vuota) che riempirò e che il metodo restituirà */
		Map<String, List<Compito>> resp2compito = new HashMap<String, List<Compito>>();
		/* Aggiungo come primo elemento alla mappa questo stesso compito poichè anch'esso
		 * deve essere incluso nella mappa che ritornerà
		 */
		List<Compito> thisCompito = new ArrayList<Compito>(); //Creo lista
		thisCompito.add(this); //Aggiungo compito corrente
		resp2compito.put(this.getResponsabile(), thisCompito); //Inserisco nella mappa
		/* Ora procedo nel riempire la mappa con gli altri responsabili e gli altri compiti */
		for (Compito compito : this.elencoCompiti) { //Ciclo la lista dei compiti
			//Richiamo il metodo responsabile2compito sul compito corrente che mi restituirà
			//una mappa che salvo nella variabile d'appoggio resp2comp
			Map<String, List<Compito>> resp2comp = compito.responsabile2compito();
			//Ora devo aggiungere il contenuto di questa mappa alla mia mappa
			//Perciò mi scorro la mappa ritornata (per chiavi) e controllo se aggiungere
			//o meno
			for (String responsabile : resp2comp.keySet()) {
				//Mi creo una variabile temporanea listaCompiti che contiene una COPIA della lista
				//dei compiti associata alla chiave. 
				//Infatti il costruttore ArrayList<...>(collezione) crea una lista di partenza
				//con gli stessi elementi della collezione passata come parametro (quindi ho una copia)
				List<Compito> listaCompiti = new ArrayList<Compito>(resp2comp.get(responsabile));
				//Se la mia mappa (che dovrò restituire a fine metodo) conteneva già la chiave
				if (resp2compito.containsKey(responsabile))
					//Allora aggiungo alla lista (che metterò nella mappa) anche i vecchi elementi
					//della lista che già conteneva
					listaCompiti.addAll(resp2compito.get(responsabile));
				//quindi sovrascrivo quello che c'era prima (o se non c'era niente lo creo)
				//con la chiave e la nuova lista
				resp2compito.put(responsabile, listaCompiti);
			}
		}
		return resp2compito;
	}
}