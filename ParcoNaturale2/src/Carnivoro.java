import java.util.List;

public class Carnivoro extends Animale {

	private static int FORZA_CARNIVORO = 5;

	public Carnivoro(){
		super(FORZA_CARNIVORO);	
	}

	@Override
	public void agisci(Territorio territorio) {
		if (this.isMorto()) {
			territorio.rimuoviAnimale(this);
			return;
		}
		this.riproduci(territorio);	

		Posizione nuovaPosizione;
		Animale vittima;
		vittima = cercaVittima(territorio);
		if (vittima != null) {		
			this.incrementaCibo(1);
			territorio.rimuoviAnimale(vittima);
			nuovaPosizione = vittima.getPosizione();
		}
		else {
			this.incrementaCibo(-1);
			nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
		}
		if (nuovaPosizione!=null){
			territorio.sposta(this, nuovaPosizione);
		}		
		this.incrementaAnni();
	}

	private Animale cercaVittima(Territorio territorio) {
		List<Posizione> adiacenti = territorio.adiacenti(this.getPosizione()); 
		for(Posizione p : adiacenti) {
			Animale a = territorio.getAnimale(p);
			if ((a!=null) && (this.getForza()>a.getForza())) {
				return a;
			}
		}
		return null;
	}

	@Override
	public Carnivoro creaFiglio() {
		return new Carnivoro();
	}

}

