import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelezionatoreAutoriGiovani implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		Set<Autore> autori = new HashSet<>();
		for(Libro l : libriInBiblioteca)
			autori.addAll(l.getAutori());
		int max = 0;
		if(autori.size() != 0)
			 max = Collections.max(autori).getAnnoNascita();
		List<Autore> autoriGiovani = new ArrayList<>();
		for(Autore a : autori)
			if(a.getAnnoNascita() == max)
				autoriGiovani.add(a);
		return autoriGiovani;
	}

}
