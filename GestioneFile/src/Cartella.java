import java.util.*;

public class Cartella extends Risorsa {

	private Set<Risorsa> elencoRisorse;

	public Cartella(String nome, String proprietario) {
		super(nome, proprietario);
		this.elencoRisorse = new TreeSet<Risorsa>();
	}

	public void addRisorsa(Risorsa risorsa) { this.elencoRisorse.add(risorsa); }

	@Override
	public int getDimensione() {
		int dimensione = 0;
		for(Risorsa risorsa : this.elencoRisorse)
			dimensione += risorsa.getDimensione();
		return dimensione;
	}

	@Override
	public Map<String, Set<Risorsa>> proprietario2risorsa(){
		Map<String, Set<Risorsa>> proprietario2risorsa = new HashMap<String, Set<Risorsa>>();
		Set<Risorsa> insieme = new HashSet<>();
		insieme.add(this);
		proprietario2risorsa.put(this.getProprietario(), insieme);
		for(Risorsa risorsa : this.elencoRisorse) {
			Set<Risorsa> risorse = proprietario2risorsa.get(risorsa.getProprietario());
			if (risorse == null)
				risorse = new HashSet<Risorsa>();
			risorse.add(risorsa);
			proprietario2risorsa.put(risorsa.getProprietario(), risorse);
			Map<String, Set<Risorsa>> derivata = risorsa.proprietario2risorsa();
			for(String s : derivata.keySet()) {
				if(proprietario2risorsa.containsKey(s))
					proprietario2risorsa.get(s).addAll(derivata.get(s));
				else
					proprietario2risorsa.put(s, derivata.get(s));
			}
		}
		return proprietario2risorsa;
	}
}