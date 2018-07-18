import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelezionatoreAutoriProlifici implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		Set<Autore> autori = new HashSet<>();
		for(Libro l : libriInBiblioteca)
			autori.addAll(l.getAutori());
		int max = 0;
		if(autori.size() != 0)
			max = Collections.max(autori, new ComparatorePerLibriPubblicati()).getLibriPubblicati();
		List<Autore> autoriProlifici = new ArrayList<>();
		for(Autore a : autori)
			if(a.getLibriPubblicati() == max)
				autoriProlifici.add(a);
		Collections.sort(autoriProlifici, new ComparatorePerLibriPubblicati());
		return autoriProlifici;
	}

}
