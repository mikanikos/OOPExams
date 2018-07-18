import java.util.Comparator;
import java.util.Map;

public class ComparatorePerLivello implements Comparator<Forma> {

	private Map<Forma, Integer> forma2livello;
	
	public ComparatorePerLivello(Map<Forma, Integer> forma2livello) {
		this.forma2livello = forma2livello;
	}

	@Override
	public int compare(Forma o1, Forma o2) {
		return this.forma2livello.get(o1) - this.forma2livello.get(o2);
	}

}
