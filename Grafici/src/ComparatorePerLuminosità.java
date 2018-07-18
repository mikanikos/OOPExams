import java.util.Comparator;

public class ComparatorePerLuminosità implements Comparator<Forma> {

	@Override
	public int compare(Forma f1, Forma f2) {
		return f1.getColore().luminosita() - f2.getColore().luminosita();
	}

}
