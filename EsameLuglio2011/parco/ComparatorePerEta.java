import java.util.Comparator;

public class ComparatorePerEta implements Comparator<Animale> {

	@Override
	public int compare(Animale e1, Animale e2) {
		return e1.getAnni() - e2.getAnni();
	}

}
