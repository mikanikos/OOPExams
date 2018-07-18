public class Disco implements Articolo {
	
	private String codice;
	private int costoUnitario;
	
	public Disco(String codice, int costoUnitario) {
		this.codice = codice;
		this.costoUnitario = costoUnitario;
	}
	
	@Override
	public String getCodice(){ return this.codice; }
	
	@Override
	public int getCostoUnitario(){ return this.costoUnitario; }
	
	public boolean equals(Object o) {
		Disco d = (Disco)o;
		return this.codice.equals(d.getCodice());
	}
	
	public int hashCode() { return this.codice.hashCode(); }
}