package esame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {

	static public Map<Utente, List<Documento>> utente2docs(List<Documento> docs, String nomePermesso) {
		Map<Utente, List<Documento>> utente2docs = new HashMap<>();
		for(Documento d : docs) {
			PermessoAccesso permesso = d.getPermessoAccesso(nomePermesso);
			if(permesso != null)
				for(Utente u : permesso.getUtenti()) {
					List<Documento> lista = utente2docs.get(u);
					if(lista == null) {
						lista = new ArrayList<>();
						utente2docs.put(u, lista);
					}
					lista.add(d);
				}
		}
		return utente2docs;
	}

}
