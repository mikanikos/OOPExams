public class Rettangolo extends Forma {
	
	private int larghezza;
	private int altezza;
	
	public Rettangolo(Colore colore, Punto vertice, int altezza, int larghezza){
		super(colore, vertice);
		this.larghezza = larghezza;
		this.altezza = altezza;
	}
	
	public int getAltezza(){
		return this.altezza;
	}
	
	public int getLarghezza(){
		return this.larghezza;
	}
	
	@Override
	public double superficie(){
		return (this.altezza * this.larghezza);
	}

}
