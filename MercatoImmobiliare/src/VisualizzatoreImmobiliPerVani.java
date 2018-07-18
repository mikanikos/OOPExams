import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VisualizzatoreImmobiliPerVani extends Visualizzatore {
	
	// DOMANDA 3: se necessario completare con variabili, costruttori, metodi
	private void visualizzaGrafico(List<Immobile> immobiliOrdinati) {
	/* codice omesso perchè irrilevante ai fini del compito */}
	
	List<Immobile> ordinaImmobiliXvaniXprezzo() {
		List<Immobile> immobili = new ArrayList<>();
		// DOMANDA 3: scrivere il codice di questo metodo: deve restituire in
		// una lista gli immobili del mercato ordinati per vani e per prezzo
		immobili.addAll(this.getMercato().getListino());
		Collections.sort(immobili, new ComparatorePerVani());
		return immobili;
	}

	@Override
	public void aggiornaGrafico() {
		this.visualizzaGrafico(this.ordinaImmobiliXvaniXprezzo());
	}
}