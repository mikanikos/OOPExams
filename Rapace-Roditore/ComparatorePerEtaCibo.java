import java.util.Comparator;

public class ComparatorePerEtaCibo implements Comparator<Animale> {

	@Override
	public int compare(Animale r1, Animale r2) {
		int ris = r1.getAnni() - r2.getAnni();
		if (ris == 0)
			ris = r1.getCibo() - r2.getCibo();
		return ris;
	}

}
