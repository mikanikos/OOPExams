import java.util.*;

public class Libro {
	
	private Set<Autore> autori;
	private String titolo;
	
	public Libro(String titolo) {
		this.titolo = titolo;
		this.autori = new HashSet<Autore>();
	}
	
	public void addAutore(Autore autore){
		this.autori.add(autore);
		autore.aggiungiLibroPubblicato();
	}
	
	public Set<Autore> getAutori() {
		return Collections.unmodifiableSet(this.autori);
	}
	
	public String getTitolo(){
		return this.titolo;
	}

	@Override
	public int hashCode() {
		return this.getTitolo().hashCode() + this.getAutori().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		Libro that = (Libro) o;
		return this.getTitolo().equals(that.getTitolo()) && this.getAutori().equals(that.getAutori());
	}
	
	
}