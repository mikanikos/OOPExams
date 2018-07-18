import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attivita extends Compito {
	
	private int costo;
	
	public Attivita(String nome, String responsabile, int costo) {
		super(nome, responsabile);
		this.costo = costo;
	}
	
	@Override
	public int getCosto() { return this.costo; }

	@Override
	public Map<String, List<Compito>> responsabile2compito() {
		Map<String, List<Compito>> resp2compito = new HashMap<>();
		List<Compito> list = new ArrayList<Compito>();
		list.add(this);
		resp2compito.put(this.getResponsabile(), list);
		return resp2compito;
	}

	/*@Override
	public Map<String, Set<Compito>> responsabile2compitoSuSet() {
		Map<String, Set<Compito>> resp2compito = new HashMap<>();
		Set<Compito> list = new HashSet<Compito>();
		list.add(this);
		resp2compito.put(this.getResponsabile(), list);
		return resp2compito;
	}*/

}