package ama.mezzo;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public abstract class Politica {
	
	private int id;

	private Citta citta;
	
	public Politica(Citta citta, int id) {
		this.id = id;
		this.citta = citta;
	}
	
	public Citta getCitta() {
		return this.citta;
	}
	
	public int getId() {
		return this.id;
	}

	public abstract Posizione decidiDirezione(Posizione p);

	public abstract Image getImmagine();

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
}
