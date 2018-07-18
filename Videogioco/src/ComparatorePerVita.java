import java.util.Comparator;

public class ComparatorePerVita implements Comparator<Personaggio> {

	@Override
	public int compare(Personaggio p1, Personaggio p2) {
		return p1.getVita() - p2.getVita();
	}

}
