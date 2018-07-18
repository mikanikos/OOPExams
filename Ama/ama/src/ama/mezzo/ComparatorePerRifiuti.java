package ama.mezzo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComparatorePerRifiuti implements Comparator<Class<?>> {

	private Map<Class<?>, Integer> mappa;
	
	public ComparatorePerRifiuti(Map<Class<?>, Integer> mappa) {
		this.mappa = new HashMap<>(mappa);
	}

	@Override
	public int compare(Class<?> arg0, Class<?> arg1) {
		int a = this.mappa.get(arg1) - this.mappa.get(arg0);
		if(a == 0)
			return 1;
		return a;
	}
	
	public Map<Class<?>, Integer> getMappa() {
		return this.mappa;
	}

}
