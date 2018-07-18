import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Società implements Comparable<Società> {
	
	private int annoDiCostituzione;
	private String nazione;
	private String nome;
	private Set<Dipendente> dipendenti;
	
	public Società (int annoCostituzione, String nazione, String nome) {
		this.annoDiCostituzione = annoCostituzione;
		this.nazione = nazione;
		this.nome = nome;
		this.dipendenti = new HashSet<Dipendente>();
	}
	
	public int getAnnoDiCostituzione(){ return this.annoDiCostituzione;}

	public String getNazione() { return this.nazione; }
	
	public String getNome() { return this.nome; }
	
	public Set<Dipendente> getDipendenti() { return this.dipendenti; } 
	
	public void aggiungiDipendente(Dipendente dipendente) {
		this.dipendenti.add(dipendente); 
	}
	
	@Override
	public int compareTo(Società that) {
		return this.getAnnoDiCostituzione() - that.getAnnoDiCostituzione();
	}
	
	public abstract int getNumeroDipendenti ();
	
	public abstract Map<String, List<Società>> nazione2consorziate();
}
