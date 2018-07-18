package ama.simulatore;

import java.util.Comparator;
import java.util.Map;

public class ComparatorePolitichePerRifiuti implements Comparator<Class<?>> {
	
	private Map<Class<?>, Integer> politica2quantita;
	
	public ComparatorePolitichePerRifiuti(Map<Class<?>, Integer> politica2quantita) {
		this.politica2quantita = politica2quantita;
	}

	@Override
	public int compare(Class<?> p1, Class<?> p2) {
		return this.politica2quantita.get(p2) - this.politica2quantita.get(p1);
	}

}
