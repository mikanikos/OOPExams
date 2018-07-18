public class Roditore extends Animale {
	
	private static int PESO_RODITORE = 2;

	public Roditore(){
		super(PESO_RODITORE);
	}

	@Override
	public void agisci(Parco parco) {
		if (this.isMorto()) {
			parco.eliminaAnimale(this);
			return;
		}
		this.riproduci(parco);

		Posizione nuovaPosizione;
		nuovaPosizione = parco.posizioneLiberaVicino(this.getPosizione());
		if (nuovaPosizione!=null){
			this.incrementaCibo(1);
			parco.muovi(this, nuovaPosizione);
		} else {
			this.incrementaCibo(-1);
		}
		this.invecchia();
	}
	
	public Animale creaFiglio() {
		return new Roditore();
	}
	
}

