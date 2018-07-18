import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Impresa extends Società {
	
	public Impresa(int annoDiCostituzione, String nazione, String nome) {
		super(annoDiCostituzione, nazione, nome);
	}
	
	public int getNumeroDipendenti () {
		// scrivere il codice di questo metodo (vedi DOMANDA 2)
		return this.getDipendenti().size();
	}

	@Override
	public Map<String, List<Società>> nazione2consorziate() {
		Map<String, List<Società>> nazione2consorziate = new TreeMap<String, List<Società>>();
		List<Società> societa = new ArrayList<Società>();
		societa.add(this);
		nazione2consorziate.put(this.getNazione(), societa);
		return nazione2consorziate;
	}
	
} 
