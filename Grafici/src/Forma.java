
public abstract class Forma implements Comparable<Forma> {
	
	private Colore colore;
	private Punto riferimento;
	
	public Forma(Colore colore, Punto riferimento){
		this.colore = colore;
		this.riferimento = riferimento;
	}
	
	public Colore getColore(){
		return this.colore;
	}
	
	public Punto getRiferimento(){
		return this.riferimento;
	}
	
	public abstract double superficie();
	
	@Override
	public int compareTo(Forma f) {
		return (int) (this.superficie() - f.superficie());
	}
	

}
