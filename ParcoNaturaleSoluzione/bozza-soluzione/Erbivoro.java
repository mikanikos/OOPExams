public class Erbivoro extends Animale {
	private static int FORZA_ERBIVORO = 2;

	public Erbivoro(){
		super(FORZA_ERBIVORO);
	}

	@Override
	public void agisci(Territorio territorio) {
		if (this.isMorto()) {
			territorio.rimuoviAnimale(this);
			return;
		}
		this.riproduci(territorio);

		Posizione nuovaPosizione;
		nuovaPosizione = territorio.posizioneLiberaVicino(this.getPosizione());
		if (nuovaPosizione!=null){
			this.incrementaCibo(1);
			territorio.sposta(this, nuovaPosizione);
		} else {
			this.incrementaCibo(-1);
		}
		this.incrementaAnni();
	}

	@Override
	public Animale creaFiglio() {
		return new Erbivoro();
	}
}

