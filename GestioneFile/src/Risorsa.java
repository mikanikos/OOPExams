import java.util.*;

public abstract class Risorsa implements Comparable<Risorsa>{

	private String nome;
	private String proprietario;
	
	public Risorsa(String nome, String proprietario) {
		this.nome = nome;
		this.proprietario = proprietario;
	}
	
	public String getNome() { return this.nome; }
	
	public String getProprietario() { return this.proprietario; }
	
	public abstract int getDimensione();
	
	public void setProprietario(String proprietario) { this.proprietario = proprietario; }
	
	public abstract Map<String, Set<Risorsa>> proprietario2risorsa();
	
	public int hashCode() { return this.nome.hashCode(); }
	
	public boolean equals(Object obj) {
		Risorsa risorsa = (Risorsa)obj;
		return this.nome.equals(risorsa.getNome());
	}
	
	@Override
	public int compareTo(Risorsa r) {
		return this.getNome().compareTo(r.getNome());
	}

} 