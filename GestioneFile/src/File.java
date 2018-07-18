import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class File extends Risorsa {
	
	private int dimensione;
	
	public File(String nome, int dimensione, String proprietario) {
		super(nome, proprietario);
		this.dimensione = dimensione;
	}
	
	public int getDimensione() { return this.dimensione; }

	@Override
	public Map<String, Set<Risorsa>> proprietario2risorsa() {
		Map<String, Set<Risorsa>> prop2risorsa = new HashMap<>();
		Set<Risorsa> insieme = new HashSet<>();
		insieme.add(this);
		prop2risorsa.put(this.getProprietario(), insieme);
		return prop2risorsa;
	}

}
