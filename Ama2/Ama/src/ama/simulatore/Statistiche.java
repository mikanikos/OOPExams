package ama.simulatore;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import ama.CentroDiRaccolta;
import ama.Citta;
import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;

public class Statistiche {

	public void stampaStatisticheFinali(Citta citta) {
		final CentroDiRaccolta centro = citta.getCentroDiRaccolta();

		final Set<Rifiuto> smaltiti = centro.getRifiutiSmaltiti();
		System.out.println("Rifiuti smaltiti in totale: " + smaltiti.size());
		System.out.println();
		
		// (VEDI DOMANDA 3 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta da ciascun mezzo impegnato:");
		final Map<Mezzo,Integer> mezzo2quantita = raccoltoPerMezzo(smaltiti);
		stampaRaccoltoPerMezzo(mezzo2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 4 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta per ogni politica:");
		final Map<Class<?>,Integer> politica2quantita = raccoltoPerPolitica(smaltiti);
		stampaRaccoltoPerPolitica(politica2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 5 - metodo da completare a seguire)
		System.out.println("Classifica finale delle politiche raccolta:");
		final List<Class<?>> classificaTipo = ordinaPolitichePerRaccolta(politica2quantita);
		stampaClassificaPolitiche(classificaTipo);
		System.out.println();

		// (VEDI DOMANDA 7 - metodo da completare a seguire)
		System.out.println("Classifica finale dei mezzi per raccolta:");
		final SortedSet<Mezzo> classificaMezzi = ordinaMezziPerRaccolta(mezzo2quantita);
		stampaClassificaMezzi(classificaMezzi);
		System.out.println();
		
	}

	public Map<Mezzo, Integer> raccoltoPerMezzo(Set<Rifiuto> smaltiti) {
		final Map<Mezzo,Integer> mezzo2quantita = new HashMap<>();
		for(Rifiuto r : smaltiti) {
			Integer i = mezzo2quantita.get(r.getRaccoglitore());
			if(i == null) {
				i = 0;
				mezzo2quantita.put(r.getRaccoglitore(), i);
			}
			mezzo2quantita.put(r.getRaccoglitore(), new Integer(i.intValue() + 1));
		}
		return mezzo2quantita;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 3
	private void stampaRaccoltoPerMezzo(final Map<Mezzo, Integer> mezzo2quantita) {
		for(Mezzo mezzo : mezzo2quantita.keySet()) {
			Integer quantita = mezzo2quantita.get(mezzo);
			if (quantita==null)
				quantita = 0;
			System.out.println("Il mezzo "+mezzo+" ha raccolto "+quantita);
		}
	}

	public Map<Class<?>, Integer> raccoltoPerPolitica(Set<Rifiuto> smaltiti) {
		final Map<Class<?>,Integer> politica2quantita = new HashMap<>();
		for(Rifiuto r : smaltiti) {
			Integer i = politica2quantita.get(r.getRaccoglitore().getPolitica().getClass());
			if(i == null) {
				i = 0;
				politica2quantita.put(r.getRaccoglitore().getPolitica().getClass(), i);
			}
			politica2quantita.put(r.getRaccoglitore().getPolitica().getClass(), new Integer(i.intValue() + 1));
		}
		return politica2quantita;
	}

	// UTILE PER STAMPARE RISULTATI DOMANDA 4
	private void stampaRaccoltoPerPolitica(final Map<Class<?>, Integer> tipo2quantita) {
		for(Class<?> tipo : tipo2quantita.keySet()) {
			Integer q = tipo2quantita.get(tipo);
			if (q==null)
				q = 0;
			System.out.println("La politica "+tipo.getSimpleName()+" ha raccolto "+q);
		}
	}
	
	public List<Class<?>> ordinaPolitichePerRaccolta(final Map<Class<?>, Integer> politica2quantita) {
		List<Class<?>> politicheOrdinate = new ArrayList<>(politica2quantita.keySet());
		Collections.sort(politicheOrdinate, new ComparatorePolitichePerRifiuti(politica2quantita));
		return politicheOrdinate;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 5
	private void stampaClassificaPolitiche(List<Class<?>> classifica) {
		for(int i=1; i<classifica.size()+1; i++)
			System.out.println(i+") "+classifica.get(i-1).getSimpleName());
	}
	
	public SortedSet<Mezzo> ordinaMezziPerRaccolta(final Map<Mezzo, Integer> mezzo2quantita) {
		SortedSet<Mezzo> mezziOrdinati = new TreeSet<>(new ComparatoreMezziPerRifiuti(mezzo2quantita));
		mezziOrdinati.addAll(mezzo2quantita.keySet());
		return mezziOrdinati;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 7
	private void stampaClassificaMezzi(SortedSet<Mezzo> classifica) {
		int posto = 1;
		for(Mezzo mezzo : classifica) {
			System.out.println(posto+") "+mezzo);
			posto++;
		}
	}
}
