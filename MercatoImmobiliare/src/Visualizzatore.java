
public abstract class Visualizzatore {

	private MercatoImmobiliare mercato;

	public void setMercatoImmobiliare(MercatoImmobiliare mercatoImmobiliare) {
		this.mercato = mercatoImmobiliare;
	}

	public abstract void aggiornaGrafico();
	
	public MercatoImmobiliare getMercato() {
		return mercato;
	}

}
