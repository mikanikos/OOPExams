public class Rettangolo extends Forma {
	
	private int larghezza;
	private int altezza;
	
	public Rettangolo(Colore colore, Punto vertice, int altezza, int larghezza) {
		super(colore, vertice);
		this.altezza = altezza;
		this. larghezza = larghezza;
	}
	
	public int getAltezza() { return this.altezza; }
	
	public int getLarghezza() { return this.larghezza; }
	
	//public boolean equals(Object o) { /* codice omesso (irrilevante ai fini del compito)*/ }
	
	//public int hashCode(){ /* codice omesso (irrilevante ai fini del compito)*/ }
}