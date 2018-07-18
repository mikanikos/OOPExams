import java.util.*;

public class VisualizzatoreImmobiliPerSuperficie extends Visualizzatore {
	
	@Override
	public void aggiornaGrafico() {
		this.visualizzaGrafico(this.superficie2immobili());
	}
	
	private void visualizzaGrafico(Map<Integer, List<Immobile>> mq2immobili){
	/* codice omesso perchè irrilevante ai fini del compito */ }
	
	public Map<Integer, List<Immobile>> superficie2immobili() {
		Map<Integer, List<Immobile>> mq2immobili = new HashMap<>();
		// DOMANDA 1: scrivere il codice di questo metodo:
		// deve restituire una mappa che associa una superficie alla lista di
		// immobili con quella superficie.
		// Ogni lista deve essere ordinata per prezzo
		for (Immobile i : this.getMercato().getListino()) {
			List<Immobile> lista = mq2immobili.get(i.getSuperficie());
			if(lista == null) {
				lista = new ArrayList<>();
				mq2immobili.put(i.getSuperficie(), lista);
			}
			lista.add(i);
			Collections.sort(lista, new ComparatorePerPrezzo());
		}
		return mq2immobili;
	}
}