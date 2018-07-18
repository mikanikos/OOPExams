import java.util.*;

public class Consorzio extends Società {
	private Map<String, Società> società;

	public Consorzio(int annoCostituzione, String nazione, String nome) {
		super(annoCostituzione, nazione, nome);
		this.società = new HashMap<String, Società>();
	}

	public void aggiungiConsorziata(Società società) {
		/* scrivere il codice di questo metodo (vedi DOMANDA 1) */ 
		this.società.put(società.getNome(), società);
	}

	public int getNumeroDipendenti () {
		// scrivere il codice di questo metodo (vedi DOMANDA 2)
		int totale = this.getDipendenti().size();
		for(Società i : this.società.values())
			totale += i.getNumeroDipendenti();
		return totale;
	}

	public Map<String, List<Società>> nazione2consorziate() {
		/*Map<String, List<Società>> nazione2consorziate = new HashMap<>();
		List<Società> list = new ArrayList<Società>();
		list.add(this);
		nazione2consorziate.put(this.getNazione(), list);
		for(Società i : this.società.values()) {
			list = nazione2consorziate.get(i.getNazione());
			if(list == null) {
				list = new ArrayList<>();
				nazione2consorziate.put(i.getNazione(), list);
			}
			list.add(i);
			//nazione2consorziate.putAll(i.nazione2consorziate());
			for(String stringa : i.nazione2consorziate().keySet()) {
				List<Società> l1 = nazione2consorziate.get(stringa);
				if(l1 == null) {
					l1 = new ArrayList<>();
					nazione2consorziate.put(stringa, l1);
				}
				nazione2consorziate.get(stringa).addAll(i.nazione2consorziate().get(stringa));
			}
		}	
		for(List<Società> l : nazione2consorziate.values())
			Collections.sort(l);
		return nazione2consorziate;*/
		Map<String, List<Società>> nazione2consorziate = new TreeMap<String, List<Società>>();
		Map<String, List<Società>> nazione2societa;
		List<Società> consorzio = new ArrayList<Società>();
		consorzio.add(this);
		nazione2consorziate.put(this.getNazione(), consorzio);
		for (String societa : this.società.keySet()){
			nazione2societa = this.società.get(societa).nazione2consorziate();
			for(String nazione : nazione2societa.keySet()){
				if (nazione2consorziate.containsKey(nazione)){
					List<Società> listaSocieta = new ArrayList<Società>(nazione2consorziate.get(nazione));
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