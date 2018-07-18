import java.util.*;

public abstract class Risorsa {

	private Utente proprietario;
	private String nome;
	private Map<Permesso, Set<Utente>> permessi;

	public Risorsa(String nome, Utente proprietario) {
		this.nome = nome;
		this.proprietario = proprietario;
		this.permessi = new HashMap<>();
	}

	public Utente getProprietario() {
		return this.proprietario;
	}

	public String getNome() {
		return this.nome;
	}

	public abstract int getDimensioni();

	public boolean haIlPermesso(Permesso permesso, Utente utente) {
		Set<Utente> insiemeUtenti = this.permessi.get(permesso);
		if(insiemeUtenti == null)
			return false;
		return this.permessi.get(permesso).contains(utente);
	}

	public void concediPermesso(Permesso permesso, Utente utente) {
		Set<Utente> insiemeUtenti = this.permessi.get(permesso);
		if(insiemeUtenti == null) {
			insiemeUtenti = new HashSet<>();
			this.permessi.put(permesso, insiemeUtenti);
		}
		insiemeUtenti.add(utente);
	} 
	
	public List<Permesso> permessiDi(Utente utente) {
		List<Permesso> permessiUtente = new ArrayList<>();
		for(Permesso p : this.permessi.keySet())
			if(this.permessi.get(p).contains(utente))
				permessiUtente.add(p);
		Collections.sort(permessiUtente, new ComparatoreAlfabetico());
		return permessiUtente;
	}

}
