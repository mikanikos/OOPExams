import java.util.List;

public class Rapace extends Animale {
	private static int PESO_RAPACE = 5;

	public Rapace(){
		super(PESO_RAPACE);
	}

	public void agisci(Parco parco) {
		if (this.isMorto()) {
			parco.eliminaAnimale(this);
			return;
		}
		this.riproduci(parco);

		Posizione nuovaPosizione;
		Animale animale;
		animale = trovaAnimale(parco);
		if (animale != null) {
			this.incrementaCibo(1);
			parco.eliminaAnimale(animale);
			nuovaPosizione = animale.getPosizione();
		} 
		else {
			this.incrementaCibo(-1);
			nuovaPosizione = parco.posizioneLiberaVicino(this.getPosizione());
		}
		if (nuovaPosizione!=null) {
			parco.muovi(this, nuovaPosizione);
		}
		this.invecchia();
	}
	
	public Animale creaFiglio() {
		return new Rapace();
	}


	private Animale trovaAnimale(Parco parco) {
		List<Posizione> adiacenti = parco.adiacenti(this.getPosizione());
		for(Posizione p : adiacenti) {
			Animale a = parco.getAnimale(p);
			if ((a!=null) && (this.getPeso()>a.getPeso())) {
				return a;
			}
		}
		return null;
	}

}

