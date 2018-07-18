package esame;

import java.util.*;

public class Utility {

	static public Map<Utente, List<Documento>> utente2docs(List<Documento> docs, String nomePermesso) {
		// codice omesso: domanda 4
		Map<Utente, List<Documento>> map = new HashMap<>();
		List<Documento> docsList;
		for(Documento doc : docs)
			if(doc.getPermessoAccesso(nomePermesso) != null)
				for(Utente user : doc.getPermessoAccesso(nomePermesso).getUtenti()) {
					docsList = map.get(user);
					if(docsList == null) {
						docsList = new ArrayList<>();
						map.put(user, docsList);
					}
					docsList.add(doc);
				}
		return map;
	}

}
