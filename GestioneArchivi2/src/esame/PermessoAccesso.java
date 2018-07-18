package esame;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PermessoAccesso {
	private String nomePermesso;
	private Set<Utente> utenti;
	
	public PermessoAccesso(String nomePermesso) {
		this.nomePermesso = nomePermesso;
		this.utenti = new HashSet<Utente>();
	}
	
	public String getNome(){
		return this.nomePermesso;
	}

	public boolean addUtente(Utente utente) {
		return this.utenti.add(utente);
	}
	
	public boolean haPermesso(Utente utente) {
		return this.utenti.contains(utente);
	}
	
	public Set<Utente> getUtenti(){
		return Collections.unmodifiableSet(this.utenti);
	}
}