package ama.simulatore;

import java.util.Comparator;
import java.util.Map;

import ama.mezzo.Mezzo;

public class ComparatoreMezziPerRifiuti implements Comparator<Mezzo> {

	private Map<Mezzo, Integer> mezzo2quantita;
	
	public ComparatoreMezziPerRifiuti(Map<Mezzo, Integer> mezzo2quantita) {
		this.mezzo2quantita = mezzo2quantita;
	}

	@Override
	public int compare(Mezzo m1, Mezzo m2) {
		int a = this.mezzo2quantita.get(m2) - this.mezzo2quantita.get(m1);
		if(a == 0)
			a = m2.getPolitica().getId() - m1.getPolitica().getId();
		if(a == 0)
			a = m2.getPolitica().getClass().getName().compareTo(m1.getPolitica().getClass().getName());
		return a;
	}
}
