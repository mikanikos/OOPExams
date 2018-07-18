package esame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cartella extends Archivio {

	private Set<Archivio> archivi;

	public Cartella(String nome, String dataCreazione, PermessoAccesso permessoAccesso) {
		super(nome, dataCreazione, permessoAccesso);
		this.archivi = new HashSet<Archivio>();
	}

	public int getDimensione() {
		int dimensioni = 0;
		for(Archivio a: this.archivi)
			dimensioni += a.getDimensione();
		return dimensioni;
	}

	public boolean addDocumento(Archivio archivio) {
		return this.archivi.add(archivio);
	}

	@Override
	public List<Archivio> archiviCreatiIl(String data) {
		List<Archivio> lista = new ArrayList<>();
		if(this.getDataCreazione().equals(data))
			lista.add(this);
		for(Archivio a : this.archivi)
			lista.addAll(a.archiviCreatiIl(data));
		return lista;
	}

}
