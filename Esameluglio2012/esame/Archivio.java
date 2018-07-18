package esame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Archivio {
	
	private String nome;
	private String dataCreazione;
	private Map<String, PermessoAccesso> permessi;
	
	public Archivio(String nome, String dataCreazione, PermessoAccesso permessoAccesso) {
		this.nome = nome;
		this.dataCreazione = dataCreazione;
		this.permessi = new HashMap<String, PermessoAccesso>();
		this.permessi.put(permessoAccesso.getNome(), permessoAccesso);
	}
	
	public String getDataCreazione() {
		return this.dataCreazione;
	}

	public String getNome() {
		return this.nome;
	}
	
	public PermessoAccesso getPermessoAccesso(String nomePermesso) {
		return this.permessi.get(nomePermesso);
	}
	
	public abstract int getDimensione();
	
	public abstract List<Archivio> archiviCreatiIl(String data);

}
