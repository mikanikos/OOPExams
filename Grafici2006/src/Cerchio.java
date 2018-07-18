public class Cerchio extends Forma {
	
	private int diametro;
	
	public Cerchio(Colore colore, Punto centro, int diametro) {
		super(colore, centro);
		this.diametro = diametro;
	}
	
	public int getDiametro(){ return this.diametro; }
	
	//public boolean equals(Object o) { /*codice omesso (irrilevante ai fini del compito)*/ }
	
	//public int hashCode(){ /* codice omesso (irrilevante ai fini del compito)*/ }
}
