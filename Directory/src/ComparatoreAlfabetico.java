import java.util.Comparator;

public class ComparatoreAlfabetico implements Comparator<Permesso> {

	@Override
	public int compare(Permesso p1, Permesso p2) {
		return p1.getNome().compareTo(p2.getNome());
	}

}
