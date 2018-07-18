public class Cerchio extends Forma {
	
	private int raggio;
	
	public Cerchio(Colore colore, Punto centro, int raggio){
		super(colore, centro);
		this.raggio = raggio;
	}
	
	public int getRaggio(){
		return this.raggio;
	}
	
	@Override
	public double superficie(){
		return Math.PI * this.raggio * this.raggio;
	}

}
