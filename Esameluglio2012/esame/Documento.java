package esame;

import java.util.ArrayList;
import java.util.List;

public class Documento extends Archivio {
	
	private int dimensione;
	
	public Documento(String nome, int dimensione, String dataCreazione, PermessoAccesso permessoAccesso) {
		super(nome, dataCreazione, permessoAccesso);
		this.dimensione = dimensione;
	}
	
	@Override
	public int getDimensione() {
		return this.dimensione;
	}
		
	@Override
	public List<Archivio> archiviCreatiIl(String data) {
		List<Archivio> lista = new ArrayList<>();
		if(this.getDataCreazione().equals(data))
			lista.add(this);
		return lista;
	}

}
