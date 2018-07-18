import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Impresa extends Societ� {
	
	public Impresa(int annoDiCostituzione, String nazione, String nome) {
		super(annoDiCostituzione, nazione, nome);
	}
	
	public int getNumeroDipendenti () {
		// scrivere il codice di questo metodo (vedi DOMANDA 2)
		return this.getDipendenti().size();
	}

	@Override
	public Map<String, List<Societ�>> nazione2consorziate() {
		Map<String, List<Societ�>> nazione2consorziate = new TreeMap<String, List<Societ�>>();
		List<Societ�> societa = new ArrayList<Societ�>();
		societa.add(this);
		nazione2consorziate.put(this.getNazione(), societa);
		return nazione2consorziate;
	}
	
} 
