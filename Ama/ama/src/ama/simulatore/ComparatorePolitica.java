package ama.simulatore;

import java.util.Comparator;
import java.util.Map.Entry;

public class ComparatorePolitica implements Comparator<Entry<Class<?>,Integer>> {

	@Override
	public int compare(Entry<Class<?>, Integer> uno, Entry<Class<?>, Integer> due) {
		int a = due.getValue().intValue()-uno.getValue().intValue();
		if(a == 0)
			return 1;
		return a;
	}

}
