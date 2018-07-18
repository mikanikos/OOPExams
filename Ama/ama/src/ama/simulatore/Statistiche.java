package ama.simulatore;


import java.util.*;

import ama.CentroDiRaccolta;
import ama.Citta;
import ama.mezzo.ComparatorePerRifiuti;
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
		Integer i;
		for(Rifiuto app : smaltiti) {
			i = mezzo2quantita.get(app.getRaccoglitore());
			if(i == null)
				i = 0;
			i++;
			mezzo2quantita.put(app.getRaccoglitore(), i);
			/*Mezzo raccoglitore = app.getRaccoglitore();
			if(!mezzo2quantita.containsKey(raccoglitore)) {
				Integer contatore = 1;
				mezzo2quantita.put(raccoglitore, contatore);
			}
			else {
				int vecchiaQuantita = mezzo2quantita.get(raccoglitore);
				mezzo2quantita.put(raccoglitore, ++vecchiaQuantita);
			}*/
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
		// DA COMPLETARE (VEDI DOMANDA 4)
		Integer i;
		for(Rifiuto app : smaltiti) {
			i = politica2quantita.get(app.getRaccoglitore().getPolitica().getClass());
			if(i == null)
				i = 0;
			i++;
			politica2quantita.put(app.getRaccoglitore().getPolitica().getClass(), i);
			/*Mezzo m = app.getRaccoglitore();
			Class<?> c = m.getPolitica().getClass();
			if(!politica2quantita.containsKey(c))
				politica2quantita.put(c, 1);
			else {
				int numeroVecchio = politica2quantita.get(c).intValue();
				politica2quantita.put(c, ++numeroVecchio);
			}*/
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
		// DA COMPLETARE (VEDI DOMANDA 5)
		/*Map<Class<?>, Integer> politica2quantitaCopia = new HashMap<>(politica2quantita);
		LinkedList<Integer> list = new LinkedList<>(politica2quantitaCopia.values());
		Collections.sort(list, new ComparatorePerRifiuti());
		List<Class<?>> finale = new LinkedList<>();
		for(Integer i : list){
			Iterator<Class<?>> iteratore = politica2quantitaCopia.keySet().iterator();
			while (iteratore.hasNext()) {
				Class<?> c = iteratore.next();
				if(politica2quantitaCopia.get(c).intValue() == i.intValue()){
					finale.add(c);
					iteratore.remove();
				}
			}
		}
		return finale;*/

		Map<Class<?>, Integer> mappa = new TreeMap<>(new ComparatorePerRifiuti(politica2quantita));
		mappa.putAll(politica2quantita);
		return new ArrayList<>(mappa.keySet());
		
		/*Set<Map.Entry<Class<?>,Integer>> ordinatoPerValori = new TreeSet<>(new ComparatorePolitica());
		ordinatoPerValori.addAll(politica2quantita.entrySet());
		List<Class<?>> risultato = new LinkedList<>();
		for(Map.Entry<Class<?>,Integer> elemento : ordinatoPerValori)
			risultato.add(elemento.getKey());
		return risultato;*/
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 5
	private void stampaClassificaPolitiche(List<Class<?>> classifica) {
		for(int i=1; i<classifica.size()+1; i++)
			System.out.println(i+") "+classifica.get(i-1).getSimpleName());
	}

	public SortedSet<Mezzo> ordinaMezziPerRaccolta(final Map<Mezzo, Integer> mezzo2quantita) {
		// DA COMPLETARE (VEDI DOMANDA 7)
		Map<Mezzo, Integer> mappa = new TreeMap<>(mezzo2quantita);
		return new TreeSet<Mezzo>(mappa.keySet());
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
