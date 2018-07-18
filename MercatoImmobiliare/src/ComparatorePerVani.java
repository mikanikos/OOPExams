import java.util.Comparator;

public class ComparatorePerVani extends ComparatorePerPrezzo implements Comparator<Immobile> {

	@Override
	public int compare(Immobile o1, Immobile o2) {
		int a = o1.getVani() - o2.getVani();
		if(a == 0)
			return super.compare(o1, o2);
		return a;
	}
	
}
