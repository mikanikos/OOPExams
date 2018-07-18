import java.util.Comparator;

public class ComparatorePerPrezzo implements Comparator<Immobile> {

	@Override
	public int compare(Immobile i1, Immobile i2) {
		return i1.getPrezzo() - i2.getPrezzo();
	}

}
