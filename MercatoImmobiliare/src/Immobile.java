public class Immobile {
	
	private String indirizzo;
	private int superficie;
	private int prezzo;
	private int vani;
	
	public Immobile(String indirizzo, int superficie, int prezzo, int vani) {
		this.indirizzo = indirizzo;
		this.superficie = superficie;
		this.prezzo = prezzo;
		this.vani = vani;
	}
	
	public String getIndirizzo() {
		return this.indirizzo;
	}
	
	public int getSuperficie () {
		return this.superficie;
	}
	
	public int getPrezzo() {
		return this.prezzo;
	}
	
	public int getVani() {
		return this.vani;
	}
	
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
}