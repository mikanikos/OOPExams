package esame;

public class GestoreAccessi {
	
	static public boolean haPermesso(Utente utente, Archivio arc, String nomePermesso) {
		return (arc.getPermessoAccesso(nomePermesso).haPermesso(utente));
	}
		
}
