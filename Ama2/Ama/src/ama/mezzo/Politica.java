package ama.mezzo;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public abstract class Politica {
	
	private Citta citta;
	
	private int id;
	
	public Politica(Citta citta, int id) {
		this.citta = citta;
		this.id = id;
	}
	
	public Citta getCitta() {
		return this.citta;
	}
	
	public abstract Posizione decidiDirezione(Posizione corrente);
	
	public int getId() {
		return this.id;
	}
	
	public abstract Image getImmagine();
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}
