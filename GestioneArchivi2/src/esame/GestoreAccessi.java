package esame;

public class GestoreAccessi {
	
	static public boolean haPermesso(Utente utente, Documento doc, String nomePermesso) {
		return (doc.getPermessoAccesso(nomePermesso).haPermesso(utente));
	}

	static public boolean haPermesso(Utente utente, Cartella cartella, String nomePermesso) {
		return (cartella.getPermessoAccesso(nomePermesso).haPermesso(utente));
	}
		
}
