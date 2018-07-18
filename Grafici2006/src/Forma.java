
public abstract class Forma {

	private Colore colore;
	private Punto riferimento;

	public Forma(Colore colore, Punto riferimento) {
		this.colore = colore;
		this.riferimento = riferimento;
	}

	public Colore getColore() { return this.colore; }

	public Punto getRiferimento() { return this.riferimento; }

}
