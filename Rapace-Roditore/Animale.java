
public abstract class Animale {
	
	private int anni;
	private int peso;
	private Posizione posizione;
	private static double PROBABILITA_RIPRODUZIONE = 0.45;
	private int cibo;
	
	public Animale(int peso){
		this.peso = peso;
		this.cibo = 2;
		this.anni = 0;
	}
	
	public abstract void agisci(Parco parco);
	
	public void riproduci(Parco parco) {
		Double random = Math.random();
		Posizione posizioneFiglio = parco.posizioneLiberaVicino(this.posizione);

		if ((posizioneFiglio!= null) && (PROBABILITA_RIPRODUZIONE > random)) {
			Animale figlio = this.creaFiglio();
			parco.setAnimale(figlio, posizioneFiglio);
		}
	}
	
	public abstract Animale creaFiglio();

	public void setPosizione(Posizione posizione){
		this.posizione = posizione;
	}

	public Posizione getPosizione() {
		return this.posizione;
	}

	public int getPeso() {
		return this.peso;
	}

	public int getAnni() {
		return this.anni;
	}

	public int getCibo() {
		return cibo;
	}

	public boolean isMorto(){
		return (this.cibo==0)||(this.anni==5);
	}

	public void invecchia(){
		this.anni ++;
	}

	public void incrementaCibo(int cibo){
		this.cibo+=cibo;
	}
}
