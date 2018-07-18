import java.util.Comparator;

public class ComparatorePerLibriPubblicati implements Comparator<Autore> {

	@Override
	public int compare(Autore a1, Autore a2) {
		int a = a1.getLibriPubblicati() - a2.getLibriPubblicati();
		if(a == 0)
			a = a1.getNome().compareTo(a2.getNome());
		return a;
	}

}
