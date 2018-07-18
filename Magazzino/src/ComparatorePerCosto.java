import java.util.Comparator;

public class ComparatorePerCosto implements Comparator<Articolo>{

	@Override
	public int compare(Articolo o1, Articolo o2) {
		return o1.getCostoUnitario() - o2.getCostoUnitario();
	}

}
