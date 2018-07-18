import java.util.*;

public class Consorzio extends Societ� {
	private Map<String, Societ�> societ�;

	public Consorzio(int annoCostituzione, String nazione, String nome) {
		super(annoCostituzione, nazione, nome);
		this.societ� = new HashMap<String, Societ�>();
	}

	public void aggiungiConsorziata(Societ� societ�) {
		/* scrivere il codice di questo metodo (vedi DOMANDA 1) */ 
		this.societ�.put(societ�.getNome(), societ�);
	}

	public int getNumeroDipendenti () {
		// scrivere il codice di questo metodo (vedi DOMANDA 2)
		int totale = this.getDipendenti().size();
		for(Societ� i : this.societ�.values())
			totale += i.getNumeroDipendenti();
		return totale;
	}

	public Map<String, List<Societ�>> nazione2consorziate() {
		/*Map<String, List<Societ�>> nazione2consorziate = new HashMap<>();
		List<Societ�> list = new ArrayList<Societ�>();
		list.add(this);
		nazione2consorziate.put(this.getNazione(), list);
		for(Societ� i : this.societ�.values()) {
			list = nazione2consorziate.get(i.getNazione());
			if(list == null) {
				list = new ArrayList<>();
				nazione2consorziate.put(i.getNazione(), list);
			}
			list.add(i);
			//nazione2consorziate.putAll(i.nazione2consorziate());
			for(String stringa : i.nazione2consorziate().keySet()) {
				List<Societ�> l1 = nazione2consorziate.get(stringa);
				if(l1 == null) {
					l1 = new ArrayList<>();
					nazione2consorziate.put(stringa, l1);
				}
				nazione2consorziate.get(stringa).addAll(i.nazione2consorziate().get(stringa));
			}
		}	
		for(List<Societ�> l : nazione2consorziate.values())
			Collections.sort(l);
		return nazione2consorziate;*/
		Map<String, List<Societ�>> nazione2consorziate = new TreeMap<String, List<Societ�>>();
		Map<String, List<Societ�>> nazione2societa;
		List<Societ�> consorzio = new ArrayList<Societ�>();
		consorzio.add(this);
		nazione2consorziate.put(this.getNazione(), consorzio);
		for (String societa : this.societ�.keySet()){
			nazione2societa = this.societ�.get(societa).nazione2consorziate();
			for(String nazione : nazione2societa.keySet()){
				if (nazione2consorziate.containsKey(nazione)){
					List<Societ�> listaSocieta = new ArrayList<Societ�>(nazione2consorziate.get(nazione));
					listaSocieta.addAll(nazione2societa.get(nazione));
					Collections.sort(listaSocieta);
					nazione2consorziate.put(nazione, listaSocieta);
				}else{
					nazione2consorziate.put(nazione, nazione2societa.get(nazione));
				}
			}
		}
		return nazione2consorziate;
	}

} 