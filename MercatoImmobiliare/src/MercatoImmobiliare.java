import java.util.ArrayList;
import java.util.List;

public class MercatoImmobiliare {

	private List<Immobile> listino;
	private List<Visualizzatore> listaVisualizzatori;

	public MercatoImmobiliare() {
		this.listaVisualizzatori = new ArrayList<>();
		this.listino = new ArrayList<Immobile>();
	}

	public List<Immobile> getListino() {
		return this.listino;
	}

	public void aggiungiVisualizzatore(Visualizzatore v) {
		v.setMercatoImmobiliare(this);
		this.listaVisualizzatori.add(v);
	}

	public void notificaAggiornamento() {
		for(Visualizzatore v : this.listaVisualizzatori)
			v.aggiornaGrafico();
	}

	public void aggiungiImmobile(Immobile immobile){
		this.listino.add(immobile);
		this.notificaAggiornamento();
	}
}